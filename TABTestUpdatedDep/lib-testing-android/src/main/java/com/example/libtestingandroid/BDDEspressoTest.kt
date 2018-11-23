package com.example.libtestingandroid

abstract class BDDEspressoTest {

    fun Given(step: () -> Unit) {
        step()
    }

    fun When(step: () -> Unit) {
        step()
    }

    fun Then(step: () -> Unit) {
        step()
    }

    fun And(step: () -> Unit) {
        step()
    }
}
