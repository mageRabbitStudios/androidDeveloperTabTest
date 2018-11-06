package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.repository

import com.igttestproject.stanislavkinzl.tabtest.app.database.remote.ApiInterface
import com.igttestproject.stanislavkinzl.tabtest.app.database.remote.GetComicsResponse
import com.igttestproject.stanislavkinzl.tabtest.app.model.Comic
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ComicRepositoryImplTest {

    //== subject dependencies ===

    @Mock private lateinit var mockMapper: ComicMapper
    @Mock private lateinit var mockApiInterface: ApiInterface

    //======= other =============

    private lateinit var subject: ComicRepositoryImpl

    @Mock private lateinit var mockResponse: GetComicsResponse
    @Mock private lateinit var mockMappedData: List<Comic>

    //this observer is in order to store the data, so we can check if it's actually passed
    //Single is kinda observer and there is no class TestSingle, so lets make it observer
    private lateinit var testObserver: TestObserver<List<Comic>>

    @Before
    fun setUp() {
        subject = ComicRepositoryImpl(mockApiInterface, mockMapper)
    }

    @Test
    fun `fetchComics() - fetches data and maps comics`() {
        given(mockApiInterface.allComics()).willReturn(Single.just(mockResponse))
        given(mockMapper.map(mockResponse)).willReturn(mockMappedData)

        //that test method at the end is funny
        testObserver = subject.fetchComics().test()

        testObserver.assertValue(mockMappedData)
    }

}