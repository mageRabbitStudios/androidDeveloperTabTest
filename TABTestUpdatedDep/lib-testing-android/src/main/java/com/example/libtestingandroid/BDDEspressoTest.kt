package com.example.libtestingandroid

abstract class BDDEspressoTest {

    fun given(step: () -> Unit) {
        step()
    }

    fun `when`(step: () -> Unit) {
        step()
    }

    fun then(step: () -> Unit) {
        step()
    }

    fun and(step: () -> Unit) {
        step()
    }
}
