package com.example.anchorbooks.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.anchorbooks.model.BooksRepository
import com.example.anchorbooks.model.local.dataBase.BooksDataBase
import kotlinx.coroutines.launch

class BooksViewModel (application: Application): AndroidViewModel(application){

    private val repository : BooksRepository

    init {
        val db = BooksDataBase.getDataBase(application)
        val booksDao = db.getBooksDao()
        repository = BooksRepository(booksDao)
        viewModelScope.launch {
            repository.fetchBooks()
        }

    }
}