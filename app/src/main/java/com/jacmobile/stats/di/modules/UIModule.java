package com.jacmobile.stats.di.modules;

import com.jacmobile.stats.ui.ContentView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module public class UIModule
{
    @Provides @Singleton ContentView provideContentView()
    {
        return ContentView.DEFAULT;
    }
}