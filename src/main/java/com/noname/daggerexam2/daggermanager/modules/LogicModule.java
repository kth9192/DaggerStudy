package com.noname.daggerexam2.daggermanager.modules;


import com.noname.daggerexam2.daggermanager.scopes.ApplicationScope;
import com.noname.daggerexam2.logic.NetworkApi;
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
