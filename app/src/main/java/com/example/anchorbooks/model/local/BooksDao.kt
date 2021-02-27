package com.example.anchorbooks.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.anchorbooks.model.local.entities.BookDetailEntity
import com.example.anchorbooks.model.local.entities.BooksEntity


@Dao
interface BooksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertAllBooks(listBooks: List<BooksEntity>)

    @Query("SELECT * FROM books_list_table ORDER BY id ASC")
    fun getAllBooks(): LiveData<List<BooksEntity>>


//__________________________________________________________________________________________________

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertBookDetail(Books: BookDetailEntity)

    @Query("SELECT * FROM  book_detail_table WHERE id = :id")
    fun getBookDetailByID(id: Int) : BookDetailEntity

}