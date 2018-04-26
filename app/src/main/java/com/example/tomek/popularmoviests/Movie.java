package com.example.tomek.popularmoviests;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tomek on 2018-03-26.
 */

public class Movie implements Parcelable {

    private String title;
    private String poster;
    private String overview;
    private String voteAverage;
    private String releaseDate;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(poster);
        dest.writeString(overview);
        dest.writeString(voteAverage);
        dest.writeString(releaseDate);
    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator(){

        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie(Parcel in){
        title = in.readString();
        poster = in.readString();
        overview = in.readString();
        voteAverage = in.readString();
        releaseDate = in.readString();

    }
}



