package com.orange.archhelloworld.featureplaceholder.domain.usecase

import com.orange.archhelloworld.data.repositories.PlaceHolderRepository
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class PlaceHolderUseCaseTest {

    @MockK
    private lateinit var placeHolderRepository: PlaceHolderRepository

    @InjectMockKs
    private lateinit var sut: PlaceHolderUseCase

    @DisplayName("Test getHelloWorld")
    @Nested
    inner class HelloWorld {


        @DisplayName("Success")
        @Test
        fun getHelloWorldSuccess() = runTest {
            val helloWorldString = "Hello Practice Mobile"
            every { placeHolderRepository.getHelloWorld() } returns flowOf(helloWorldString)

            val result = sut.getHelloWorld().firstOrNull()

            helloWorldString shouldBe result

        }
    }
}