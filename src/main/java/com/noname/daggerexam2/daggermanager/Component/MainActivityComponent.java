package com.noname.daggerexam2.daggermanager.Component;

import android.content.Context;


import com.noname.daggerexam2.MainActivity;
import com.noname.daggerexam2.daggermanager.modules.AdapterModule;
import com.noname.daggerexam2.daggermanager.qualifier.ActivityContext;
import com.noname.daggerexam2.daggermanager.scopes.ActivityScope;
import dagger.Component;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@ActivityScope
@Component( dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

}

