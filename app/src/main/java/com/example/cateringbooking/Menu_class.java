package com.example.cateringbooking;

public class Menu_class {

    public String id, packageMenu, quantity, menu1, menu2, menu3, menu4, menu5,menu6, menu7, menu8;

    public Menu_class() {
    };

    public Menu_class(String id, String packageMenu, String quantity, String menu1, String menu2, String menu3, String menu4, String menu5, String menu6, String menu7, String menu8) {
        this.id = id;
        this.packageMenu = packageMenu;
        this.quantity = quantity;
        this.menu1 = menu1;
        this.menu2 = menu2;
        this.menu3 = menu3;
        this.menu4 = menu4;
        this.menu5 = menu5;
        this.menu6 = menu6;
        this.menu7 = menu7;
        this.menu8 = menu8;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPackageMenu() {
        return packageMenu;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getMenu1() {
        return menu1;
    }

    public String getMenu2() {
        return menu2;
    }

    public String getMenu3() {
        return menu3;
    }

    public String getMenu4() {
        return menu4;
    }

    public String getMenu5() {
        return menu5;
    }

    public String getMenu6() {
        return menu6;
    }

    public String getMenu7() {
        return menu7;
    }

    public String getMenu8() {
        return menu8;
    }
}
