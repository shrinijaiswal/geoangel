package com.geoangel.baseapp.viewmodel;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geoangel.baseapp.model.Demo;
import com.geoangel.baseapp.model.Response;
import com.geoangel.baseapp.repository.Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class DemoViewModel extends ViewModel {
    private static final String TAG = "ViewModel";

    private Repository repository;
    private MutableLiveData<ArrayList<Demo>> DataList = new MutableLiveData<>();
    private LiveData<List<Demo>> favoriteList = null;

    @ViewModelInject
    public DemoViewModel(Repository repository) {
        this.repository = repository;
        favoriteList = repository.getFavorite();
    }


    public void getDataList(){
        repository.get()
                .subscribeOn(Schedulers.io())
                .map(new Function<Response, ArrayList<Demo>>() {
                    @Override
                    public ArrayList<Demo> apply(Response DataResponse) throws Throwable {
                        ArrayList<Demo> list = DataResponse.getResults();
                        for(Demo data : list){


                        }

                        return list;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> DataList.setValue(result),
                        error-> Log.e(TAG, "get: " + error.getMessage() ));
    }

    public void insert(Demo data){
        repository.insert(data);
    }
    public void delete(String dataName){
        repository.delete(dataName);
    }

    public LiveData<List<Demo>> getFavoriteList() {
        return favoriteList;
    }

    public void getFavorite(){
       favoriteList = repository.getFavorite();
    }



}
