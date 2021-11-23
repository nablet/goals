package com.nablet.goals.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@Database(entities = [Goal::class], version = 1, exportSchema = false)
abstract class GoalDatabase : RoomDatabase() {

    @Inject
    abstract fun goalDao() : GoalDao

}