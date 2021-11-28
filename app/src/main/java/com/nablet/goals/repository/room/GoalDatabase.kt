package com.nablet.goals.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nablet.goals.models.Goal


@Database(entities = [Goal::class], version = 2, exportSchema = false)
abstract class GoalDatabase : RoomDatabase() {
	abstract fun goalDao(): GoalDao
}
