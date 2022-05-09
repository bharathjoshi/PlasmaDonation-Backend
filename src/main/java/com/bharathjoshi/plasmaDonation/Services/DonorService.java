package com.bharathjoshi.plasmaDonation.Services;

import com.bharathjoshi.plasmaDonation.Beans.donorAvail;
import com.bharathjoshi.plasmaDonation.Beans.donorAvailHelper;
import com.bharathjoshi.plasmaDonation.Beans.donorDeleteHelper;
import com.bharathjoshi.plasmaDonation.Beans.primeUser;
import com.bharathjoshi.plasmaDonation.DataAccessObject.LoginRepository;
import com.bharathjoshi.plasmaDonation.DataAccessObject.DonorRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;
import java.util.List;



@Named
public class DonorService {
    DonorRepo dAvailRepo;
    LoginRepository loginRepo;
    @Autowired
    public DonorService(DonorRepo dAvailRepo, LoginRepository loginRepo){
        this.dAvailRepo = dAvailRepo;
        this.loginRepo = loginRepo;
    }
    public boolean addDonor(donorAvailHelper dAvailhelper){
        donorAvail d = new donorAvail();
        d.setPlace(dAvailhelper.getPlace());
        //d.setId(dAvail.getId());

        List<primeUser> login = loginRepo.findByEmail(dAvailhelper.getEmail());


        d.setPuser(login.get(0));

        donorAvail temp = dAvailRepo.save(d);
        if(temp == null){
            return false;
        }
        return true;
    }

    public void deleteDonor(String place, String email){
        List<donorAvail> donors = dAvailRepo.getDonors(place, email);
        if(donors.isEmpty()){
            return;
        }
        dAvailRepo.deleteById(donors.get(0).getId());
    }
    public List<Object[]> getDonorsBasedonLocation(String location){
        return dAvailRepo.getDonorDetailsBasedonLocation(location);
    }
    public List<Object[]> getDonorDetailsBasedonBloodGroup(String bloodGroup){
        return dAvailRepo.getDonorDetailsBasedonBloodGroup(bloodGroup);
    }
    public List<Object[]> getDonorDetailsBasedonBloodGroupandLocation(String bloodGroup, String location){
        return dAvailRepo.getDonorDetailsBasedonBloodGroupandLocation(bloodGroup,location);
    }

}
