package com.noname.daggerexam2.daggermanager.modules;


import com.noname.daggerexam2.DetailActivity;
import com.noname.daggerexam2.MainActivity;
import com.noname.daggerexam2.daggermanager.scopes.ActivityScope;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract MainActivity contributeActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector
    abstract DetailActivity contributeDetailInjector();
}
