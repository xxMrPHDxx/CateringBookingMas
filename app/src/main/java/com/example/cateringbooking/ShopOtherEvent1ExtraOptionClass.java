package com.example.cateringbooking;

public class ShopOtherEvent1ExtraOptionClass {

    String idEventExtraOption, name, price;

    public ShopOtherEvent1ExtraOptionClass() {
    }

    public ShopOtherEvent1ExtraOptionClass(String idEventExtraOption, String name, String price) {
        this.idEventExtraOption = idEventExtraOption;
        this.name = name;
        this.price = price;
    }

    public String getIdEventExtraOption() {
        return idEventExtraOption;
    }

    public void setIdEventExtraOption(String idEventExtraOption) {
        this.idEventExtraOption = idEventExtraOption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
