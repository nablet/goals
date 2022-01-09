package com.nablet.goals.views.goals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nablet.goals.MainViewModel
import com.nablet.goals.commons.bases.ViewBindingFragment
import com.nablet.goals.commons.utils.observeWithLifecycle
import com.nablet.goals.databinding.DialogAddNewGoalBinding
import com.nablet.goals.databinding.FragmentGoalsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GoalsFragment : ViewBindingFragment<FragmentGoalsBinding>() {
	
	override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentGoalsBinding
		get() = FragmentGoalsBinding::inflate
	
	private val viewModel: MainViewModel by viewModels()
	private var addGoalDialog: AlertDialog? = null
	private lateinit var adapter: GoalsAdapter
	
	override fun setup() {
		binding.view = this
		binding.viewModel = viewModel
		binding.lifecycleOwner = viewLifecycleOwner
		setupGoalsList()
	}
	
	fun openAddGoalDialog() {
		val dialog = AlertDialog.Builder(requireContext()).create()
		val view = DialogAddNewGoalBinding.inflate(layoutInflater)
		dialog.apply {
			view.viewModel = viewModel
			setView(view.root)
			show()
			addGoalDialog = this
		}
	}
	
	private fun setupGoalsList() {
		// Setup goals recyclerview
		adapter = GoalsAdapter { viewModel.delete(goal = it) }
		binding.rcvGoals.layoutManager = LinearLayoutManager(context)
		binding.rcvGoals.adapter = adapter
		
		viewModel.goals.observeWithLifecycle(viewLifecycleOwner) {
			adapter.submitList(it)
			addGoalDialog?.dismiss()
		}
	}
	
}
