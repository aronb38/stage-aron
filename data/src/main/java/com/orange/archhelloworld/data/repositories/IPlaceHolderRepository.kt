package com.orange.archhelloworld.data.repositories

import kotlinx.coroutines.flow.Flow

fun interface IPlaceHolderRepository {

    fun getHelloWorld(): Flow<String>

}