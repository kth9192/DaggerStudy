package com.noname.daggerexam2.daggermanager.modules;


import com.noname.daggerexam2.daggermanager.scopes.ActivityScope;
import com.noname.daggerexam2.view.CustomAdapter;
import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {

    @Provides
    @ActivityScope
    CustomAdapter getListAdapter(){
        return new CustomAdapter();
    }
}
