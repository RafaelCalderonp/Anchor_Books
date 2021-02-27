package com.example.anchorbooks.model

import android.util.Log
import com.example.anchorbooks.model.local.BooksDao
import com.example.anchorbooks.model.remote.RetrofitClient
import kotlin.jvm.internal.Intrinsics

class BooksRepository (private val booksDao: BooksDao){

    private val networkService = RetrofitClient.retrofitInstance()
    val booksListLiveData = booksDao.getAllBooks()

    suspend fun fetchBooks(){
        val service = kotlin.runCatching { networkService.fetchBooksList() }
        service.onSuccess {
            Log.d("REPO", "ENTRE")
            when(it.code()){
                200 -> it.body()?.let {
                    booksDao.insertAllBooks(fromInternetToBooksEntity(it))
                }
                else -> Log.d("REPO","${it.code()} - ${it.errorBody()}")
            }
        }
        service.onFailure {
            Log.e("REPO","${it.message}")
        }
    }

    suspend fun fetchBooksDetail(id: Int) {
        val service = kotlin.runCatching { networkService.fetchBookDetail(id) }
        service.onSuccess {
            when(it.code()){
                200 -> it.body()?.let {
                    booksDao.insertBookDetail(fromInternetToBookDetailEntity(it))
                }
            }
        }
    }



}