package com.bharathjoshi.plasmaDonation.Beans;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "donorAvail")
public class donorAvail  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userEmail", referencedColumnName =  "email")
    private primeUser puser;

}
