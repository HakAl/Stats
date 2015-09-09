package com.jacmobile.stats.utils;

import android.app.Activity;
import android.content.pm.FeatureInfo;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AndroidStatsHelper
{
    @NonNull private List<String> getSystemFeatures(Activity activity)
    {
        List<String> features = new ArrayList<>();
        for (FeatureInfo feature :
                activity.getPackageManager().getSystemAvailableFeatures()) {
            features.add(feature.name);
        }
        return features;
    }
}

//    private void logActivityManagerStuff(Activity activity) {
//        ActivityManager mgr=(ActivityManager)activity.getSystemService(activity.ACTIVITY_SERVICE);
//        "heap limit="+mgr.getMemoryClass();
//        "large-heap limit="+mgr.getLargeMemoryClass();
//    }
//
//    private void logDisplayMetrics() {
//        DisplayMetrics dm=new DisplayMetrics();
//
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        "DisplayMetrics.densityDpi="+dm.densityDpi);
//        "DisplayMetrics.xdpi="+dm.xdpi);
//        "DisplayMetrics.ydpi="+dm.ydpi);
//        "DisplayMetrics.scaledDensity="+dm.scaledDensity);
//        "DisplayMetrics.widthPixels="+dm.widthPixels);
//        "DisplayMetrics.heightPixels="+dm.heightPixels);
//    }
//
//    private void logConfiguration() {
//        Configuration cfg=getResources().getConfiguration();
//
//        "Configuration.densityDpi="+cfg.densityDpi);
//        "Configuration.fontScale="+cfg.fontScale);
//        "Configuration.hardKeyboardHidden="+cfg.hardKeyboardHidden);
//        "Configuration.keyboard="+cfg.keyboard);
//        "Configuration.keyboardHidden="+cfg.keyboardHidden);
//        "Configuration.locale="+cfg.locale);
//        "Configuration.mcc="+cfg.mcc);
//        "Configuration.mnc="+cfg.mnc);
//        "Configuration.navigation="+cfg.navigation);
//        "Configuration.navigationHidden="+cfg.navigationHidden);
//        "Configuration.orientation="+cfg.orientation);
//        "Configuration.screenHeightDp="+cfg.screenHeightDp);
//        "Configuration.screenWidthDp="+cfg.screenWidthDp);
//        "Configuration.touchscreen="+cfg.touchscreen);
//    }