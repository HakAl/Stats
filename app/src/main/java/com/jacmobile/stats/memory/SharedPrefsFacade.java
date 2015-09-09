package com.jacmobile.stats.memory;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class SharedPrefsFacade implements MemoryOperator
{
    public static final String NOT_FOUND = "Not found.";

    private SharedPreferences sharedPreferences;

    public SharedPrefsFacade(SharedPreferences sharedPreferences)
    {
        this.sharedPreferences = sharedPreferences;
    }

    @Override public void save(@NonNull String key, @NonNull String value)
    {
        this.sharedPreferences.edit().putString(key, value).commit();
    }

    @NonNull @Override public String load(String key)
    {
        String value = this.sharedPreferences.getString(key, null);
        return  value == null ? NOT_FOUND : value;
    }
}