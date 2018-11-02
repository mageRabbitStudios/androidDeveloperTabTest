package com.igttestproject.stanislavkinzl.tabtest.app.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Model class parsed an validated, to be used inside the application.
 */

@SuppressLint("ParcelCreator")
@Parcelize
data class Comic(
        var name: String,
        var url: String,
        var extenson: String,
        var pageCount: Int
) : Parcelable