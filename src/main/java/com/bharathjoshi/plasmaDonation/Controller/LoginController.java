package com.bharathjoshi.plasmaDonation.Controller;

import com.bharathjoshi.plasmaDonation.Beans.LoginDetails;
import com.bharathjoshi.plasmaDonation.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.core.Response;

import java.awt.*;

@RestController
@RequestMapping(path="/api")
@CrossOrigin(origins = "*")
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @PostMapping(path = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Response userAuthentication(@RequestBody final LoginDetails logDetails){
        if(this.loginService.authenticateUser(logDetails)) return Response.ok().build();
        return Response.status(401).build();
    }


}
