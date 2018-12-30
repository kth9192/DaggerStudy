package com.noname.daggerexam2.daggermanager.modules;

import com.noname.daggerexam.daggermanager.scopes.ActivityScope;
import com.noname.daggerexam.daggermanager.scopes.ApplicationScope;
import com.noname.daggerexam.logic.NetworkApi;

import dagger.Module;
import dagger.Provides;

@Module
public class LogicModule {

    @Provides
    @ApplicationScope
    NetworkApi provideNetworkApi(){
        return new NetworkApi();
    }

}
