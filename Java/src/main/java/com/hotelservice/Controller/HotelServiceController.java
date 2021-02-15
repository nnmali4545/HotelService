/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelservice.Controller;

import com.hotelservice.Service.HotelServiceService;
import com.hotelservice.Service.loginservice;
import com.hotelservice.models.BookingDetails;
import com.hotelservice.models.Login;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Server")
public class HotelServiceController {
    @Autowired
    private loginservice logins;
    
    @RequestMapping(method = RequestMethod.POST, value = "/UserLogin", headers = "Accept=application/JSON")
    @ResponseBody
    public String UserLogin(@RequestBody Login login) {
       JSONObject sts= logins.UserLogin(login);
       return sts.toString();  
    }
    @RequestMapping(method = RequestMethod.POST, value = "/Booking", headers = "Accept=application/JSON")
    @ResponseBody
    public String Booking(@RequestBody BookingDetails bookingDetails) {
        JSONObject sts=logins.SaveBookingDetails(bookingDetails);
       return sts.toString();
    }
    
 
}
