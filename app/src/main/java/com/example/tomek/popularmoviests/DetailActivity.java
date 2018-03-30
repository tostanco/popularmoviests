package com.example.tomek.popularmoviests;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private ImageView thumbnail;
    private TextView title, vote_average, release_date, plot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        thumbnail = findViewById(R.id.iv_thumbnail);
        title = findViewById(R.id.tv_title);
        vote_average = findViewById(R.id.vote_average);
        release_date = findViewById(R.id.release_date);
        plot = findViewById(R.id.plot);

        Movies movies = getIntent().getParcelableExtra("movie");
        if (movies != null) {
            title.setText(movies.getTitle());
            vote_average.setText("" + movies.getVoteAverage());
            release_date.setText("" + movies.getReleaseDate());
            plot.setText("" + movies.getOverview());
            //loadThumbnail(movies.getPosterPath());
        }
    }
//    public void loadThumbnail (String path){
//        String uriBuilder = new StringBuilder().append(BASE_URL).append(IMAGE_SIZE).append(path).toString();
//        Picasso.with(getApplicationContext()).load(uriBuilder).into(thumbnail);
//    }
}