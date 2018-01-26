package com.example.inovacao.clinicmobile.models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by joaoneto on 26/01/18.
 */

@IgnoreExtraProperties
public class Doctor {

    public String name;

    public Doctor() {

    }

    public Doctor(String name) {
        this.name = name;
    }
}
