package com.fynov.lib_data;

import java.util.ArrayList;

/**
 * Created by Bor on 05/03/2018.
 */

public class DataAll {
    ArrayList<Coupon> couponList;

    public DataAll(){
        couponList = new ArrayList<>();
    }



    public Coupon getCouponByCode(String code) {
        for (Coupon l: couponList) { //TODO this solution is relatively slow! If possible don't use it!
            // if (l.getId() == ID) return l; //NAPAKA primerja reference
            if (l.getBarcode().equals(code)) return l;
        }
        return null;
    }
    public void removeCouponByCode(String code){
        Coupon toRemove = new Coupon();
        for (Coupon l: couponList) { //TODO this solution is relatively slow! If possible don't use it!
            // if (l.getId() == ID) return l; //NAPAKA primerja reference
            if (l.getBarcode().equals(code)) toRemove = l;
        }
        couponList.remove(toRemove);
    }

    public void addcoupon(Coupon c){
        couponList.add(c);
    }
    public void dumpcoupons(){
        couponList.clear();
    }
    public Coupon getcoupon(int i){
        return  couponList.get(i);
    }

    public void setcouponList(ArrayList<Coupon> couponList) {
        this.couponList = couponList;
    }

    public ArrayList<Coupon> getcouponList() {
        return couponList;
    }
}
