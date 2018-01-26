package com.example.inovacao.clinicmobile.viewholder;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inovacao.clinicmobile.R;
import com.example.inovacao.clinicmobile.models.Doctor;
import com.squareup.picasso.Picasso;

/**
 * Created by joaoneto on 26/01/18.
 */

public class DoctorViewHolder extends RecyclerView.ViewHolder {

    public TextView nameView;
    public TextView specialiteView;
    public ImageView photoView;
    public TextView addressView;
//    public TextView bodyView;

    public DoctorViewHolder(View itemView) {
        super(itemView);

        nameView = itemView.findViewById(R.id.doctor_name);
        photoView = itemView.findViewById(R.id.doctor_photo);
        specialiteView = itemView.findViewById(R.id.doctor_specialite);
        addressView = itemView.findViewById(R.id.doctor_adress);
//        bodyView = itemView.findViewById(R.id.post_body);
    }

    public void bindToDoctor(Doctor doctor) {
        nameView.setText(doctor.name);
        specialiteView.setText(doctor.specialite);
//        numStarsView.setText(String.valueOf(post.starCount));
//        bodyView.setText(post.body);

        //starView.setOnClickListener(starClickListener);
    }
}
