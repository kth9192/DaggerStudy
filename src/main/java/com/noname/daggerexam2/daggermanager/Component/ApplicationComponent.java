package com.noname.daggerexam2.daggermanager.Component;



import com.noname.daggerexam2.MyApp;
import com.noname.daggerexam2.daggermanager.modules.*;
import com.noname.daggerexam2.daggermanager.scopes.ApplicationScope;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@ApplicationScope
@Component(modules = {AndroidInjectionModule.class , ActivityBindingModule.class, RetrofitModule.class, LogicModule.class})
public interface ApplicationComponent extends AndroidInjector<MyApp> {


}
