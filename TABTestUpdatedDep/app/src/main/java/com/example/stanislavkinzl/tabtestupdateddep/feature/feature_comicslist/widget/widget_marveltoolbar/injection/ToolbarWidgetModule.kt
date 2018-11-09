package com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.widget.widget_marveltoolbar.injection

import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.widget.widget_marveltoolbar.ToolbarWidget
import com.example.stanislavkinzl.tabtestupdateddep.feature.feature_comicslist.widget.widget_marveltoolbar.ToolbarWidgetImpl
import dagger.Module
import dagger.Provides

@Module
class ToolbarWidgetModule {

    @Provides
    fun provideToolbarWidget(toolbarWidgetImpl: ToolbarWidgetImpl): ToolbarWidget =
        toolbarWidgetImpl

}