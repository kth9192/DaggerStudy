package com.noname.daggerexam2.daggerpack.modules;


import android.content.Context;
import com.noname.daggerexam2.daggerpack.qualifier.ApplicationContext;
import com.noname.daggerexam2.daggerpack.scopes.ActivityScope;
import com.noname.daggerexam2.daggerpack.scopes.ApplicationScope;
import com.noname.daggerexam2.logic.NetworkApi;
import dagger.Module;
import dagger.Provides;

import javax.inject.Inject;
import javax.inject.Named;

@Module
public class LogicModule {

    private Context context;

    public LogicModule(Context context) {
        this.context = context;
    }

    @Provides
    @ActivityScope
    NetworkApi provideNetworkApi(){
        return new NetworkApi(context);
    }

}
