package com.nablet.goals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.nablet.goals.repository.MainRepository
import com.nablet.goals.repository.MainRepositoryImpl
import com.nablet.goals.repository.room.Goal
import com.nablet.goals.repository.room.GoalDatabase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
	
	private val database by lazy { GoalDatabase.getDatabase(this) }
	private val repository by lazy { MainRepositoryImpl(database.goalDao()) }
	
	private val viewModel by lazy { MainViewModel(repository) }
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		val sampleGoal = Goal(
			"GoalTitle",
			"Detaillsasadd",
			true
		)
		
		viewModel.goals.observe(this, Observer {
			Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show()
		})
	}
	
}
