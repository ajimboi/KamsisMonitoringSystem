package com.example.kamsismonitoringpro;
public class OutingEntry {
    private String matrixNumber;
    private String date;
    private String time;
    private String reason;
    private String status;


    public OutingEntry() {

    }

    public OutingEntry(String matrixNumber, String date, String time, String reason, String status) {
        this.matrixNumber = matrixNumber;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
