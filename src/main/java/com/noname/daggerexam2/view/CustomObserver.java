package com.noname.daggerexam2.view;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

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
