package com.nablet.goals.repository.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface GoalDao {
	
	@Query("SELECT * FROM goal")
	fun getGoals(): Flow<List<Goal>>
	
	@Insert
	suspend fun addGoal(goal: Goal)
	
}
