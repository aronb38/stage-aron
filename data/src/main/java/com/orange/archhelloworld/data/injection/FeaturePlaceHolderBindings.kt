package com.orange.archhelloworld.data.injection

import com.orange.archhelloworld.data.repositories.IPlaceHolderRepository
import com.orange.archhelloworld.data.repositories.PlaceHolderRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface FeaturePlaceHolderBindings {

    ///////////////////////////////////////////////////////////////////////////
    // Repositories
    ///////////////////////////////////////////////////////////////////////////
    @Binds
    @Singleton
    fun getPlaceHolderRepository(placeHolderRepository: PlaceHolderRepository): IPlaceHolderRepository

}