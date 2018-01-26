package com.example.inovacao.clinicmobile.models;

import android.net.Uri;

import com.google.firebase.database.IgnoreExtraProperties;

import java.lang.reflect.Array;
import java.net.URI;

/**
 * Created by joaoneto on 26/01/18.
 */

@IgnoreExtraProperties
public class Doctor {

    public String name;
    public String specialite;
    public String photoUrl;
    public Location location;

    public Doctor() {

    }

    public Doctor(String name, String specialite, String photoUrl, Location location) {
        this.name = name;
        this.specialite = specialite;
        this.photoUrl = photoUrl;
        this.location = location;
    }
}
