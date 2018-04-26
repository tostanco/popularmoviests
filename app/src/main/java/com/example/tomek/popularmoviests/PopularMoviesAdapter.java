package com.example.tomek.popularmoviests;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.tomek.popularmoviests.MoviesAPI.BASE_URL;
import static com.example.tomek.popularmoviests.MoviesAPI.KEY;
import static com.example.tomek.popularmoviests.MoviesAPI.TOP_RATED;

/**
 * Created by Tomek on 2018-03-15.
 */

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder> {

    private static final String TAG = "PopularMoviesAdapter";

    private ArrayList<String> Images = new ArrayList<>();
    private ArrayList<String> Titles = new ArrayList<>();
    private Context mContext;

    public PopularMoviesAdapter(ArrayList<String> images, ArrayList<String> titles, Context mContext) {
        Images = images;
        Titles = titles;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.activity_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Picasso.with(mContext)
                .load(Images)
                .into(holder.FrontImage);
        holder.title.setText(Titles.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: called");



            }
        });

//        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent movieIntent = new Intent(context, DetailActivity.class);
//                Movie movie = new Movie();
//                movieIntent.putExtra("movie", );
//                movieIntent.putExtra("title", );
//                movieIntent(startActivity(movieIntent);
    }

    @Override
    public int getItemCount() {
        return Titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView FrontImage;
        TextView title;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            FrontImage = itemView.findViewById(R.id.frontImage);
            title = itemView.findViewById(R.id.title);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}


//    @BindView(R.id.list_item)
//    ImageView listItem;
//    @BindView(R.id.frontImage)
//    ImageView frontImage;
//    @BindView(R.id.title)
//    TextView title;
//    private Context context;
//    public List<Movie> movies;
//    public ImageView frontImageView;


//    @Override
//    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//
//    }
//    @Override
//    public void onBindViewHolder(MovieViewHolder holder, int position) {
//
//        Picasso.with(context)
//                .load(BASE_URL+TOP_RATED+KEY)
//                .into(frontImage);
//        holder.title.setText(frontImage.getImageAlpha());
//
//        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent movieIntent = new Intent(context, DetailActivity.class);
//                Movie movie = new Movie();
//                movieIntent.putExtra("movie", );
//                movieIntent.putExtra("title", );
//                movieIntent(startActivity(movieIntent);
//            }
//        }
//    }
//    @Override
//    public int getItemCount() {
//        return movies.size();
//    }
//    public class MovieViewHolder extends RecyclerView.ViewHolder {
//
//        @BindView(R.id.iv_thumbnail)
//        ImageView thumbnail;
//        @BindView(R.id.tv_title)
//        TextView title;
//        @BindView(R.id.vote_average)
//        TextView vote_average;
//        @BindView(R.id.release_date)
//        TextView release_date;
//        @BindView(R.id.plot)
//        TextView plot;
//        @BindView(R.id.parent_layout)
//        LinearLayout parentLayout;
//
//        MovieViewHolder(View view) {
//            super(view);
//            view.setOnClickListener(this);
//            ButterKnife.bind(this, view);
//        }
//
//
//    }





