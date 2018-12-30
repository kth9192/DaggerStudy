package com.noname.daggerexam2.daggermanager.modules;

import android.content.Context;

import com.noname.daggerexam.MainActivity;
import com.noname.daggerexam.daggermanager.qualifier.ActivityContext;
import com.noname.daggerexam.daggermanager.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {

    private MainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }
}
