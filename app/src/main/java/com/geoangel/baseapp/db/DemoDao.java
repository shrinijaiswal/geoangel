package com.geoangel.baseapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.geoangel.baseapp.model.Demo;

import java.util.List;


@Dao
public interface DemoDao {

    @Insert
    void insert(Demo demo);

    @Query("DELETE FROM Demo WHERE name = :inputName")
    void delete(String pokemonName);

    @Query("DELETE FROM Demo")
    void deleteAll();

    @Query("SELECT * FROM Demo")
    LiveData<List<Demo>> getFavorite();
}
