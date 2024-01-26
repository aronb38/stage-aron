package com.orange.archhelloworld.data.repositories

import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class PlaceHolderRepositoryTest {

    @InjectMockKs
    private lateinit var sut: PlaceHolderRepository

    @BeforeEach
    fun setUp() {
        // Prerequisites
    }

    @AfterEach
    fun tearDown() {
        // Cleaning : for example unmocking static dependencies
    }

    @DisplayName("Test getHelloWorld")
    @Nested
    inner class HelloWorld {


        @DisplayName("Success")
        @Test
        fun getHelloWorldSuccess() = runTest {
            val helloWorldString = "Hello Practice Mobile"

            val result = sut.getHelloWorld().first()

            helloWorldString shouldBe result

        }

        @DisplayName("Failure")
        @Test
        fun getHelloWorldFailure() = runTest {
            val helloWorldString = "Hello Practice"

            val result = sut.getHelloWorld().first()

            helloWorldString shouldNotBe result
        }
    }
}