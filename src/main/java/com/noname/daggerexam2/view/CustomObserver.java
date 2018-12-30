package com.noname.daggerexam2.view;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.noname.daggerexam2.repository.CustomRoom;

public class CustomObserver extends BaseObservable {

    private CustomRoom customRoom;

    public CustomObserver(CustomRoom customRoom) {
        this.customRoom = customRoom;
    }

    @Bindable
    public String getTitle(){
        return customRoom.getTitle();
    }

    @Bindable
    public String getTag(){
        return String.valueOf(customRoom.getTag());
    }
}
