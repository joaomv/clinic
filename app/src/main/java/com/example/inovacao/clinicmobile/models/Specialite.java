package com.example.inovacao.clinicmobile.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by inovacao on 26/01/2018.
 */

public class Specialite implements Parcelable{

    public String name;
    public String description;

    public Specialite() {

    }

    public Specialite(String name, String description) {
        this.name = name;
        this.description = description;
    }

    protected Specialite(Parcel in) {
        name = in.readString();
        description = in.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Specialite createFromParcel(Parcel in) {
            return new Specialite(in);
        }

        public Specialite[] newArray(int size) {
            return new Specialite[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
    }
}
