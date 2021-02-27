package com.example.anchorbooks.model.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "books_list_table")
data class BooksEntity(
    @PrimaryKey
    @NotNull
    val id: Int,
    val author: String,
    val country: String,
    val imageLink: String,
    val language: String,
    val title: String,
    val favorites: Boolean = false
)
