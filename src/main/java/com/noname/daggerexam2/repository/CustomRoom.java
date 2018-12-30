package com.noname.daggerexam2.repository;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CustomRoom {

    @PrimaryKey
    @NonNull
    private String id;

    private String title;

    private String tag;

    public CustomRoom(@NonNull String id, String title, String tag) {
        this.id = id;
        this.title = title;
        this.tag = tag;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
