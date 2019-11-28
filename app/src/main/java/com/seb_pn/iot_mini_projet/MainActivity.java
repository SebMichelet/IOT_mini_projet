package com.seb_pn.iot_mini_projet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    // Elements for local sensors values
    private TextView mLumLocalText;
    private TextView mTempLocalText;
    private TextView mHumLocalText;

    // Elements for exterior sensors values
    private TextView mLumExtText;
    private TextView mTempExtText;
    private TextView mHumExtText;

    // Connection to the Firebase database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    final DatabaseReference lumLocalValue = myRef.child("Capteurs").child("Local").child("Luminance");
    final DatabaseReference tempLocalValue = myRef.child("Capteurs").child("Local").child("Temperature");
    final DatabaseReference humLocalValue = myRef.child("Capteurs").child("Local").child("Humidite");

    final DatabaseReference lumExtValue = myRef.child("Capteurs").child("Exterieur").child("Luminance");
    final DatabaseReference tempExtValue = myRef.child("Capteurs").child("Exterieur").child("Temperature");
    final DatabaseReference humExtValue = myRef.child("Capteurs").child("Exterieur").child("Humidite");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLumLocalText = findViewById(R.id.activity_main_lum_local_value);
        mTempLocalText = findViewById(R.id.activity_main_temp_local_value);
        mHumLocalText = findViewById(R.id.activity_main_hum_local_value);

        mLumExtText = findViewById(R.id.activity_main_lum_ext_value);
        mTempExtText = findViewById(R.id.activity_main_temp_ext_value);
        mHumExtText = findViewById(R.id.activity_main_hum_ext_value);

        lumLocalValue.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double value = dataSnapshot.getValue(Double.class);
                mLumLocalText.setText(String.valueOf(value));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("file", "failed to read lum local", databaseError.toException());
            }
        });

        tempLocalValue.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double value = dataSnapshot.getValue(Double.class);
                mTempLocalText.setText(String.valueOf(value));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("file", "failed to read temp local", databaseError.toException());
            }
        });

        humLocalValue.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double value = dataSnapshot.getValue(Double.class);
                mHumLocalText.setText(String.valueOf(value));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("file", "failed to read hum local", databaseError.toException());
            }
        });

        lumExtValue.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double value = dataSnapshot.getValue(Double.class);
                mLumExtText.setText(String.valueOf(value));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("file", "failed to read lum ext", databaseError.toException());
            }
        });

        tempExtValue.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double value = dataSnapshot.getValue(Double.class);
                mTempExtText.setText(String.valueOf(value));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("file", "failed to read temp ext", databaseError.toException());
            }
        });

        humExtValue.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Double value = dataSnapshot.getValue(Double.class);
                mHumExtText.setText(String.valueOf(value));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.v("file", "failed to read hum ext", databaseError.toException());
            }
        });
    }
}
