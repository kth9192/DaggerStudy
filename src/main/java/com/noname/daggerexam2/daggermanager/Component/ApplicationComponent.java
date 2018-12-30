package com.noname.daggerexam2.daggermanager.Component;



import com.noname.daggerexam2.MyApp;
import com.noname.daggerexam2.daggermanager.modules.AppModule;
import com.noname.daggerexam2.daggermanager.modules.LogicModule;
import com.noname.daggerexam2.daggermanager.modules.RetrofitModule;
import com.noname.daggerexam2.daggermanager.scopes.ApplicationScope;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@ApplicationScope
@Component(modules = {AndroidInjectionModule.class , AppModule.class, RetrofitModule.class, LogicModule.class})
public interface ApplicationComponent extends AndroidInjector<MyApp> {
//    APIInterface getApiInterface();
//
//    @ApplicationContext
//    Context getContext();

}
