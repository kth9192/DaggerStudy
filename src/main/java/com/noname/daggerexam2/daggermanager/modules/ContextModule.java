package com.noname.daggerexam2.daggermanager.modules;

import android.content.Context;


import com.noname.daggerexam2.daggermanager.qualifier.ApplicationContext;
import com.noname.daggerexam2.daggermanager.scopes.ApplicationScope;
import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private static Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    Context provideContext() {
        return context;
    }


}
