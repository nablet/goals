package com.nablet.goals

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.nablet.goals.repository.MainRepository
import com.nablet.goals.repository.room.Goal
import com.nablet.goals.repository.sharedprefs.Prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel(
    private val repository: MainRepository
): ViewModel() {

    val goals: LiveData<List<Goal>>
        get() = repository.goals.asLiveData()

    fun addGoal(goal: Goal) = viewModelScope.launch {
        repository.addGoal(goal)
    }

}