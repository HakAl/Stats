package com.jacmobile.stats.di.components;

import com.jacmobile.stats.di.modules.AppModule;
import com.jacmobile.stats.di.modules.UIModule;
import com.jacmobile.stats.ui.activities.StatsActivity;
import com.jacmobile.stats.ui.fragments.RunningProcessFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, UIModule.class})
public interface AppComponent
{
    void inject(StatsActivity activity);
    void inject(RunningProcessFragment fragment);
}