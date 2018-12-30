package com.noname.daggerexam2.daggermanager.modules;

import android.app.Application;
import android.content.Context;

import com.noname.daggerexam.MainActivity;
import com.noname.daggerexam.logic.NetworkApi;

import javax.inject.Singleton;

import androidx.annotation.NonNull;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeActivityInjector();

}
