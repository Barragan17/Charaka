package com.example.charaka.data.remote.response

import com.google.gson.annotations.SerializedName

data class BookResponse(

	@field:SerializedName("totalItems")
	val totalItems: Int?,

	@field:SerializedName("kind")
	val kind: String?,

	@field:SerializedName("items")
	val items: List<ItemsItem>?
)

data class ItemsItem(

		@field:SerializedName("volumeInfo")
		val volumeInfo: VolumeInfo?,

		@field:SerializedName("id")
		val id: String?,
)

data class ImageLinks(

	@field:SerializedName("thumbnail")
	val thumbnail: String?,

	@field:SerializedName("smallThumbnail")
	val smallThumbnail: String?
)

data class VolumeInfo(

	@field:SerializedName("pageCount")
	val pageCount: Int?,

	@field:SerializedName("description")
	val description: String?,

	@field:SerializedName("title")
	val title: String?,

	@field:SerializedName("imageLinks")
	val imageLinks: ImageLinks?,

	@field:SerializedName("maturityRating")
	val maturityRating: String?,

	@field:SerializedName("averageRating")
	val averageRating: Float?,

	@field:SerializedName("authors")
	val authors: List<String?>?,
)

