package com.bharathjoshi.plasmaDonation.Controller;

import com.bharathjoshi.plasmaDonation.Beans.donorAvailHelper;
import com.bharathjoshi.plasmaDonation.Services.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/api")
public class DonorController {
    private DonorService DonorService;

    @Autowired
    public DonorController(DonorService DonorService){
        this.DonorService = DonorService;
    }
    @PostMapping(path="/addDonor", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Response addDonor(@RequestBody donorAvailHelper dAvailHelper){
        boolean result = DonorService.addDonor(dAvailHelper);
        if(result){
            return Response.ok().build();
        }
        return Response.status(401).build();
    }
    @GetMapping("/getDonorsIn/{location}")
    public List<Object[]> getDonorsbasedonLocation(@PathVariable String location){
        return  DonorService.getDonorsBasedonLocation(location);
    }
    @GetMapping("/getDonorsOf/{bloodGroup}")
    public List<Object[]> getDonorsbasedonBloodGroup(@PathVariable String bloodGroup){
        return  DonorService.getDonorDetailsBasedonBloodGroup(bloodGroup);
    }
    @DeleteMapping("/deleteDonor")
    public void deleteDonor(@RequestParam String location, @RequestParam String user_email){
        DonorService.deleteDonor(location, user_email);
    }
   @GetMapping("/getDonorsOfIn")
    public List<Object[]> getDonorsbasedonBloodGroupandLocation(@RequestParam String bloodGroup, @RequestParam String location){
        return  DonorService.getDonorDetailsBasedonBloodGroupandLocation(location,bloodGroup);
    }







}
