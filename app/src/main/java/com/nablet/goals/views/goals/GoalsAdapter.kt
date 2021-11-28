package com.nablet.goals.views.goals

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nablet.goals.databinding.ItemGoalBinding
import com.nablet.goals.models.Goal
import com.pawegio.kandroid.layoutInflater


class GoalsAdapter : ListAdapter<Goal, GoalsAdapter.GoalViewHolder>(GoalsDiffCallback()) {
	
	inner class GoalViewHolder(
		private val binding: ItemGoalBinding
	) : RecyclerView.ViewHolder(binding.root) {
		fun bind(goalItem: Goal) {
			binding.goal = goalItem
			binding.executePendingBindings()
		}
	}
	
	class GoalsDiffCallback : DiffUtil.ItemCallback<Goal>() {
		override fun areItemsTheSame(oldItem: Goal, newItem: Goal) = oldItem == newItem
		override fun areContentsTheSame(oldItem: Goal, newItem: Goal) = oldItem.id == newItem.id
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalsAdapter.GoalViewHolder {
		val binding = ItemGoalBinding.inflate(parent.context.layoutInflater!!, parent, false)
		return GoalViewHolder(binding)
	}
	
	override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
		holder.bind(getItem(position))
	}
	
}
