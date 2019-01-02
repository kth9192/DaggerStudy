package com.noname.daggerexam2;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import com.noname.daggerexam2.daggermanager.Component.DaggerApplicationComponent;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MyApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.create().inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    public static MyApp get(Activity activity){
        return (MyApp) activity.getApplication();
    }

}
