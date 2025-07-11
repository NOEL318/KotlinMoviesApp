package com.example.test.data.source.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.test.data.dao.MovieDao
import com.example.test.data.entity.LatestMoviesEntity
import com.example.test.data.entity.PopularMoviesEntity

@Database(
    entities = [LatestMoviesEntity::class, PopularMoviesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        @Volatile
        private var INSTANCE: MoviesDatabase? = null

        fun getDatabase(context: Context): MoviesDatabase {
            return INSTANCE ?: synchronized(this) {
                // Hago la creacion(instanciacion y build) de mi bd local
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MoviesDatabase::class.java,
                    "movies_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}