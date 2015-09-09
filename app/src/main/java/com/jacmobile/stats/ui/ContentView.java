// GiftCards Android App
//
// Copyright (c) 2007-2015 GiftCards.com.  All rights reserved.

package com.jacmobile.stats.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jacmobile.stats.R;

/** An indirection which allows controlling the root container used for each activity. */
public interface ContentView
{
    /**
     * The root {@link ViewGroup} into which the activity should place its contents.
     */
    ViewGroup get(Activity activity);

    /**
     * An {@link ContentView} which returns the normal activity content view.
     */
    ContentView DEFAULT = new ContentView()
    {
        @Override public ViewGroup get(Activity activity)
        {
            return (ViewGroup) activity.findViewById(android.R.id.content);
        }
    };
}