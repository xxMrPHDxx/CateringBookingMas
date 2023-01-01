package com.example.cateringbooking;


public class Pelamin_class {

    public String id, name, price;
    public int image;

    public Pelamin_class() {
    }

    public Pelamin_class(String id, int image, String name, String price ) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String key) {
        this.id = key;
    }

    public int getImage() { return this.image; }

    public void setImage(int image) { this.image = image; }

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
