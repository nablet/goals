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
	
	suspend fun addGoal(goal: Goal) = viewModelScope.launch {
		repository.addGoal(goal)
	}
	
}
