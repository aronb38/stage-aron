package com.orange.archhelloworld.featureplaceholder.domain.usecase

import com.orange.archhelloworld.data.repositories.IPlaceHolderRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlaceHolderUseCase @Inject constructor(
    private val placeHolderRepository: IPlaceHolderRepository
) : IPlaceHolderUseCase {
    override fun getHelloWorld(): Flow<String> {
        return placeHolderRepository.getHelloWorld()
    }
}