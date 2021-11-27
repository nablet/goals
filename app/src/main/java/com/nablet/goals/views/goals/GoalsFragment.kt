package com.nablet.goals.views.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nablet.goals.MainViewModel
import com.nablet.goals.R
import com.nablet.goals.databinding.FragmentGoalsBinding
import com.pawegio.kandroid.e
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GoalsFragment : Fragment() {
	
	private val viewModel: MainViewModel by viewModels()
	private lateinit var adapter: GoalsAdapter
	
	override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
		val binding = DataBindingUtil.inflate<FragmentGoalsBinding>(
            inflater,
            R.layout.fragment_goals,
            container,
            false
        )
		binding.viewModel = viewModel
		binding.lifecycleOwner = viewLifecycleOwner
		
		setupViews(binding)
		setupObservers()
		
		return binding.root
	}
	
	private fun setupViews(binding: FragmentGoalsBinding) {
		// Setup goals recyclerview
		adapter = GoalsAdapter()
		binding.rcvGoals.layoutManager = LinearLayoutManager(context)
		binding.rcvGoals.adapter = adapter
	}
	
	private fun setupObservers() {
		viewModel.goals.observe(viewLifecycleOwner, {
			e(it.toString())
			adapter.submitList(it)
		})
	}
}
