package com.noname.daggerexam2.daggermanager.Component;

import android.content.Context;

import com.noname.daggerexam.daggermanager.modules.LogicModule;
import com.noname.daggerexam.daggermanager.scopes.ActivityScope;
import com.noname.daggerexam.daggermanager.scopes.ApplicationScope;
import com.noname.daggerexam.logic.NetworkApi;

import javax.inject.Singleton;

import com.noname.daggerexam2.daggermanager.scopes.ApplicationScope;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@ApplicationScope
@Component(modules = {LogicModule.class})
public interface LogicComponent {

    NetworkApi getNetworkApi();

}
