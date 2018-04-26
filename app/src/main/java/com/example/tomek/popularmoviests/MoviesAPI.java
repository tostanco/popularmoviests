package com.example.tomek.popularmoviests;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface MoviesAPI {
    String BASE_URL = "http://api.themoviedb.org/3/";
    String KEY ="";
    String MOST_POPULAR = " movie/popular?api_key=";
    String TOP_RATED = "movie/top_rated?api_key=";

    Retrofit getMovies();

    @GET("BASE_URL+KEY+TOP_RATED"")
    Call<BASE_URL+KEY+TOP_RATED>getMovies());

}

