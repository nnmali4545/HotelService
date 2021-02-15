/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelservice.Service;

import com.hotelservice.models.BookingDetails;
import com.hotelservice.models.Login;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 *
 * @author somnathmali
 */
@Service
public class loginservice {

    String strUserDetails = "{\"usr\":[{\"usr\":\"nayku.mali@gmail.com\",\"name\":\"Nayku\",\"pts\":520},{\"usr\":\"omkar.mali@gmail.com\",\"name\":\"Omkar\",\"pts\":\"712\"}]}";
    String strRoomDetails = "{\"room\":[{\"id\":1,\"prc\":520},{\"id\":2,\"prc\":712}]}";

    public JSONObject UserLogin(Login login) {
        Map<String, String> LoginDetails = new HashMap<>();

        JSONObject obj = new JSONObject();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
        LoginDetails.put(resourceBundle.getString("user1"), resourceBundle.getString("pass"));
        LoginDetails.put(resourceBundle.getString("user2"), resourceBundle.getString("pass2"));
        //  LoginDetails.put("omkar010", "Asd@123");

        JSONObject object = new JSONObject(strUserDetails);
        JSONArray jSONArray = (JSONArray) object.get("usr");
        if (LoginDetails.containsKey(login.getLid())) {
            if (LoginDetails.get(login.getLid()).equals(login.getPwd())) {
                obj.put("sts", 0);
                obj.put("erc", "");
                obj.put("str", "login succesfull");
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (login.getLid().equals(jSONArray.getJSONObject(i).getString("usr"))) {
                        obj.put("nme", jSONArray.getJSONObject(i).getString("name"));
                        obj.put("pts", jSONArray.getJSONObject(i).getInt("pts"));
                        obj.put("lid", jSONArray.getJSONObject(i).getString("usr"));
                    }
                }
            } else {
                obj.put("sts", -1);
                obj.put("erc", "");
                obj.put("str", "Invalid id Password");
            }
        } else {
            obj.put("sts", -1);
            obj.put("erc", "");
            obj.put("str", "Invalid id Password");
        }
        return obj;
    }

    public JSONObject SaveBookingDetails(BookingDetails bookingDetails) {
        String name = "";
        int point = 0;
        int price = 0;
        JSONObject obj = new JSONObject();
        JSONObject object = new JSONObject(strUserDetails);
        JSONArray jSONArray = (JSONArray) object.get("usr");
        JSONObject Room = new JSONObject(strRoomDetails);
        JSONArray BookDetails = (JSONArray) Room.get("room");

        for (int i = 0; i < jSONArray.length(); i++) {
            if (bookingDetails.getLid().equals(jSONArray.getJSONObject(i).getString("usr"))) {
                name = jSONArray.getJSONObject(i).getString("name");
                point = jSONArray.getJSONObject(i).getInt("pts");
            }
        }
        for (int i = 0; i < BookDetails.length(); i++) {
            if (bookingDetails.getRid() == BookDetails.getJSONObject(i).getInt("id")) {
                price = BookDetails.getJSONObject(i).getInt("prc");
            }
        }
        if (point >= price) {
            obj.put("name", name);
            obj.put("erc", "0");
            obj.put("str", "Booked");
          
        } else {
            obj.put("name", name);
            obj.put("erc", "-1");
            obj.put("str", "Pending");
        }
        return obj;
    }

}
//}
