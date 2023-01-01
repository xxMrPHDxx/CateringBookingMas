package com.example.cateringbooking;

public class ShopBirthday1ExtraOptionClass {

    String idBirthdayExtraOption, name, price;

    public ShopBirthday1ExtraOptionClass() {
    }

    public ShopBirthday1ExtraOptionClass(String idBirthdayExtraOption, String name, String price) {
        this.idBirthdayExtraOption = idBirthdayExtraOption;
        this.name = name;
        this.price = price;
    }

    public String getIdBirthdayExtraOption() {
        return idBirthdayExtraOption;
    }

    public void setIdBirthdayExtraOption(String idBirthdayExtraOption) {
        this.idBirthdayExtraOption = idBirthdayExtraOption;
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
