package com.noname.daggerexam2.repository;

import androidx.paging.DataSource;
import androidx.room.*;
import com.noname.daggerexam2.model.People;

import java.util.List;

@Dao
public interface CustomDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(CustomRoom... customRooms);

    @Delete
    void delete(CustomRoom customRoom);

    @Query("SELECT * from CustomRoom")
    List<CustomRoom> getAll();
}
