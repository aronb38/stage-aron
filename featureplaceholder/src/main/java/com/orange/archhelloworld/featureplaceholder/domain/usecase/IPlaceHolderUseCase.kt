package com.orange.archhelloworld.featureplaceholder.domain.usecase

import kotlinx.coroutines.flow.Flow

fun interface IPlaceHolderUseCase {

    fun getHelloWorld() : Flow<String>

}