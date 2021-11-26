package com.nablet.goals.repository

import com.nablet.goals.models.Goal
import com.nablet.goals.repository.room.GoalDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface MainRepository {
	val goals: Flow<List<Goal>>
	suspend fun addGoal(goal: Goal)
}

class MainRepositoryImpl @Inject constructor(
	private val goalDao: GoalDao
) : MainRepository {
	
	override val goals: Flow<List<Goal>>
		get() = goalDao.getGoals()
	
	override suspend fun addGoal(goal: Goal) {
		goalDao.addGoal(goal)
	}
	
}
