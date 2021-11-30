package com.nablet.goals.repository

import com.nablet.goals.models.Goal
import com.nablet.goals.repository.goals_db.GoalDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface MainRepository {
	val goals: Flow<List<Goal>>
	suspend fun existsInTable(title: String): Boolean
	suspend fun addGoal(goal: Goal)
	suspend fun deleteGoal(id: Int)
}

class MainRepositoryImpl @Inject constructor(
	private val goalDao: GoalDao
) : MainRepository {
	
	override val goals: Flow<List<Goal>>
		get() = goalDao.getGoals()
	
	override suspend fun existsInTable(title: String): Boolean {
		return goalDao.existsInTable(title) == 1
	}
	
	override suspend fun addGoal(goal: Goal) {
		goalDao.addGoal(goal)
	}
	
	override suspend fun deleteGoal(id: Int) {
		goalDao.deleteGoal(id)
	}
	
}
