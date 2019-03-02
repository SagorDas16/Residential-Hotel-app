package com.example.hotelmanagement;

public class Blog<string> {

    private string name;
    private string location;
    private string price;
    private string image;
    private int rating;

    public Blog() {

    }

    public Blog(string name, string location, string price, string image, int rating) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.image = image;
        this.rating = rating;
    }



    public string getName() {
        return name;
    }

    public void setName(string name) {
        this.name = name;
    }

    public string getLocation() {
        return location;
    }

    public void setLocation(string location) {
        this.location = location;
    }

    public string getPrice() {
        return price;
    }

    public void setPrice(string price) {
        this.price = price;
    }

    public string getImage() {
        return image;
    }

    public void setImage(string image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



}
