package com.bharathjoshi.plasmaDonation.Controller;

import com.bharathjoshi.plasmaDonation.Beans.primeUser;
import com.bharathjoshi.plasmaDonation.Services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api")
public class RegisterController {

    private RegisterService regService;
    @Autowired
    public RegisterController(RegisterService regService){
        this.regService = regService;
    }
    @PostMapping(path="/addUser", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Response addUserDate(@RequestBody primeUser prmUser){
        boolean result = regService.registerUser(prmUser);
        if(result){
            return Response.ok().build();
        }
        return Response.status(401).build();

    }

}
