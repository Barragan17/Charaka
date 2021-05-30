package com.example.charaka.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.charaka.data.local.entity.Book
import com.example.charaka.data.local.entity.Post

@Database(entities = [Book::class, Post::class], version = 1, exportSchema = false)

abstract class DataDatabase: RoomDatabase() {

    abstract fun dataDao(): DataDao

}