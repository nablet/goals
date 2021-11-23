package com.nablet.goals.repository.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Goal(
	val title: String,
	val details: String,
	val isAchieved: Boolean
) {
	@PrimaryKey(autoGenerate = true)
	var id: Int = 0
}