package com.example.tomek.popularmoviests;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_thumbnail)
    ImageView ivThumbnail;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.vote_average)
    TextView voteAverage;
    @BindView(R.id.release_date)
    TextView releaseDate;
    @BindView(R.id.plot)
    TextView plot;
    @BindView(R.id.error_message)
    TextView errorMessage;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.parent_layout)
    LinearLayout parentLayout;
    private ImageView thumbnail;
    private TextView title, vote_average, release_date;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        setContentView(R.layout.list_item);
        thumbnail = findViewById(R.id.iv_thumbnail);
        title = findViewById(R.id.tv_title);
        vote_average = findViewById(R.id.vote_average);
        release_date = findViewById(R.id.release_date);
        plot = findViewById(R.id.plot);

        Movie movies = getIntent().getParcelableExtra("movie");
        if (movies != null) {
            title.setText(movies.toString());
            //vote_average.setText("" + movies.getVoteAverage());
            //
            // release_date.setText("" + movies.getReleaseDate());
            //plot.setText("" + movies.getOverview());
            //loadThumbnail(movies.getPosterPath());
        }
    }

//    public void loadThumbnail(String path) {
//        String uriBuilder = new StringBuilder().append(BASE_URL).append(IMAGE_SIZE).append(path).toString();
//        Picasso.with(getApplicationContext()).load(uriBuilder).into(thumbnail);
//    }
}