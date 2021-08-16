package com.geoangel.baseapp.network;

import com.geoangel.baseapp.model.Response;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;


public interface ApiService {

    @GET("response")
    Observable<Response> getResponse();
}
