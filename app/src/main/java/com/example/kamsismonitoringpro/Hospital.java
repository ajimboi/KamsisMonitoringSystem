package com.example.kamsismonitoringpro;

public class Hospital {
    private String matrixNumber;
    private String date;
    private String time;
    private String reason;
    private String hospital;
    public Hospital() {
        // Default constructor required for calls to DataSnapshot.getValue(Outing.class)
    }

    public Hospital(String matrixNumber, String date, String time, String reason, String hospital) {
        this.matrixNumber = matrixNumber;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.hospital = hospital;
    }
    public String getMatrixNumber() {
        return matrixNumber;
    }

    public void setMatrixNumber(String matrixNumber) {
        this.matrixNumber = matrixNumber;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}

