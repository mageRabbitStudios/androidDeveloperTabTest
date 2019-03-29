package com.example.stanislavkinzl.tabtestupdateddep.testAndroidComicsListFragment

import androidx.lifecycle.MutableLiveData
import com.example.libtestingandroid.helpers.TestMatchers.iDontSee
import com.example.libtestingandroid.helpers.TestMatchers.iSee
import com.example.libtestingandroid.parents.FragmentCustomInjectorTest
import com.example.stanislavkinzl.tabtestupdateddep.R
import com.example.stanislavkinzl.tabtestupdateddep.app.model.Comic
import com.example.stanislavkinzl.tabtestupdateddep.feature.ExampleComicListFragment
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.viewmodel.ComicsViewModel
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock

// No @Config(TestApp::class) needed since we build our own custom injection with mocks
class ExampleComicListFragmentTest : FragmentCustomInjectorTest<ExampleComicListFragment>(ExampleComicListFragment()) {

    private companion object {
        val LIST_OF_ONE_COMIC = listOf(Comic(
            name = "Spiderman",
            url = "some url",
            pageCount = 1
        ))
    }

    override lateinit var injection: (ExampleComicListFragment) -> Unit

    @Mock private lateinit var mockComicsViewModel: ComicsViewModel
    private var state = MutableLiveData<ComicsViewModel.State>()

    override fun setup() {
        super.setup()

        injection = {
            it.apply {
                comicsViewModel = mockComicsViewModel
            }
            given(it.comicsViewModel.state()).willReturn(state)
        }

        givenFragmentHasBeenLaunched(injection)
    }

    @Test
    fun `handleState() - state set to SUCCESS - indicator should be visible`() {

        state.value = ComicsViewModel.State.FetchMemesSuccess(LIST_OF_ONE_COMIC)

        iSee(R.id.comics_loaded_indicator)
    }

    @Test
    fun `handleState() - state set to ERROR - indicator should not be visible`() {

        state.value = ComicsViewModel.State.FetchMemesError

        iDontSee(R.id.comics_loaded_indicator)
    }

}