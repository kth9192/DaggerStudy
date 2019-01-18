package com.noname.daggerexam2;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import com.noname.daggerexam2.daggerpack.Component.DaggerApplicationComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MyApp extends DaggerApplication {

//    @Inject
//    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().application(this).build();
    }

//    @Override
//    public DispatchingAndroidInjector<Activity> activityInjector() {
//        return dispatchingAndroidInjector;
//    }

//    public static MyApp get(Activity activity){
//        return (MyApp) activity.getApplication();
//    }

}
