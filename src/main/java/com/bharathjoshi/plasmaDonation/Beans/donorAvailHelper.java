package com.bharathjoshi.plasmaDonation.Beans;

public class donorAvailHelper {
    private String place;
    private String email;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public donorAvailHelper(){}
    public donorAvailHelper(String p, String e){
        this.place = p;
        this.email = e;
    }
}
