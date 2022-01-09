package com.nablet.goals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nablet.goals.models.Goal
import com.nablet.goals.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
	private val repository: MainRepository
) : ViewModel() {
	
	val goals: StateFlow<List<Goal>?>
		get() = repository.goals.stateIn(viewModelScope, SharingStarted.Lazily, null)
	
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
