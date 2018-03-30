package com.example.tomek.popularmoviests;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tomek on 2018-03-26.
 */

public class Movies implements Parcelable {

    private String title;
    private String posterPath;
    private String overview;
    private int voteAverage;
    private int releaseDate;

    public Movies(String title, String poster_path, String overview, int voteAverage, int releaseDate) {
        this.title = title;
        this.posterPath = poster_path;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
    }

    public static final Parcelable.Creator<Movies> CREATOR
            = new Parcelable.Creator<Movies>() {
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public  String getPosterPath() {return posterPath;}

    public String getOverview() {
        return overview;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(posterPath);
        dest.writeString(overview);
        dest.writeInt(voteAverage);
        dest.writeInt(releaseDate);
    }
    //I'm not sure ...
    private Movies(Parcel in) {
        String[] data = new String[2];
        in.readStringArray(data);
        this.title = data[0];
        this.posterPath = data[0];
        this.overview = data [0];
        this.voteAverage = Integer.parseInt(data [0]);
        this.releaseDate = Integer.parseInt(data [0]);
    }
}



