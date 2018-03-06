package com.fynov.lib_data;

import java.util.Date;
import java.util.UUID;

public class Coupon {
    private String ID;
    public Double value;
    public Date expDate;
    public String color;
    private String barcode;

    public Coupon(){

    }
    public Coupon(Double value, Date expDate, String color, String barcode)
    {
        this.ID = UUID.randomUUID().toString().replaceAll("-", "");
        this.value=value;
        this.expDate=expDate;
        this.color=color;
        this.barcode=barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getID() {
        return ID;
    }

    public Double getValue() {
        return value;
    }
}
