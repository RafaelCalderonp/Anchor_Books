package com.example.anchorbooks.model.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "book_detail_table")
data class BookDetailEntity(
    @PrimaryKey
    @NotNull
    val id: Int,
    val author: String,
    val country: String,
    val delivery: Boolean,
    val imageLink: String,
    val language: String,
    val lastPrice: Int,
    val link: String,
    val pages: Int,
    val price: Int,
    val title: String,
    val year: Int
)
