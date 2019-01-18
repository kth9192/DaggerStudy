package com.noname.daggerexam2.daggerpack.modules;

import android.app.Application;
import android.content.Context;
import com.noname.daggerexam2.daggerpack.qualifier.ApplicationContext;
import com.noname.daggerexam2.daggerpack.scopes.ApplicationScope;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {

    @Binds
    abstract Context bindContext(Application application);

}
