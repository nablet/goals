package com.nablet.goals

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.nablet.goals.repository.MainRepositoryImpl
import com.nablet.goals.repository.room.GoalDatabase
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity(R.layout.activity_main) {
	
	val viewModel: MainViewModel by lazy { MainViewModel(MainRepositoryImpl(GoalDatabase.getDatabase(this).goalDao())) }
	
	override fun onStart() {
		super.onStart()
		
		viewModel.goals.observe(this, Observer {
		
		})
	}
	
}
