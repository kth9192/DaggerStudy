package com.noname.daggerexam2.daggerpack.Component;



import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.noname.daggerexam2.MyApp;
import com.noname.daggerexam2.daggerpack.modules.*;
import com.noname.daggerexam2.daggerpack.scopes.ApplicationScope;
import com.noname.daggerexam2.logic.NetworkApi;
import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@ApplicationScope
@Component(modules = {AndroidInjectionModule.class , ActivityBindingModule.class,
        RetrofitModule.class, AppModule.class})
public interface ApplicationComponent extends AndroidInjector<MyApp>  {

    @Component.Builder
    interface Builder {

        @BindsInstance
        ApplicationComponent.Builder application(Application application);

        ApplicationComponent build();
    }
}
