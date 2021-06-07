package com.example.charaka.data.remote.response

import com.google.gson.annotations.SerializedName

data class PostResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: Data? = null
)

data class Data(

	@field:SerializedName("book_id")
	val bookId: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("userid")
	val userid: String? = null,

	@field:SerializedName("desc")
	val desc: String? = null
)
