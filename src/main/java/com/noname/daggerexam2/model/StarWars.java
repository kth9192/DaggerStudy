package com.noname.daggerexam2.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class StarWars {

    @SerializedName("results")

    public List<People> results = null;


}

