package com.bharathjoshi.plasmaDonation.Beans;

public class LoginDetails {

    private String email;
    private String password;

    public LoginDetails(){}
    public LoginDetails(String e, String p){
        this.email = e;
        this.password = p;
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
}
