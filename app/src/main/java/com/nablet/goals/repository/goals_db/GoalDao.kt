package com.nablet.goals.repository.goals_db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nablet.goals.models.Constants.GoalsDatabase.TABLE_NAME
import com.nablet.goals.models.Goal
import kotlinx.coroutines.flow.Flow


@Dao
interface GoalDao {
	
	@Query("SELECT * FROM $TABLE_NAME")
	fun getGoals(): Flow<List<Goal>>
	
	@Query("SELECT EXISTS(SELECT 1 FROM $TABLE_NAME WHERE title = :title LIMIT 1)")
	suspend fun existsInTable(title: String): Int
	
	@Insert
	suspend fun addGoal(goal: Goal)
	
	@Query("DELETE FROM $TABLE_NAME WHERE id = :id")
	suspend fun deleteGoal(id: Int)
	
}
