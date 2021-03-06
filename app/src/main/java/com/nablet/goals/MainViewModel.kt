package com.nablet.goals

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.nablet.goals.models.Goal
import com.nablet.goals.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
	private val repository: MainRepository
) : ViewModel() {
	
	val goals: LiveData<List<Goal>>
		get() = repository.goals.asLiveData()
	
	fun addGoal(title: String, details: String) = viewModelScope.launch {
		if (goals.value?.map { it.title }?.contains(title) == true) return@launch
		repository.addGoal(Goal(title, details))
	}
	
	fun delete(id: Int? = null, goal: Goal? = null) = viewModelScope.launch {
		when {
			id != null -> repository.deleteGoal(id)
			goal != null -> repository.deleteGoal(goal.id)
		}
	}
	
}
