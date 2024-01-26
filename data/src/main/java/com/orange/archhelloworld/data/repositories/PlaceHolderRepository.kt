package com.orange.archhelloworld.data.repositories

import com.orange.archhelloworld.data.repositories.IPlaceHolderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlaceHolderRepository @Inject constructor(): IPlaceHolderRepository {

    override fun getHelloWorld(): Flow<String> {

        // In real cases repository should access a remote or local datasource

        return flow {
            emit("Hello Practice Mobile")
        }
    }

}