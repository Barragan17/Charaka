package com.example.charaka.data.remote.response

import com.google.gson.annotations.SerializedName

data class BooksResponse(

	@field:SerializedName("docs")
	val docs: List<Docs>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class Docs(

	@field:SerializedName("ratings_2")
	val ratings2: Int? = null,

	@field:SerializedName("work_id")
	val workId: Int? = null,

	@field:SerializedName("ratings_1")
	val ratings1: Int? = null,

	@field:SerializedName("ratings_4")
	val ratings4: Int? = null,

	@field:SerializedName("ratings_3")
	val ratings3: Int? = null,

	@field:SerializedName("books_count")
	val booksCount: Int? = null,

	@field:SerializedName("original_title")
	val originalTitle: String? = null,

	@field:SerializedName("ratings_5")
	val ratings5: Int? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("isbn")
	val isbn: String? = null,

	@field:SerializedName("average_rating")
	val averageRating: Double? = null,

	@field:SerializedName("book_id")
	val bookId: Int? = null,

	@field:SerializedName("original_publication_year")
	val originalPublicationYear: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("best_book_id")
	val bestBookId: Int? = null,

	@field:SerializedName("language_code")
	val languageCode: String? = null,

	@field:SerializedName("work_ratings_count")
	val workRatingsCount: Int? = null,

	@field:SerializedName("work_text_reviews_count")
	val workTextReviewsCount: Int? = null,

	@field:SerializedName("small_image_url")
	val smallImageUrl: String? = null,

	@field:SerializedName("isbn13")
	val isbn13: Long? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("ratings_count")
	val ratingsCount: Int? = null,

	@field:SerializedName("authors")
	val authors: String? = null
)
