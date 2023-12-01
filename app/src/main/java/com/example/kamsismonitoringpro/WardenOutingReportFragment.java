package com.example.kamsismonitoringpro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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


public class WardenOutingReportFragment extends Fragment {

    private DatabaseReference outingExitReference, outingEntryReference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_outing_warden, container, false);
        outingExitReference = FirebaseDatabase.getInstance().getReference().child("outingExit");
        outingEntryReference = FirebaseDatabase.getInstance().getReference().child("outingEntry");


        loadOutingData();

        return view;
    }

    private void loadOutingData() {
        outingExitReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot exitSnapshot) {
                for (DataSnapshot matrixNumberSnapshot : exitSnapshot.getChildren()) {
                    // Iterate through the children of each "matrixNumber" node
                    for (DataSnapshot exitChildSnapshot : matrixNumberSnapshot.getChildren()) {
                        OutingExit outingExit = exitChildSnapshot.getValue(OutingExit.class);
                        addRowToTable(outingExit);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors if needed
            }
        });

        outingEntryReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot entrySnapshot) {
                for (DataSnapshot matrixNumberSnapshot : entrySnapshot.getChildren()) {
                    // Iterate through the children of each "matrixNumber" node
                    for (DataSnapshot entryChildSnapshot : matrixNumberSnapshot.getChildren()) {
                        OutingEntry outingEntry = entryChildSnapshot.getValue(OutingEntry.class);
                        addRowToTable(outingEntry);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors if needed
            }
        });
    }


    private void addRowToTable(OutingExit outingExit) {
        TableRow row = new TableRow(getContext());

        TextView labelTextView = createTextView("Exit", 1);
        TextView detailsTextView = createTextView(outingExit.getReason(), 4); // Weight 4
        TextView matricNumberTextView = createTextView(outingExit.getMatrixNumber(), 4); // Weight 4
        TextView dateTextView = createTextView(outingExit.getDate(), 4); // Weight 4
        TextView timeTextView = createTextView(outingExit.getTime(), 4); // Weight 4

        row.addView(labelTextView);
        row.addView(detailsTextView);
        row.addView(matricNumberTextView);
        row.addView(dateTextView);
        row.addView(timeTextView);

        TableLayout tableLayout = getView().findViewById(R.id.userDataTable);
        tableLayout.addView(row);
    }

    private void addRowToTable(OutingEntry outingEntry) {
        TableRow row = new TableRow(getContext());

        TextView labelTextView = createTextView("Entry", 1);
        TextView detailsTextView = createTextView(outingEntry.getReason(), 4); // Weight 4
        TextView matricNumberTextView = createTextView(outingEntry.getMatrixNumber(), 4); // Weight 4
        TextView dateTextView = createTextView(outingEntry.getDate(), 4); // Weight 4
        TextView timeTextView = createTextView(outingEntry.getTime(), 4); // Weight 4

        row.addView(labelTextView);
        row.addView(detailsTextView);
        row.addView(matricNumberTextView);
        row.addView(dateTextView);
        row.addView(timeTextView);

        TableLayout tableLayout = getView().findViewById(R.id.userDataTable);
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