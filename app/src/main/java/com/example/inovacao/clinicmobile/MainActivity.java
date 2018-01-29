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
import com.example.inovacao.clinicmobile.fragment.HomeFragment;
import com.example.inovacao.clinicmobile.models.Doctor;
import com.example.inovacao.clinicmobile.models.Location;
import com.example.inovacao.clinicmobile.models.Specialite;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

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
                    selectedFragment = new HomeFragment();
                    FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                    transaction1.replace(R.id.frame_layout, selectedFragment);
                    transaction1.commit();
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_medic:
                    selectedFragment = new DoctorsFragment();
                    FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                    transaction2.replace(R.id.frame_layout, selectedFragment);
                    transaction2.commit();
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

        //writeNewUser();
        //writeSpecialities();

    }

    private void writeNewUser() {

        Location location = new Location(-8.123133, -34.904368);

        DatabaseReference doctorsRef = mDatabase.child("doctors");
        Doctor doctor1 = new Doctor("Dr. Shirin Peters", "acupuncturist", "e7fa629b-c37b-4676-8bb4-7b6eb2a050a3zoom.jpg", location);
        doctorsRef.push().setValue(doctor1);

        Doctor doctor2 = new Doctor("Dr. Michele Martinho", "cardiologist", "8693zoom.jpg", location);
        doctorsRef.push().setValue(doctor2);

        Doctor doctor3 = new Doctor("Dr. Ahmadur Rahman", "allergist", "8c986ecb-3cc9-4c50-819b-8eb58e30551czoom.jpg", location);
        doctorsRef.push().setValue(doctor3);

        Doctor doctor4 = new Doctor("Dr. Sydney Mehl", "endrocrinologist", "a40fdc2c-fb74-406d-80f0-e1474f21a819zoom.jpg", location);
        doctorsRef.push().setValue(doctor4);

    }

    private void writeSpecialities() {

        DatabaseReference specialitiesRef = mDatabase.child("specialities");
        Map<String, Specialite> specialities = new HashMap<>();
        specialities.put("acupuncturist", new Specialite("Acupuntura", "ramo da medicina tradicional chinesa e um método de tratamento chamado complementar de acordo com a nova terminologia da OMS."));
        specialities.put("allergist", new Specialite("Alergia e Imunologia", "diagnóstico e tratamento das doenças alérgicas e do sistema imunológico."));
        specialities.put("cardiologist", new Specialite("Cardiologia", "aborda as doenças relacionadas com o coração e sistema vascular."));
        specialities.put("endrocrinologist", new Specialite("Endocrinologia e Metabologia", "é a área da Medicina responsável pelo cuidados aos hormônios, crescimento e glândulas como adrenal, tireoide, hipófise, pâncreas endócrino e outros."));

        specialitiesRef.setValue(specialities);
    }

}
