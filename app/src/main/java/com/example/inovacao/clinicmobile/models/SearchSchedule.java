package com.example.inovacao.clinicmobile.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by inovacao on 29/01/2018.
 */

public class SearchSchedule implements Parcelable {

    public Specialite specialite;
    public Location location;
    public Date date;

    public SearchSchedule() {

    }

    public SearchSchedule(Specialite specialite, Location location, Date date) {
        this.specialite = specialite;
        this.location = location;
        this.date = date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(specialite, i);
        parcel.writeParcelable(location, i);
        parcel.writeLong(date != null ? date.getTime() : -1);
    }

    public SearchSchedule(Parcel in) {
        specialite = in.readParcelable(Specialite.class.getClassLoader());
        location = in.readParcelable(Location.class.getClassLoader());
        long tmpDate = in.readLong();
        this.date = tmpDate == -1 ? null : new Date(tmpDate);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public SearchSchedule createFromParcel(Parcel in) {
            return new SearchSchedule(in);
        }

        public SearchSchedule[] newArray(int size) {
            return new SearchSchedule[size];
        }
    };
}
