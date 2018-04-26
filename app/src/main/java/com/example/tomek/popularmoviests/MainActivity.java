package com.example.tomek.popularmoviests;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.tomek.popularmoviests.MoviesAPI.BASE_URL;
import static com.example.tomek.popularmoviests.MoviesAPI.KEY;
import static com.example.tomek.popularmoviests.MoviesAPI.MOST_POPULAR;
import static com.example.tomek.popularmoviests.MoviesAPI.TOP_RATED;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private static final int NUM_COLUMNS = 2;

    private ArrayList<String> Titles = new ArrayList<>();
    private ArrayList<String> Images = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
    }
    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL + KEY + TOP_RATED)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MoviesAPI moviesAPI = retrofit.create(MoviesAPI.class);
    }

    Call<BASE_URL+KEY+TOP_RATED> call = call.getMovies.
            call.enqueue(new Callback<>() {
        @Override
        public void onResponse(Call call, Response response) {

        }

        @Override
        public void onFailure(Call call, Throwable t) {

        }
    }
    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_main);
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        RecyclerView recyclerMain;
        recyclerMain.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(PopularMoviesAdapter.);
    }
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.action_top_rated) {
//            showItems(TOP_RATED);
//            return true;
//        }
//        if (id == R.id.action_most_popular || id == R.id.action_refresh) {
//            showItems(POPULAR);
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }
    }


