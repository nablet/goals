package com.nablet.goals

import androidx.lifecycle.ViewModel
import com.nablet.goals.repository.sharedprefs.Prefs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val prefs: Prefs
): ViewModel() {
    
}