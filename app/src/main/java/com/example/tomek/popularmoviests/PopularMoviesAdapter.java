package com.example.tomek.popularmoviests;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

/**
 * Created by Tomek on 2018-03-15.
 */

public class PopularMoviesAdapter extends RecyclerView.Adapter<PopularMoviesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Movies> movies;
    ImageView thumbnail;
    TextView title, vote_average, release_date, plot;
    private final static String BASE_URL = "https://image.tmdb.org/t/p/";
    private final static String IMAGE_SIZE = "w185";

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView thumbnail;
        TextView title;
        TextView vote_average;
        TextView release_date;
        TextView plot;

        public ViewHolder(View view) {
            super(view);
            thumbnail = view.findViewById(R.id.iv_thumbnail);
            title = view.findViewById(R.id.tv_title);
            vote_average = view.findViewById(R.id.vote_average);
            release_date = view.findViewById(R.id.release_date);
            plot = view.findViewById(R.id.plot);

        }
    }
    public PopularMoviesAdapter(Context context, ArrayList<Movies> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
    @Override
    public int getItemCount() {
        return movies.size();
        //return 0;
    }

    @Override
    public PopularMoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_detail, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BASE_URL);
        stringBuilder.append(IMAGE_SIZE);
        stringBuilder.append(Movies.getPosterPath().trim());
        String url = stringBuilder.toString();
        Picasso.with(context).load(url)
                .into(thumbnail);


     //    Picasso.with(context).load(MainActivity.BASE_URL+ MainActivity.API_KEY).into(Target.class);
//        holder.thumbnail.setImageResource(Integer.parseInt(mData.get(position).getPoster_path()));
//        holder.title.setText(mData.get(position).getTitle());
//        holder.vote_average.setText(mData.get(position).getVoteAverage());
//        holder.release_date.setText(mData.get(position).getReleaseDate());
//        holder.plot.setText(mData.get(position).getOverview());


    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

