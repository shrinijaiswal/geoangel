package com.geoangel.baseapp.network;

import com.geoangel.baseapp.model.PokemonResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

/**
 * Created by Abhinav Singh on 17,June,2020
 */
public interface PokeApiService {

    @GET("pokemon")
    Observable<PokemonResponse> getPokemons();
}
