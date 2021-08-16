package com.geoangel.baseapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.geoangel.baseapp.model.Demo;

@Database(entities = {Demo.class},version = 2,exportSchema = false)
public abstract class DemoDB extends RoomDatabase {
        public abstract DemoDao demoDao();
}
