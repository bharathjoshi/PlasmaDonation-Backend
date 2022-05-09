package com.bharathjoshi.plasmaDonation.Beans;

public class donorDeleteHelper {




    public String bloodGroup;

    public String place;

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public donorDeleteHelper() {

    }

    public donorDeleteHelper(String bloodGroup, String place) {
        this.bloodGroup = bloodGroup;
        this.place = place;
    }
}
