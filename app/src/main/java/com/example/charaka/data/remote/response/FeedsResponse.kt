package com.example.charaka.data.remote.response

import com.google.gson.annotations.SerializedName

data class FeedsResponse(

	@field:SerializedName("docs")
	val docs: List<DocsItem>? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class Bookdoc(

	@field:SerializedName("ratings_2")
	val ratings2: String? = null,

	@field:SerializedName("ratings_1")
	val ratings1: String? = null,

	@field:SerializedName("work_id")
	val workId: String? = null,

	@field:SerializedName("ratings_4")
	val ratings4: String? = null,

	@field:SerializedName("ratings_3")
	val ratings3: String? = null,

	@field:SerializedName("books_count")
	val booksCount: String? = null,

	@field:SerializedName("original_title")
	val originalTitle: String? = null,

	@field:SerializedName("ratings_5")
	val ratings5: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("isbn")
	val isbn: String? = null,

	@field:SerializedName("average_rating")
	val averageRating: String? = null,

	@field:SerializedName("original_publication_year")
	val originalPublicationYear: String? = null,

	@field:SerializedName("book_id")
	val bookId: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("best_book_id")
	val bestBookId: String? = null,

	@field:SerializedName("language_code")
	val languageCode: String? = null,

	@field:SerializedName("work_ratings_count")
	val workRatingsCount: String? = null,

	@field:SerializedName("small_image_url")
	val smallImageUrl: String? = null,

	@field:SerializedName("work_text_reviews_count")
	val workTextReviewsCount: String? = null,

	@field:SerializedName("isbn13")
	val isbn13: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("ratings_count")
	val ratingsCount: String? = null,

	@field:SerializedName("authors")
	val authors: String? = null
)

data class Doc(

	@field:SerializedName("book")
	val book: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("book_id")
	val bookId: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)

data class DocsItem(

	@field:SerializedName("bookdoc")
	val bookdoc: Bookdoc? = null,

	@field:SerializedName("doc")
	val doc: Doc? = null,

	@field:SerializedName("id")
	val id: String? = null
)
