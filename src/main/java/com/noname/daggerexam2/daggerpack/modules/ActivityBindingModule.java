package com.noname.daggerexam2.daggerpack.modules;


import com.noname.daggerexam2.DetailActivity;
import com.noname.daggerexam2.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainInjector();

    @ContributesAndroidInjector(modules = DetailActivityModule.class)
    abstract DetailActivity contributeDetailInjector();
}
