package com.noname.daggerexam2.daggermanager.Component;


import com.noname.daggerexam2.daggermanager.scopes.ActivityScope;
import dagger.Component;

@Component(dependencies = ApplicationComponent.class)
@ActivityScope
public interface DetailActivityComponent {

//    void inject(DetailActivity detailActivity);
}

