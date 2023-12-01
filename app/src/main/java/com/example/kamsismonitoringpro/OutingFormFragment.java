package com.example.kamsismonitoringpro;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;


import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;


public class OutingFormFragment extends Fragment {

    private Button pickDateTimeButton1,pickDateTimeButton2,pickDateTimeButton3;
    private String selectedDate;
    private String selectedTime;
    private String reason;
    private String hospital;
    private String matrixNumber;

    private DatabaseReference outingReference,outingReferenceEntry,HospitalReference;

    public static OutingFormFragment newInstance() {

        return new OutingFormFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_outing_form, container, false);

        // Retrieve user session (matrix number) from SharedPreferences
        SharedPreferences sharedPreferences = requireContext().getSharedPreferences("userSession", Context.MODE_PRIVATE);
        matrixNumber = sharedPreferences.getString("matrixNumber", "");

        outingReference = FirebaseDatabase.getInstance().getReference().child("outingExit");
        outingReferenceEntry = FirebaseDatabase.getInstance().getReference().child("outingEntry");
        HospitalReference = FirebaseDatabase.getInstance().getReference().child("Hospital");

        checkOutingAvailability();

        pickDateTimeButton1 = view.findViewById(R.id.pickDateTimeButton1);
        pickDateTimeButton2 = view.findViewById(R.id.pickDateTimeButton2);
        pickDateTimeButton3 = view.findViewById(R.id.pickDateTimeButton3);
        pickDateTimeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOutingAvailable) {
                    showDateTimePicker();
                } else {
                    Toast.makeText(requireContext(), "Please enter first before making the next exit", Toast.LENGTH_SHORT).show();
                }
            }
        });

        pickDateTimeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOutingAvailable) {
                    Toast.makeText(requireContext(), "Please exit first before making the next entry", Toast.LENGTH_SHORT).show();
                } else {
                    showDateTimePickerEntry();
                }
            }
        });
        pickDateTimeButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimePickerHospital();
            }
        });


        return view;
    }
    private boolean isOutingAvailable = true;
    private void checkOutingAvailability() {
        DatabaseReference availabilityReference = FirebaseDatabase.getInstance().getReference().child("outingAvailability");

        availabilityReference.child(matrixNumber).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // If the node exists and its value is "unavailable," set isOutingAvailable to false
                if (dataSnapshot.exists() && "unavailable".equals(dataSnapshot.getValue(String.class))) {
                    isOutingAvailable = false;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors if needed
            }
        });
    }
    private void showDateTimePickerHospital() {
        // Get the current date and time
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Show Date Picker
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        Toast.makeText(requireContext(), "Selected Date: " + selectedDate, Toast.LENGTH_SHORT).show();

                        // Initialize hospital with a default value
                        hospital = "Default Hospital";

                        // After selecting the date, show the time picker
                        showTimePickerEntryHospital();
                    }
                },
                year, month, day
        );
        datePickerDialog.show();
    }
    private void showTimePickerEntryHospital() {
        // Get the current time
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Show Time Picker
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                requireContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedTime = hourOfDay + ":" + minute;
                        Toast.makeText(requireContext(), "Selected Time: " + selectedTime, Toast.LENGTH_SHORT).show();

                        // Save data to Firebase
                        showReasonDialogHospital();
                    }
                },
                hour, minute, true
        );
        timePickerDialog.show();
    }

    private void showReasonDialogHospital() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Enter Reason");

        final EditText input = new EditText(requireContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reason = input.getText().toString();
                Toast.makeText(requireContext(), "Reason: " + reason, Toast.LENGTH_SHORT).show();
                saveToFirebaseHospital();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void showDateTimePickerEntry() {
        // Get the current date and time
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        Toast.makeText(requireContext(), "Selected Date: " + selectedDate, Toast.LENGTH_SHORT).show();


                        showTimePickerEntry();
                    }
                },
                year, month, day
        );
        datePickerDialog.show();
    }
    private void showTimePickerEntry() {
        // Get the current time
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Show Time Picker
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                requireContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedTime = hourOfDay + ":" + minute;
                        Toast.makeText(requireContext(), "Selected Time: " + selectedTime, Toast.LENGTH_SHORT).show();

                        // Save data to Firebase
                        saveToFirebaseEntry();
                    }
                },
                hour, minute, true
        );
        timePickerDialog.show();
    }

    private void showDateTimePicker() {
        // Get the current date and time
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Show Date Picker
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                requireContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        Toast.makeText(requireContext(), "Selected Date: " + selectedDate, Toast.LENGTH_SHORT).show();

                        showTimePicker();
                    }
                },
                year, month, day
        );
        datePickerDialog.show();
    }

    private void showTimePicker() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                requireContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedTime = hourOfDay + ":" + minute;
                        Toast.makeText(requireContext(), "Selected Time: " + selectedTime, Toast.LENGTH_SHORT).show();
                        showOptionsDialog();
                    }
                },
                hour, minute, true
        );
        timePickerDialog.show();
    }

    private void showOptionsDialog() {
        final CharSequence[] options = {"Bermalam", "Outing", "Lain-lain"};

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Choose an option");
        builder.setItems(options, (dialog, item) -> {
            String selectedOption = options[item].toString();
            if ("Lain-lain".equals(selectedOption)) {
                showReasonDialog();
            } else {
                reason = selectedOption;
                Toast.makeText(requireContext(), "Reason: " + reason, Toast.LENGTH_SHORT).show();
                saveToFirebase();
            }
        });
        builder.show();
    }

    private void showReasonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Enter Reason");

        final EditText input = new EditText(requireContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reason = input.getText().toString();
                Toast.makeText(requireContext(), "Reason: " + reason, Toast.LENGTH_SHORT).show();
                saveToFirebase();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void saveToFirebase() {
        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference("outingExit").child(matrixNumber).push();
        OutingExit outingExit = new OutingExit(matrixNumber, selectedDate, selectedTime, reason, "unavailable");
        userReference.setValue(outingExit);
        updateOutingAvailabilityStatus();
    }
    private void saveToFirebaseEntry() {
        DatabaseReference userReference = FirebaseDatabase.getInstance().getReference("outingEntry").child(matrixNumber).push();
        OutingExit outingExit = new OutingExit(matrixNumber, selectedDate, selectedTime, "", "available");
        userReference.setValue(outingExit);
        updateOutingAvailabilityStatusForEntry();
    }
    private void saveToFirebaseHospital() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Enter Hospital Name");

        final EditText input = new EditText(requireContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                hospital = input.getText().toString();
                Toast.makeText(requireContext(), "Hospital: " + hospital, Toast.LENGTH_SHORT).show();

                DatabaseReference userReference = FirebaseDatabase.getInstance().getReference("Hospital").child(matrixNumber).push();
                Hospital hospitalObject = new Hospital(matrixNumber, selectedDate, selectedTime, reason, hospital);
                userReference.setValue(hospitalObject);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void updateOutingAvailabilityStatusForEntry() {
        DatabaseReference availabilityReference = FirebaseDatabase.getInstance().getReference().child("outingAvailability");
        availabilityReference.child(matrixNumber).setValue("available");
    }

    private void updateOutingAvailabilityStatus() {
        DatabaseReference availabilityReference = FirebaseDatabase.getInstance().getReference().child("outingAvailability");
        availabilityReference.child(matrixNumber).setValue("unavailable");
    }
}