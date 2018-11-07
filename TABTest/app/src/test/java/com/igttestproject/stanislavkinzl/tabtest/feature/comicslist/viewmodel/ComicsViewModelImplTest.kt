package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.igttestproject.stanislavkinzl.tabtest.app.model.Comic
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.domain.FetchComicsUseCase
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.repository.ComicRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ComicsViewModelImplTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    
    @Mock private lateinit var mockRepository: ComicRepository

    private lateinit var subject: ComicsViewModelImpl

    @Mock private lateinit var mockFetchComicsUseCase: FetchComicsUseCase

    private val testComicsList: List<Comic> = listOf(
            Comic("TestC", "TestUrl", 10),
            Comic(name = "TestC", url = "TestUrl", pageCount = 10)
    )

    @Before
    fun setUp() {
        subject = ComicsViewModelImpl(mockFetchComicsUseCase)
    }

    @Test
    fun `onFetchComicsResult() - Success`() {
        subject.onFetchComicsResult(FetchComicsUseCase.Result.Success(testComicsList))
        assertThat(subject.state().value).isEqualTo(ComicsViewModel.State.FetchMemesSuccess(testComicsList))
    }

    @Test
    fun `onFetchComicsResult() - Error`() {
        subject.onFetchComicsResult(FetchComicsUseCase.Result.Error)
        assertThat(subject.state().value).isEqualTo(ComicsViewModel.State.FetchMemesError)
    }


}