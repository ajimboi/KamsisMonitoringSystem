package com.example.kamsismonitoringpro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WardenHospitalityFragment extends Fragment {
    private DatabaseReference hospitalReference;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospitality_warden, container, false);
        hospitalReference = FirebaseDatabase.getInstance().getReference().child("Hospital");

        hospitalData();

        return view;
    }

    public void hospitalData() {
        hospitalReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot hospitalSnapshot : dataSnapshot.getChildren()) {
                    for (DataSnapshot exitChildSnapshot : hospitalSnapshot.getChildren()) {
                        Hospital hospital = exitChildSnapshot.getValue(Hospital.class);
                        addRowToTable(hospital);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors if needed
            }
        });
    }

    private void addRowToTable(Hospital hospital) {
        TableRow row = new TableRow(getContext());

        TextView matricNumberTextView = createTextView(hospital.getMatrixNumber(), 4);
        TextView detailsTextView = createTextView(hospital.getReason(), 4);
        TextView dateTextView = createTextView(hospital.getDate(), 4);
        TextView timeTextView = createTextView(hospital.getTime(), 4);

        row.addView(matricNumberTextView);
        row.addView(detailsTextView);
        row.addView(dateTextView);
        row.addView(timeTextView);

        TableLayout tableLayout = getView().findViewById(R.id.userDataTableHospital);
        tableLayout.addView(row);
    }

    private TextView createTextView(String text, int weight) {
        TextView textView = new TextView(getContext());
        TableRow.LayoutParams params = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, weight);
        textView.setLayoutParams(params);
        textView.setText(text);
        textView.setTextColor(getResources().getColor(R.color.black));
        textView.setPadding(10, 10, 10, 10);
        return textView;
    }


}