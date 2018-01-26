package com.example.inovacao.clinicmobile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inovacao.clinicmobile.fragment.DoctorsFragment;
import com.example.inovacao.clinicmobile.models.Doctor;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    // FIREBASE DATABASE
    private DatabaseReference mDatabase;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_medic:
                    selectedFragment = new DoctorsFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_layout, selectedFragment);
                    transaction.commit();
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_profile:
                    //mTextMessage.setText(R.string.title_profile);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigation.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView =
                    menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams =
                    iconView.getLayoutParams();
            final DisplayMetrics displayMetrics =
                    getResources().getDisplayMetrics();
            layoutParams.height = (int)
                    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 28,
                            displayMetrics);
            layoutParams.width = (int)
                    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 28,
                            displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // [START create_database_reference]
        mDatabase = FirebaseDatabase.getInstance().getReference();
        // [END create_database_reference]

        //writeNewUser("teste", "Teste");
    }

    private void writeNewUser(String userId, String name) {


        DatabaseReference doctorsRef = mDatabase.child("doctors");
        Map<String, Doctor> doctors = new HashMap<>();
        doctors.put("alan", new Doctor("Alan Silva"));
        doctors.put("silva", new Doctor("Silva Alan"));

        doctorsRef.setValue(doctors);
    }

}
