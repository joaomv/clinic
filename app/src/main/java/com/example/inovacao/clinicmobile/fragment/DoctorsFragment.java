package com.example.inovacao.clinicmobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inovacao.clinicmobile.R;
import com.example.inovacao.clinicmobile.models.Doctor;
import com.example.inovacao.clinicmobile.viewholder.DoctorViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


/**
 * Created by joaoneto on 25/01/18.
 */

public class DoctorsFragment extends Fragment {

    private static final String TAG = "DoctorsFragment";

    // FIREBASE DATABASE
    private DatabaseReference mDatabase;

    private FirebaseRecyclerAdapter<Doctor, DoctorViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    public DoctorsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_doctors, container, false);

        // [START create_database_reference]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END create_database_reference]

        mRecycler = rootView.findViewById(R.id.doctors_list);
        mRecycler.setHasFixedSize(true);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Set up Layout Manager, reverse layout
        mManager = new LinearLayoutManager(getActivity());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        // Set up FirebaseRecyclerAdapter with the Query
        Query postsQuery = mDatabase.child("doctors")
                .limitToFirst(100);

        FirebaseRecyclerOptions options = new FirebaseRecyclerOptions.Builder<Doctor>()
                .setQuery(postsQuery, Doctor.class)
                .build();

        mAdapter = new FirebaseRecyclerAdapter<Doctor, DoctorViewHolder>(options) {
            @Override
            protected void onBindViewHolder(DoctorViewHolder holder, int position, Doctor model) {
                final DatabaseReference doctorKey = getRef(position);
                holder.bindToDoctor(model);

            }

            @Override
            public DoctorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(parent.getContext());
                return new DoctorViewHolder(inflater.inflate(R.layout.item_doctor, parent, false));
            }
        };
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

//    public String getUid() {
//        return FirebaseAuth.getInstance().getCurrentUser().getUid();
//    }

    //public abstract Query getQuery(DatabaseReference databaseReference);
}
