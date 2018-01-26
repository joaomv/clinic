package com.example.inovacao.clinicmobile.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.inovacao.clinicmobile.R;
import com.example.inovacao.clinicmobile.models.Doctor;

/**
 * Created by joaoneto on 26/01/18.
 */

public class DoctorViewHolder extends RecyclerView.ViewHolder {

    public TextView nameView;
//    public TextView authorView;
//    public ImageView starView;
//    public TextView numStarsView;
//    public TextView bodyView;

    public DoctorViewHolder(View itemView) {
        super(itemView);

        nameView = itemView.findViewById(R.id.doctor_name);
//        authorView = itemView.findViewById(R.id.post_author);
//        starView = itemView.findViewById(R.id.star);
//        numStarsView = itemView.findViewById(R.id.post_num_stars);
//        bodyView = itemView.findViewById(R.id.post_body);
    }

    public void bindToDoctor(Doctor doctor) {
        nameView.setText(doctor.name);
//        authorView.setText(post.author);
//        numStarsView.setText(String.valueOf(post.starCount));
//        bodyView.setText(post.body);

        //starView.setOnClickListener(starClickListener);
    }
}
