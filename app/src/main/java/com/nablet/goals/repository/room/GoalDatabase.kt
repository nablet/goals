package com.nablet.goals.repository.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nablet.goals.models.Constants
import com.nablet.goals.models.Goal


@Database(entities = [Goal::class], version = 1, exportSchema = false)
abstract class GoalDatabase : RoomDatabase() {
	
	abstract fun goalDao(): GoalDao
	
	companion object {
		@Volatile
		private var INSTANCE: GoalDatabase? = null
		
		fun getDatabase(context: Context): GoalDatabase {
			return INSTANCE ?: synchronized(this) {
				val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GoalDatabase::class.java,
                    Constants.DATABASE_NAME
                ).build()
				INSTANCE = instance
				return@synchronized instance
			}
		}
	}
	
}
