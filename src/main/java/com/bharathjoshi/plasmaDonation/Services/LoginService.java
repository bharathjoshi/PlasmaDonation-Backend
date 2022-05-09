package com.bharathjoshi.plasmaDonation.Services;

import com.bharathjoshi.plasmaDonation.Beans.LoginDetails;
import com.bharathjoshi.plasmaDonation.Beans.primeUser;
import com.bharathjoshi.plasmaDonation.DataAccessObject.LoginRepository;

import javax.inject.Named;
import java.util.List;

@Named
public class LoginService {
    LoginRepository loginRepo;

    public LoginService(LoginRepository loginRepo){
        this.loginRepo = loginRepo;
    }
    public boolean authenticateUser(LoginDetails logDetails){
        List<primeUser> login = null;
        login = loginRepo.findByEmail(logDetails.getEmail());
        if(login.size()>0 && logDetails.getPassword().equals(login.get(0).getPassword())){
            return true;
        }
        return false;
    }
}
