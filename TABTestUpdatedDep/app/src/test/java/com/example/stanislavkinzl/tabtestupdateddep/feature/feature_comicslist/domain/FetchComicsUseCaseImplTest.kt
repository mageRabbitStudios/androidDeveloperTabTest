package com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.domain

import com.example.stanislavkinzl.tabtestupdateddep.app.SchedulerProvider
import com.example.stanislavkinzl.tabtestupdateddep.app.model.Comic
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.repository.ComicRepository
import io.reactivex.Scheduler
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FetchComicsUseCaseImplTest {

    @Mock
    private lateinit var mockComicsRepository: ComicRepository
    @Mock
    private lateinit var mockScheduleProvider: SchedulerProvider

    private lateinit var subject: FetchComicsUseCaseImpl

    @Mock
    private lateinit var mockScheduler: Scheduler
    @Mock
    private lateinit var mockResponse: List<Comic>

    @Before
    fun setUp() {
        subject = FetchComicsUseCaseImpl(mockComicsRepository, mockScheduleProvider)
    }

    @Test
    fun `execute() - comic repository should be called`() {
        given(mockScheduleProvider.io()).willReturn(mockScheduler)
        given(mockScheduleProvider.mainThread()).willReturn(mockScheduler)
        given(mockComicsRepository.fetchComics()).willReturn(Single.just(mockResponse))

        subject.execute()

        then(mockComicsRepository).should().fetchComics()
        then(mockComicsRepository).shouldHaveNoMoreInteractions()
    }

}