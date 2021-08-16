package com.geoangel.baseapp.di;

import android.app.Application;
import androidx.room.Room;
import com.geoangel.baseapp.db.DemoDao;
import com.geoangel.baseapp.db.DemoDB;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;


@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static DemoDB provideDemoDB(Application application){
         return Room.databaseBuilder(application, DemoDB.class,"User Database")
                 .fallbackToDestructiveMigration()
                 .allowMainThreadQueries()
                 .build();
    }

    @Provides
    @Singleton
    public static DemoDao provideDemoDao(DemoDB demoDB){
        return demoDB.demoDao();
    }
}
