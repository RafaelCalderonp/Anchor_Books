package com.example.anchorbooks.model

import com.example.anchorbooks.model.local.entities.BookDetailEntity
import com.example.anchorbooks.model.local.entities.BooksEntity
import com.example.anchorbooks.model.remote.fromInternet.BookDetail
import com.example.anchorbooks.model.remote.fromInternet.BooksList

fun fromInternetToBooksEntity(booksList: List<BooksList>): List<BooksEntity> {
    return booksList.map {
        BooksEntity(id = it.id, author = it.author, country = it.country, imageLink = it.imageLink,
            language = it.language, title = it.title)
    }
}

fun fromInternetToBookDetailEntity(book: BookDetail) : BookDetailEntity{
       return BookDetailEntity(id= book.id, author = book.author, country = book.country,
        delivery = book.delivery, imageLink = book.imageLink, language = book.language,
        lastPrice = book.lastPrice, link = book.link, pages = book.pages,
        price = book.price, title = book.title, year= book.year )
}