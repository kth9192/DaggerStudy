package com.noname.daggerexam2.repository;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.noname.daggerexam2.model.People;

@Dao
public interface StarDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(People... people);

    @Delete
    void delete(People people);

    @Query("SELECT * from People")
    DataSource.Factory<Integer, People> getAll();
}
