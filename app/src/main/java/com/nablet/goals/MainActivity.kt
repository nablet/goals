package com.nablet.goals

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
	
	val viewModel: MainViewModel by viewModels()
	
	override fun onStart() {
		super.onStart()
	}
	
}
