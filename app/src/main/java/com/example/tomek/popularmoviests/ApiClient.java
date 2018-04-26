package com.example.tomek.popularmoviests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.tomek.popularmoviests.MoviesAPI.BASE_URL;
import static com.example.tomek.popularmoviests.MoviesAPI.KEY;
import static com.example.tomek.popularmoviests.MoviesAPI.MOST_POPULAR;
import static com.example.tomek.popularmoviests.MoviesAPI.TOP_RATED;

public class ApiClient {

    public static Retrofit retrofit = null;

    public static  Retrofit getMovies() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL+KEY+TOP_RATED)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            //.create(MoviesAPI.class)
            //.getMovies();
        }
//        return getMovies();

        MoviesAPI moviesAPI = retrofit.create(MoviesAPI.class);
        Call<Movie> call = request.getJSON();
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {

RESPONSE HERE!!!!!!!!!!!!!!!!!!

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }
     MoviesAPI moviesAPI = retrofit.create(MoviesAPI.class);
     String call = moviesAPI.BASE_URL + KEY;
}
