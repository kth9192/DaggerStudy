package com.noname.daggerexam2.daggermanager.Component;


import android.content.Context;
import com.noname.daggerexam2.DetailActivity;
import com.noname.daggerexam2.daggermanager.modules.AdapterModule;
import com.noname.daggerexam2.daggermanager.qualifier.ActivityContext;
import com.noname.daggerexam2.daggermanager.scopes.ActivityScope;
import dagger.Component;
import dagger.Provides;

@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
@ActivityScope
public interface DetailActivityComponent {

}

