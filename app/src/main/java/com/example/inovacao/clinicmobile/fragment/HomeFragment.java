package com.example.inovacao.clinicmobile.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.inovacao.clinicmobile.R;
import com.example.inovacao.clinicmobile.SearchActivity;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

/**
 * Created by inovacao on 29/01/2018.
 */

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    DataPassListener mCallback;

    public interface DataPassListener{
        public void passData(String data);
    }

    // FIREBASE DATABASE
    private DatabaseReference mDatabase;

    private EditText mLookingEditText;
    private EditText mLocationEditText;
    private EditText mDateEditText;
    private EditText mInsuranceEditText;

    private Button mFindButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // [START create_database_reference]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END create_database_reference]

        // [START setup_listeners_filters]
        setListennersFilters(rootView);
        // [END setup_listeners_filters]

        mFindButton = rootView.findViewById(R.id.find_button);
        mFindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create fragment and give it an argument specifying the article it should show
                ScheduleFragment newFragment = new ScheduleFragment();
//                Bundle args = new Bundle();
//                args.putInt(ScheduleFragment.ARG_POSITION, position);
//                newFragment.setArguments(args);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.frame_layout, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();

            }
        });
        return rootView;
    }

    private void setListennersFilters(View rootView) {
        mLookingEditText = rootView.findViewById(R.id.et_looking);
        mLookingEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                getActivity().startActivity(intent);
                Log.d(TAG, "entrou click");
            }
        });

        mLocationEditText = rootView.findViewById(R.id.et_location);
        mLocationEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                try {
//                    Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
//                                    .build(this);
//                    startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
//                } catch (GooglePlayServicesRepairableException e) {
//                    // TODO: Solucionar o erro.
//                } catch (GooglePlayServicesNotAvailableException e) {
//                    // TODO: Solucionar o erro.
//                }

            }
        });

        mDateEditText = rootView.findViewById(R.id.et_date);
        mDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mcurrentDate=Calendar.getInstance();
                int mYear = mcurrentDate.get(Calendar.YEAR);
                int mMonth = mcurrentDate.get(Calendar.MONTH);
                int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        Log.d("DEBUG", "year: " + year + " month: " + month + " day: " + day);
                        mDateEditText.setText(day + "/" + month+1 + "/" + year);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.show();
            }
        });

        mInsuranceEditText = rootView.findViewById(R.id.et_insurance);
        mInsuranceEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
