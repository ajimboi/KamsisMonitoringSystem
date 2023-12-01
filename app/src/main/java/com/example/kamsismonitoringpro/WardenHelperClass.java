package com.example.kamsismonitoringpro;

public class WardenHelperClass {
    private String warden_name;
    private String warden_idNumber;
    private String warden_phone;
    private String warden_email;
    private String warden_password;

    public WardenHelperClass() {
        // Default constructor required by Firebase
    }
    public WardenHelperClass(String warden_name, String warden_idNumber, String warden_phone, String warden_email, String warden_password) {
        this.warden_name = warden_name;
        this.warden_idNumber = warden_idNumber;
        this.warden_phone = warden_phone;
        this.warden_email = warden_email;
        this.warden_password = warden_password;
    }

    public String getWarden_name() {
        return warden_name;
    }

    public void setWarden_name(String warden_name) {
        this.warden_name = warden_name;
    }

    public String getWarden_idNumber() {
        return warden_idNumber;
    }

    public void setWarden_idNumber(String warden_idNumber) {
        this.warden_idNumber = warden_idNumber;
    }

    public String getWarden_phone() {
        return warden_phone;
    }

    public void setWarden_phone(String warden_phone) {
        this.warden_phone = warden_phone;
    }

    public String getWarden_email() {
        return warden_email;
    }

    public void setWarden_email(String warden_email) {
        this.warden_email = warden_email;
    }

    public String getWarden_password() {
        return warden_password;
    }

    public void setWarden_password(String warden_password) {
        this.warden_password = warden_password;
    }

    @Override
    public String toString() {
        return "WardenHelperClass{" +
                "warden_name='" + warden_name + '\'' +
                ", warden_id='" + warden_idNumber + '\'' +
                ", warden_phone='" + warden_phone + '\'' +
                ", warden_email='" + warden_email + '\'' +
                ", warden_password='" + warden_password + '\'' +
                '}';
    }
}
