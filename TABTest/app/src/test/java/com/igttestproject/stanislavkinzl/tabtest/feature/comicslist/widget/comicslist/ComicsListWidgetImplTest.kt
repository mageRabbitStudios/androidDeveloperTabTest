package com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.comicslist

import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.igttestproject.stanislavkinzl.tabtest.feature.comicslist.widget.comicslist.adapter.ComicsListAdapter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.assertj.core.api.Assertions.assertThat
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

import kotlinx.android.synthetic.main.widget_comics_list.*


@RunWith(MockitoJUnitRunner::class)
class ComicsListWidgetImplTest {

    @Mock private lateinit var mockComicsListAdapter: ComicsListAdapter
    @Mock private lateinit var mockGridLayoutManager: GridLayoutManager
    @Mock private lateinit var mockItemDecoration: GridSpacingItemDecoration

    private lateinit var subject: ComicsListWidgetImpl

    @Mock private lateinit var mockView: View

    @Before
    fun setUp() {
        subject = ComicsListWidgetImpl(mockComicsListAdapter, mockGridLayoutManager, mockItemDecoration)
    }

    @Test
    fun `init() - widget set`() {
      //  given(subject.containerView).willReturn(mockView)

     //   subject.containerView = mockView

       // subject.initRecyclerView()
       /* subject.init(mockView)

        assertThat(subject.containerView).isEqualTo(mockView)*/
    }



}