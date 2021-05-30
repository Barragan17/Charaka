package com.example.charaka.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.bumptech.glide.load.engine.Resource
import com.example.charaka.data.remote.ApiResponse
import com.example.charaka.data.remote.StatusResponse
import com.example.charaka.utils.AppExecutors
import com.example.charaka.vo.Resource.Companion.error
import com.example.charaka.vo.Resource.Companion.loading
import com.example.charaka.vo.Resource.Companion.success

abstract class NetworkBoundResource<ResultType, RequestType>(private val mExecutors: AppExecutors) {

    private val result = MediatorLiveData<com.example.charaka.vo.Resource<ResultType>>()

    init {
        result.value = loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDB()

        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { newData ->
                    result.value = success(newData)
                }
            }
        }
    }

    protected fun onFetchFailed() {}

    protected abstract fun loadFromDB(): LiveData<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {

        val apiResponse = createCall()

        result.addSource(dbSource) { newData ->
            result.value = loading(newData)
        }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when (response.status) {
                StatusResponse.SUCCESS ->
                    mExecutors.diskIO().execute {
                        saveCallResult(response.body)
                        mExecutors.mainThread().execute {
                            result.addSource(loadFromDB()) { newData ->
                                result.value = success(newData)
                            }
                        }
                    }
                StatusResponse.EMPTY -> mExecutors.mainThread().execute {
                    result.addSource(loadFromDB()) { newData ->
                        result.value = success(newData)
                    }
                }
                StatusResponse.ERROR -> {
                    onFetchFailed()
                    result.addSource(dbSource) { newData ->
                        result.value = error(response.message, newData)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<com.example.charaka.vo.Resource<ResultType>> = result
}