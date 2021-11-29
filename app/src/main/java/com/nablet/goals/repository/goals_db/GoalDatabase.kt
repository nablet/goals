package com.nablet.goals.repository.goals_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nablet.goals.models.Goal


@Database(entities = [Goal::class], version = 3, exportSchema = false)
abstract class GoalDatabase : RoomDatabase() {
	abstract fun goalDao(): GoalDao
}
