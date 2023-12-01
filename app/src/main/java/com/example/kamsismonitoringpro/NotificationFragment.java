package com.example.kamsismonitoringpro;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NotificationFragment extends Fragment {

    private DatabaseReference outingExitReference,outingEntryReference,HospitalReference;
    private String matrixNumber;

    private TextView categoryExit, dateExit, timeExit, dateEntry, timeEntry, DateHospital, TimeHospital, Hospital, ReasonHospital;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("userSession", Context.MODE_PRIVATE);
        matrixNumber = sharedPreferences.getString("matrixNumber", "");

        outingExitReference = FirebaseDatabase.getInstance().getReference().child("outingExit");
        outingEntryReference = FirebaseDatabase.getInstance().getReference().child("outingEntry");
        HospitalReference = FirebaseDatabase.getInstance().getReference().child("Hospital");

        categoryExit = view.findViewById(R.id.CategoryExit);
        dateExit = view.findViewById(R.id.DateExit);
        timeExit = view.findViewById(R.id.TimeExit);
        dateEntry = view.findViewById(R.id.DateEntry);
        timeEntry = view.findViewById(R.id.TimeEntry);
        DateHospital = view.findViewById(R.id.DateHospital);
        TimeHospital = view.findViewById(R.id.TimeHospital);
        Hospital = view.findViewById(R.id.Hospital);
        ReasonHospital = view.findViewById(R.id.ReasonHospital);

        loadOutingExitData();
        loadOutingEntryData();
        loadHospitalData();

        return view;
    }

    private void loadOutingExitData() {
        DatabaseReference userReference = outingExitReference.child(matrixNumber);

        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    List<OutingExit> outingExits = new ArrayList<>();

                    for (DataSnapshot entrySnapshot : dataSnapshot.getChildren()) {
                        // For each child node under matrixNumber, retrieve the data
                        OutingExit outingExit = entrySnapshot.getValue(OutingExit.class);
                        if (outingExit != null) {
                            outingExits.add(outingExit);
                        }
                    }

                    // Update your UI or perform any necessary actions with the list of OutingExit objects
                    updateTextViewsForMultipleExits(outingExits);
                } else {
                    // Handle the case when there is no data under the matrixNumber node
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors if needed
            }
        });
    }
    private void loadOutingEntryData() {
        DatabaseReference userReference = outingEntryReference.child(matrixNumber);

        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    List<OutingEntry> outingEntries = new ArrayList<>();

                    for (DataSnapshot entrySnapshot : dataSnapshot.getChildren()) {
                        // Check the data type before attempting to convert
                        if (entrySnapshot.getValue() instanceof Map) {
                            // For each child node under matrixNumber, retrieve the data
                            OutingEntry outingEntry = entrySnapshot.getValue(OutingEntry.class);
                            if (outingEntry != null) {
                                outingEntries.add(outingEntry);
                            }
                        } else {
                            // Handle the case where the data is not an OutingEntry object
                            Log.w(TAG, "Data under matrixNumber is not an OutingEntry object");
                        }
                    }

                    // Update your UI or perform any necessary actions with the list of OutingEntry objects
                    updateTextViewsForMultipleEntries(outingEntries);
                } else {
                    // Handle the case when there is no data under the matrixNumber node
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors if needed
            }
        });
    }



    private void loadHospitalData() {
        DatabaseReference userReference = HospitalReference.child(matrixNumber);

        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    List<Hospital> hospitals = new ArrayList<>();

                    for (DataSnapshot entrySnapshot : dataSnapshot.getChildren()) {
                        // Check the data type before attempting to convert
                        if (entrySnapshot.getValue() instanceof Map) {
                            // For each child node under matrixNumber, retrieve the data
                            Hospital hospital = entrySnapshot.getValue(Hospital.class);
                            if (hospital != null) {
                                hospitals.add(hospital);
                            }
                        } else {
                            // Handle the case where the data is not a Hospital object
                            Log.w(TAG, "Data under matrixNumber is not a Hospital object");
                        }
                    }

                    // Update your UI or perform any necessary actions with the list of Hospital objects
                    updateTextViewsForMultipleHospitals(hospitals);
                } else {
                    // Handle the case when there is no data under the matrixNumber node
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors if needed
            }
        });
    }
    private void updateTextViewsForMultipleHospitals(List<Hospital> hospitals) {
        // Clear the existing text
        StringBuilder fulltext = new StringBuilder();

        // Loop through each hospital entry and append the data to the StringBuilders
        for (Hospital hospital : hospitals) {
            fulltext.append("Date: ").append(hospital.getDate()).append("\n");
            fulltext.append("Time: ").append(hospital.getTime()).append("\n");
            fulltext.append("Reason: ").append(hospital.getReason()).append("\n");
            fulltext.append("Hospital / Clinic Name: ").append(hospital.getHospital()).append("\n\n");
        }
        DateHospital.setText(fulltext.toString());
    }


    private void updateTextViewsForMultipleExits(List<OutingExit> outingExits) {
        // Clear the existing text
        StringBuilder fullText = new StringBuilder();

        // Loop through each outing exit and append the data to the StringBuilder
        for (OutingExit outingExit : outingExits) {
            fullText.append("Category: ").append(outingExit.getReason()).append("\n");
            fullText.append("Date: ").append(outingExit.getDate()).append("\n");
            fullText.append("Time: ").append(outingExit.getTime()).append("\n\n");
        }

        // Set the concatenated text to the TextView
        categoryExit.setText(fullText.toString());
    }


    private void updateTextViewsForMultipleEntries(List<OutingEntry> outingEntries) {
        // Clear the existing text
        StringBuilder fullText = new StringBuilder();

        // Loop through each outing entry and append the data to the StringBuilder
        for (OutingEntry outingEntry : outingEntries) {
            fullText.append("Date: ").append(outingEntry.getDate()).append("\n");
            fullText.append("Time: ").append(outingEntry.getTime()).append("\n\n");
        }

        // Set the concatenated text to the TextViews
        dateEntry.setText(fullText.toString());
        timeEntry.setText(""); // Clear the timeEntry TextView if needed
    }

}