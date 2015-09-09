package com.jacmobile.stats.memory;

import android.support.annotation.NonNull;

public interface MemoryOperator
{
    void save(@NonNull String key, @NonNull String value);
    @NonNull String load(String key);
}