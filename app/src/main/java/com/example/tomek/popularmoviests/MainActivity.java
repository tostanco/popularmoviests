package com.example.tomek.popularmoviests;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends Activity { //implements RecyclerView.OnClickListener{

    public static final String API_KEY = "";
    public static final String BASE_URL = "https://api.themoviedb.org/t/p";
    public final String POPULAR = "popular";
    public final String TOP_RATED = "top_rated";
    public PopularMoviesAdapter popularMoviesAdapter;
    private ArrayList<Movies> moviesList;
    public TextView errorMessage;
    public ProgressBar loadingIndicator;
    private TextView emptyView;
    private RecyclerView recyclerView;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        errorMessage = findViewById(R.id.error_message);
        loadingIndicator = findViewById(R.id.progressBar);
        emptyView = findViewById(R.id.empty_view);
        moviesList = new ArrayList<>();
        popularMoviesAdapter = new PopularMoviesAdapter(this, moviesList);

        RecyclerView recyclerView = findViewById(R.id.cards);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(llm);

            PopularMoviesAdapter adapter = new PopularMoviesAdapter(context, moviesList);
            recyclerView.setAdapter(adapter);
            recyclerView.setOnClickListener(new View.OnClickListener() {
                
                @Override
                public void onClick(View v) {
                    int movies = popularMoviesAdapter.getItemCount();
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("movie", movies);
                    startActivity(intent);
                }
            });
            showItems (POPULAR);
        }
        public void showItems (String items){
            if (moviesList.isEmpty()) {
                recyclerView.setVisibility(View.GONE);
                emptyView.setVisibility(View.VISIBLE);
            }
            else {
                recyclerView.setVisibility(View.VISIBLE);
                emptyView.setVisibility(View.GONE);
            }

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        showItems(POPULAR);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_top_rated){
            showItems(TOP_RATED);
            return true;
        }
        if (id== R.id. action_most_popular || id == R.id.action_refresh ){
            showItems(POPULAR);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public class FetchMovies extends AsyncTask<String, Void, Movies[]>{
        private final Window.Callback callback;
        private FetchMovies(Window.Callback movieCallback){
            this.callback = movieCallback;
        }
        private Movies[] getMoviesFromJson(String jsonStringMovie) throws JSONException {
            if (jsonStringMovie == null || "".equals(jsonStringMovie)) {
                return null;
            }

            JSONObject jsonObjectMovie = new JSONObject(jsonStringMovie);
            JSONArray jsonArrayMovies = jsonObjectMovie.getJSONArray("results");

            Movies[] movies = new Movies[jsonArrayMovies.length()];

            for (int i = 0; i < jsonArrayMovies.length(); i++) {
                JSONObject object = jsonArrayMovies.getJSONObject(i);
                movies[i] = new Movies(object.getString("original_title"),
                        object.getString("poster_path"),
                        object.getString("overview"),
                        object.getInt("vote_average"),
                        object.getInt("release_date"));
            }
            return movies;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected Movies[] doInBackground(String... strings) {
            if (strings.length == 0) {
                return null;
            }

            HttpURLConnection urlConnection = null;
            String movieJsonString = null;
            BufferedReader reader = null;

            Uri uri = Uri.parse(BASE_URL).buildUpon()
                    .appendEncodedPath(strings[0])
                    .appendQueryParameter("api_key", API_KEY)
                    .build();

            try {
                URL url = new URL(uri.toString());
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuilder builder = new StringBuilder();
                if (inputStream == null) {
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line + "\n");
                }

                if (builder.length() == 0) {
                    return null;
                }

                movieJsonString = builder.toString();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }

                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            try {
                return getMoviesFromJson(movieJsonString);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            // return null;
            return new Movies[0];
        }

        @Override
        protected void onPostExecute(Movies[] movies) {
            loadingIndicator.setVisibility(View.INVISIBLE);
           super.onPostExecute(movies);
            Toast.makeText(MainActivity.this, "Loaded", Toast.LENGTH_SHORT).show();
        }

        public Window.Callback getCallback() {
            return callback;
        }
    }
}




