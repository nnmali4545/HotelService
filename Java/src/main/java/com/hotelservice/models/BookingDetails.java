/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelservice.models;

/**
 *
 * @author somnathmali
 */
public class BookingDetails {
    String cdate;
    String odate;
String lid;

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }
    int rid;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
    private String sts;

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }


    

    public String getSts() {
        return sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }
    
}
