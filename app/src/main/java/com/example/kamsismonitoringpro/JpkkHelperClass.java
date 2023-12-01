package com.example.kamsismonitoringpro;

public class JpkkHelperClass {
    private String jpkk_name;
    private String jpkk_matrix;
    private String jpkk_phone;
    private String jpkk_email;
    private String jpkk_password;

    public JpkkHelperClass() {
        // Default constructor required by Firebase
    }
    public JpkkHelperClass(String jpkk_name, String jpkk_matrix, String jpkk_phone, String jpkk_email, String jpkk_password) {
        this.jpkk_name = jpkk_name;
        this.jpkk_matrix = jpkk_matrix;
        this.jpkk_phone = jpkk_phone;
        this.jpkk_email = jpkk_email;
        this.jpkk_password = jpkk_password;
    }

    public String getJpkk_name() {
        return jpkk_name;
    }

    public void setJpkk_name(String jpkk_name) {
        this.jpkk_name = jpkk_name;
    }

    public String getJpkk_matrix() {
        return jpkk_matrix;
    }

    public void setJpkk_matrix(String jpkk_matrix) {
        this.jpkk_matrix = jpkk_matrix;
    }

    public String getJpkk_phone() {
        return jpkk_phone;
    }

    public void setJpkk_phone(String jpkk_phone) {
        this.jpkk_phone = jpkk_phone;
    }

    public String getJpkk_email() {
        return jpkk_email;
    }

    public void setJpkk_email(String jpkk_email) {
        this.jpkk_email = jpkk_email;
    }

    public String getJpkk_password() {
        return jpkk_password;
    }

    public void setJpkk_password(String jpkk_password) {
        this.jpkk_password = jpkk_password;
    }

    @Override
    public String toString() {
        return "JpkkHelperClass{" +
                "jpkk_name='" + jpkk_name + '\'' +
                ", jpkk_matrix='" + jpkk_matrix + '\'' +
                ", jpkk_phone='" + jpkk_phone + '\'' +
                ", jpkk_email='" + jpkk_email + '\'' +
                ", jpkk_password='" + jpkk_password + '\'' +
                '}';
    }
}
