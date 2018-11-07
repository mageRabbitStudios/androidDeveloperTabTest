package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.repository.mapper

import com.igttestproject.stanislavkinzl.tabtest.app.database.remote.GetComicsResponse
import com.igttestproject.stanislavkinzl.tabtest.app.model.Comic
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.repository.ComicMapper
import com.igttestproject.stanislavkinzl.tabtest.fileToGson
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

import org.junit.Test
import org.assertj.core.api.Assertions.assertThat
import org.mockito.InjectMocks

@RunWith(MockitoJUnitRunner::class)
class ComicMapperTest {

    @InjectMocks
    private lateinit var subject: ComicMapper

    private lateinit var outputList: List<Comic>
    private lateinit var response: GetComicsResponse

    @Test
    fun `map() - maps comic list successfully`() {
        //given
        response = fileToGson(allComicsJsonFilePath)
        //when
        outputList = subject.map(response)
        //log result
        logOutputList()
        //then
        assertThatOutputListSizeIs(2)
        assertThat(outputList[0]).isEqualTo(spiderman)
        assertThat(outputList[1]).isEqualTo(batman)
    }

    @Test
    fun `map() - maps without name`() {
        //given
        response = fileToGson(noNameJsonFilePath)
        //when
        outputList = subject.map(response)
        //log result
        logOutputList()
        //then
        assertThatOutputListSizeIs(1)
        assertThat(outputList[0]).isEqualTo(spiderman_without_name)
    }

    @Test
    fun `map() - returns null because missing thumbnail`() {
        //given
        response = fileToGson(noThumbJsonFilePath)
        //when
        outputList = subject.map(response)
        //log result
        logOutputList()
        //then
        assertThatOutputListSizeIs(0)
    }

    @Test
    fun `map() - returns null because missing path`() {
        //given
        response = fileToGson(noPathJsonFilePath)
        //when
        outputList = subject.map(response)
        //log result
        logOutputList()
        //then
        assertThatOutputListSizeIs(0)
    }

    private fun logOutputList() {
        System.out.println(outputList.toString())
    }

    private fun assertThatOutputListSizeIs(expected: Int) {
        assertThat(outputList.size).isEqualTo(expected)
    }
}