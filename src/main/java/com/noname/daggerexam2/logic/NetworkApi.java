package com.noname.daggerexam2.logic;


import android.content.Context;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

public class NetworkApi {

    private Context context;

//    @Inject
//    public NetworkApi( ) {
//    }

    @Inject
    public NetworkApi(Context context) {
        this.context = context;
    }

    public boolean validateUser(String username, String password) {
        // imagine an actual network call here
        // for demo purpose return false in "real" life
        if (username == null || username.length() == 0) {
            return false;
        } else {
            return username.equals("kth") && password.equals("1111") && context!=null;
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
