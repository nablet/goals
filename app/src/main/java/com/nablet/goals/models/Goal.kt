package com.nablet.goals.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.nablet.goals.models.Constants.GoalsDatabase.DATE_ADDED
import com.nablet.goals.models.Constants.GoalsDatabase.DETAILS
import com.nablet.goals.models.Constants.GoalsDatabase.ID
import com.nablet.goals.models.Constants.GoalsDatabase.IS_ACHIEVED
import com.nablet.goals.models.Constants.GoalsDatabase.TABLE_NAME
import com.nablet.goals.models.Constants.GoalsDatabase.TITLE


@Entity(
	tableName = TABLE_NAME,
	indices = [Index(value = [TITLE], unique = true)]
)
data class Goal(
	@ColumnInfo(name = TITLE)
	val title: String,
	@ColumnInfo(name = DETAILS)
	val details: String,
	@ColumnInfo(name = IS_ACHIEVED)
	val isAchieved: Boolean
) {
	
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = ID)
	var id: Int = 0
	
	@ColumnInfo(name = DATE_ADDED)
	var dateAdded: Long = System.currentTimeMillis()
}
