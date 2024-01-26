package com.orange.archhelloworld.featureplaceholder.ui

import com.orange.archhelloworld.coretesting.extensions.DispatcherExtension
import com.orange.archhelloworld.featureplaceholder.domain.usecase.IPlaceHolderUseCase
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
@ExtendWith(DispatcherExtension::class)
class PlaceHolderViewModelTest {

    @MockK
    private lateinit var placeHolderUseCase: IPlaceHolderUseCase

    @InjectMockKs
    private lateinit var sut: PlaceHolderViewModel

    @Test
    fun `displayHelloWorld$featureplaceholder_debug`() = runTest {
        val messageMock = "Blip blop blip"
        coEvery { placeHolderUseCase.getHelloWorld() } returns flow {
            emit(messageMock)
        }

        sut.onScreenDisplayed()
        val result = sut.placeHolderUiState.value as PlaceHolderUiState.Success

        coVerify(exactly = 1) { placeHolderUseCase.getHelloWorld() }
        messageMock shouldBe result.message
    }


}