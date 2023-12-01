package com.example.kamsismonitoringpro;

public class HelperClass {

    private String name;
    private String matrix;
    private String phone;
    private String email; // Add email field
    private String password;

    // Default constructor is still needed for Firebase
    public HelperClass() {
        // Default constructor required by Firebase
    }
    public HelperClass(String name, String matrix, String phone, String email, String password) {
        this.name = name;
        this.matrix = matrix;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatrix() {
        return matrix;
    }

    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "HelperClass{" +
                "name='" + name + '\'' +
                ", matrix='" + matrix + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
