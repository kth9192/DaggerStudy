package com.noname.daggerexam2.logic;


import javax.inject.Inject;

public class NetworkApi {

    public boolean validateUser(String username, String password) {
        // imagine an actual network call here
        // for demo purpose return false in "real" life
        if (username == null || username.length() == 0) {
            return false;
        } else {
            return username.equals("kth") && password.equals("1111");
        }
    }
}
