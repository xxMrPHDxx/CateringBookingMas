package com.example.cateringbooking;

public class OthersEventBookingClass {

    String idOthersEvent, date, typeShop, typeMenu;

    public OthersEventBookingClass() {
    }

    public OthersEventBookingClass(String idOthersEvent, String date, String typeShop, String typeMenu) {
        this.idOthersEvent = idOthersEvent;
        this.date = date;
        this.typeShop = typeShop;
        this.typeMenu = typeMenu;
    }

    public String getIdOthersEvent() {
        return idOthersEvent;
    }

    public void setIdOthersEvent(String idOthersEvent) {
        this.idOthersEvent = idOthersEvent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTypeShop() {
        return typeShop;
    }

    public void setTypeShop(String typeShop) {
        this.typeShop = typeShop;
    }

    public String getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
    }
}
