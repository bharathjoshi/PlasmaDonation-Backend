package com.bharathjoshi.plasmaDonation.Beans;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "donorAvail")
public class donorAvail  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userEmail", referencedColumnName =  "email")
    private primeUser puser;

    @Column
    private String place;


    public donorAvail(){

    }

    public donorAvail(Integer id, primeUser puser, String place){
        this.id = id;
        this.puser = puser;
        this.place = place;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public primeUser getPuser() {
        return puser;
    }

    public void setPuser(primeUser puser) {
        this.puser = puser;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }




}
