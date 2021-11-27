package com.nablet.goals.views.settings

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nablet.goals.MainViewModel
import com.nablet.goals.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SettingsFragment : Fragment(R.layout.fragment_settings) {
	
	private val viewModel: MainViewModel by viewModels()
	
}
