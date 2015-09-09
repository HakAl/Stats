package com.jacmobile.stats.di.modules;

import android.content.Context;

import com.jacmobile.stats.app.App;
import com.jacmobile.stats.di.annotations.ForApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module public class AppModule
{
    private final App app;

    public AppModule(App app)
    {
        this.app = app;
    }

    @Provides @Singleton @ForApplication Context provideApplication()
    {
        return this.app;
    }
}
