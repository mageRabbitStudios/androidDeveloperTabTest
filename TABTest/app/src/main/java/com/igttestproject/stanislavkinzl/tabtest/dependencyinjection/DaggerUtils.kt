package com.igttestproject.stanislavkinzl.tabtest.dependencyinjection

import android.support.v7.app.AppCompatActivity
import com.igttestproject.stanislavkinzl.tabtest.Application

//Every AppCompatActivity will have this extension
fun AppCompatActivity.component() : ApplicationComponent = (application as Application).component