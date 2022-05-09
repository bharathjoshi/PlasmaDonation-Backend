package com.bharathjoshi.plasmaDonation.Services;

import com.bharathjoshi.plasmaDonation.Beans.primeUser;
import com.bharathjoshi.plasmaDonation.DataAccessObject.primeUserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class RegisterService {
    primeUserRepo prUserRepo;
    @Autowired
    public RegisterService(primeUserRepo prUserRepo){
        this.prUserRepo=prUserRepo;
    }
    public boolean registerUser(primeUser prmUser){
        primeUser n = new primeUser();
        n.setFirstName(prmUser.getFirstName());
        n.setLastName(prmUser.getLastName());

        n.setEmail(prmUser.getEmail());
        n.setAge(prmUser.getAge());

        n.setBloodGroup(prmUser.getBloodGroup());
        n.setPassword(prmUser.getPassword());

        n.setPhoneNumber(prmUser.getPhoneNumber());
        n.setDefaultPlace(prmUser.getDefaultPlace());

        primeUser temp = prUserRepo.save(n);
        if(temp == null)
            return false;
        return true;

    }
}
