package com.noname.daggerexam2.daggermanager.modules;

import android.content.Context;
import com.noname.daggerexam2.DetailActivity;
import com.noname.daggerexam2.daggermanager.qualifier.ActivityContext;
import com.noname.daggerexam2.daggermanager.scopes.ActivityScope;
import dagger.Module;
import dagger.Provides;

@Module
public class DetailContextModule {
    private DetailActivity detailActivity;
    public Context context;

    public DetailContextModule(DetailActivity detailActivity) {
        this.detailActivity = detailActivity;
        context = detailActivity;
    }

    @Provides
    @ActivityScope
    public DetailActivity proviedeDetailAcitivty() {
        return detailActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }
}
