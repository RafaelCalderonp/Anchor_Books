package com.example.anchorbooks.model.remote

import com.example.anchorbooks.model.remote.fromInternet.BookDetail
import com.example.anchorbooks.model.remote.fromInternet.BooksList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksAPI {

    @GET("books")
    suspend fun fetchBooksList(): Response<List<BooksList>>

//____________________________________________________________________________

    @GET("bookDetail/{id}")
    suspend fun fetchBookDetail(@Path("id")id: Int): Response<BookDetail>
}