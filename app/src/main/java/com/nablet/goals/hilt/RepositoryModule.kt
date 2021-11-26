package com.nablet.goals.hilt

import com.nablet.goals.repository.MainRepository
import com.nablet.goals.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
	
	@Singleton
	@Binds
	abstract fun bindRepositoryService(
		repositoryServiceImpl: MainRepositoryImpl
	): MainRepository
	
}
