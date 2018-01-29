package com.example.inovacao.clinicmobile.models;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by inovacao on 26/01/2018.
 */

public class Location implements Parcelable {

    public Double latitude;
    public Double longitude;

    public Location(){

    }

    public Location(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
    }

    // Creator
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    // "De-parcel object
    protected Location(Parcel in) {
        latitude = in.readDouble();
        longitude = in.readDouble();
    }
}
