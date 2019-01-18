package com.noname.daggerexam2.daggerpack.modules;

import android.app.Application;
import android.content.Context;

import com.noname.daggerexam2.DetailActivity;
import com.noname.daggerexam2.MainActivity;
import com.noname.daggerexam2.daggerpack.qualifier.ActivityContext;
import com.noname.daggerexam2.daggerpack.scopes.ActivityScope;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainActivityModule {

//    @Binds
//    abstract Context bindContext(Context context);
}
