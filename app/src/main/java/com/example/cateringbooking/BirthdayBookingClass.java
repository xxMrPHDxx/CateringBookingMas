package com.example.cateringbooking;

public class BirthdayBookingClass {

    String idBirthday, date, typeShop, typeMenu;

    public BirthdayBookingClass() {
    }

    public BirthdayBookingClass(String idBirthday, String date, String typeShop, String typeMenu) {
        this.idBirthday = idBirthday;
        this.date = date;
        this.typeShop = typeShop;
        this.typeMenu = typeMenu;
    }

    public String getIdBirthday() {
        return idBirthday;
    }

    public void setIdBirthday(String idBirthday) {
        this.idBirthday = idBirthday;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
    }

    public String getTypeShop() {
        return typeShop;
    }

    public void setTypeShop(String typeShop) {
        this.typeShop = typeShop;
    }
}
