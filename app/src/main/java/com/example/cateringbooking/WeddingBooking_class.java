package com.example.cateringbooking;

public class WeddingBooking_class {

    String id, typeEvent, date, shop, typeMenu, typePelamin, typeCanopy ;

    public WeddingBooking_class() {
    }

    public WeddingBooking_class(String id, String typeEvent, String date, String shop,
                                String typeMenu, String typePelamin, String typeCanopy) {
        this.id = id;
        this.typeEvent = typeEvent;
        this.date = date;
        this.shop = shop;
        this.typeMenu = typeMenu;
        this.typePelamin = typePelamin;
        this.typeCanopy = typeCanopy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(String typeEvent) {
        this.typeEvent = typeEvent;
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

    public String getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
    }

    public String getTypePelamin() {
        return typePelamin;
    }

    public void setTypePelamin(String typePelamin) {
        this.typePelamin = typePelamin;
    }

    public String getTypeCanopy() {
        return typeCanopy;
    }

    public void setTypeCanopy(String typeCanopy) {
        this.typeCanopy = typeCanopy;
    }
}
