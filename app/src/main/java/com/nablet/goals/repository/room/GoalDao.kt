package com.nablet.goals.repository.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nablet.goals.models.Constants
import com.nablet.goals.models.Constants.GoalsDatabase.TABLE_NAME
import com.nablet.goals.models.Goal
import kotlinx.coroutines.flow.Flow


@Dao
interface GoalDao {
	
	@Query("SELECT * FROM $TABLE_NAME")
	fun getGoals(): Flow<List<Goal>>
	
	@Insert
	suspend fun addGoal(goal: Goal)
	
	@Query("DELETE FROM $TABLE_NAME WHERE id = :id")
	suspend fun deleteGoal(id: Int)
	
}
