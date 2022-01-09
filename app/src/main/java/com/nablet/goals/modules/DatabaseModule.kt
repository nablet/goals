package com.nablet.goals.modules

import android.content.Context
import androidx.room.Room
import com.nablet.goals.models.Constants.GoalsDatabase.DATABASE_NAME
import com.nablet.goals.repository.goals_db.GoalDao
import com.nablet.goals.repository.goals_db.GoalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
	
	@Singleton
	@Provides
	fun provideGoalDatabase(@ApplicationContext context: Context): GoalDatabase {
		return Room.databaseBuilder(
			context.applicationContext,
			GoalDatabase::class.java,
			DATABASE_NAME
		).fallbackToDestructiveMigration().build()
	}
	
	@Singleton
	@Provides
	fun bindGoalDao(database: GoalDatabase): GoalDao {
		return database.goalDao()
	}
	
}
