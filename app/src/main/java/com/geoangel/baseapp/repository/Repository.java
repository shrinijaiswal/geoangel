package com.geoangel.baseapp.repository;

import androidx.lifecycle.LiveData;

import com.geoangel.baseapp.db.DemoDao;
import com.geoangel.baseapp.model.Demo;
import com.geoangel.baseapp.model.Response;
import com.geoangel.baseapp.network.ApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repository {

    private DemoDao demoDao;
    private ApiService apiService;

    @Inject
    public Repository(DemoDao demoDao, ApiService apiService) {
        this.demoDao = demoDao;
        this.apiService = apiService;
    }


    public Observable<Response> get(){
        return apiService.getResponse();
    }

    public void insert(Demo data){
        demoDao.insert(data);
    }

    public void delete(String dataName){
        demoDao.delete(dataName);
    }

    public void deleteAll(){
        demoDao.deleteAll();
    }

    public LiveData<List<Demo>> getFavorite(){
        return demoDao.getFavorite();
    }
}
