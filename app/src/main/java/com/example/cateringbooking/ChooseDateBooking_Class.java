package com.example.cateringbooking;

public class ChooseDateBooking_Class {

    public String idChooseDateBookingg, date, shop;

    public ChooseDateBooking_Class(){};

    public ChooseDateBooking_Class(String textidChooseDateBookingg, String textDate, String textShop) {

        idChooseDateBookingg = idChooseDateBookingg;
        this.date = textDate;
        this.shop = textShop;
    }

    public String getIdChooseDateBookingg() {
        return idChooseDateBookingg;
    }

    public void setIdChooseDateBookingg(String idChooseDateBookingg) {
        this.idChooseDateBookingg = idChooseDateBookingg;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }
}
