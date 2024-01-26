package com.orange.archhelloworld.featureplaceholder.injection

import com.orange.archhelloworld.featureplaceholder.domain.usecase.IPlaceHolderUseCase
import com.orange.archhelloworld.featureplaceholder.domain.usecase.PlaceHolderUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface FeaturePlaceHolderBindings {

    ///////////////////////////////////////////////////////////////////////////
    // Use cases
    ///////////////////////////////////////////////////////////////////////////
    @Binds
    @Singleton
    fun getPlaceHolderUseCase(placeHolderUseCase: PlaceHolderUseCase): IPlaceHolderUseCase
}