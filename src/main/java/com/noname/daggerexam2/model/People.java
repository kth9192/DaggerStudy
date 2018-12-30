package com.noname.daggerexam2.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class People {

    @NonNull
    @PrimaryKey
    @SerializedName("name")
    public String name;
    @SerializedName("height")
    public String height;
    @SerializedName("mass")
    public String mass;
    @SerializedName("birth_year")
    public String birthYear;
    @SerializedName("gender")
    public String gender;
    @SerializedName("homeworld")
    public String homeworld;
    @SerializedName("films")
    public List<String> films = null;


    public People(@NonNull String name, String height, String mass,
                  String birthYear, String gender, String homeworld, List<String> films) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
        this.films = films;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }
}
