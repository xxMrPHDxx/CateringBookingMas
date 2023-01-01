package com.example.cateringbooking;

public class MenuBirthdayClass {

    public String id, packageMenu, quantity, menu1, menu2, menu3, menu4;

    public MenuBirthdayClass() {
    }

    public MenuBirthdayClass(String id, String packageMenu, String quantity, String menu1, String menu2, String menu3, String menu4) {
        this.id = id;
        this.packageMenu = packageMenu;
        this.quantity = quantity;
        this.menu1 = menu1;
        this.menu2 = menu2;
        this.menu3 = menu3;
        this.menu4 = menu4;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPackageMenu() {
        return packageMenu;
    }

    public void setPackageMenu(String packageMenu) {
        this.packageMenu = packageMenu;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMenu1() {
        return menu1;
    }

    public void setMenu1(String menu1) {
        this.menu1 = menu1;
    }

    public String getMenu2() {
        return menu2;
    }

    public void setMenu2(String menu2) {
        this.menu2 = menu2;
    }

    public String getMenu3() {
        return menu3;
    }

    public void setMenu3(String menu3) {
        this.menu3 = menu3;
    }

    public String getMenu4() {
        return menu4;
    }

    public void setMenu4(String menu4) {
        this.menu4 = menu4;
    }
}
