package com.example.anchorbooks.model.local.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.anchorbooks.model.local.BooksDao
import com.example.anchorbooks.model.local.entities.BookDetailEntity
import com.example.anchorbooks.model.local.entities.BooksEntity


@Database(entities = [BooksEntity::class, BookDetailEntity::class], version = 1, exportSchema = false)
abstract class BooksDataBase : RoomDatabase() {

    abstract fun getBooksDao() : BooksDao

    companion object{
        @Volatile
        private var
                INSTANCE : BooksDataBase? = null
        fun getDataBase(context: Context) : BooksDataBase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BooksDataBase::class.java, "books_db")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}