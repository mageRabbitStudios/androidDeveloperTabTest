package com.example.stanislavkinzl.tabtestupdateddep.app

import android.net.Uri
import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.io.File

class PicassoImageLoader : ImageLoader {

    override fun load(uri: Uri, target: ImageView) = Picasso.get().load(uri).into(target)

    override fun load(path: String, target: ImageView) = if (!isPathFromTest(path)) Picasso.get().load(path).into(target) else System.out.println("Loading image for a test $path")

    override fun load(resourceId: Int, target: ImageView) = Picasso.get().load(resourceId).into(target)

    override fun load(file: File, target: ImageView) = Picasso.get().load(file).into(target)

    private fun isPathFromTest(path: String) : Boolean = path.toLowerCase().contains("path_")


}