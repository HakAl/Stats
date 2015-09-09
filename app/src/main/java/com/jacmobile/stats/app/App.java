package com.jacmobile.stats.app;

import android.app.Application;

import com.jacmobile.stats.di.components.AppComponent;
import com.jacmobile.stats.di.components.DaggerAppComponent;
import com.jacmobile.stats.di.modules.AppModule;

public class App extends Application
{
    public static final String TAG = App.class.getSimpleName();

    private AppComponent appComponent;

    @Override public void onCreate()
    {
        super.onCreate();
        this.appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent()
    {
        return appComponent;
    }
}
