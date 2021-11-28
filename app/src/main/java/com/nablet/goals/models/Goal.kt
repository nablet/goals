package com.nablet.goals.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = Constants.TABLE_GOALS_NAME)
data class Goal(
	val title: String,
	val details: String,
	val isAchieved: Boolean
) {
	@PrimaryKey(autoGenerate = true)
	var id: Int = 0
	var dateAdded: Long = System.currentTimeMillis()
}
