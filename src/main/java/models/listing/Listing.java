package models.listing;

import nosqlite.annotations.Document;
import nosqlite.annotations.Id;

import java.util.ArrayList;
import java.util.HashMap;

@Document
public class Listing {

    @Id
    private String id;
    private String owner;
    private String isApartment;
    private String isHouse;
    private String city;
    private String address;
    private String description;
    private String area;
    private String beds;
    private String price;
    private String rating;
    private ArrayList<Long> unavailableDates = new ArrayList<>();
    private ArrayList <String> images = new ArrayList<>();

    //Default constructor, think this is needed with the use of Java Express. //Mac
    public Listing() {
    }

    //<editor-fold desc="----------- GETTER & SETTERS ----------">


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsApartment() {
        return isApartment;
    }

    public void setIsApartment(String isApartment) {
        this.isApartment = isApartment;
    }

    public String getIsHouse() {
        return isHouse;
    }

    public void setIsHouse(String isHouse) {
        this.isHouse = isHouse;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public ArrayList<Long> getUnavailableDates() {
        return unavailableDates;
    }

    public void setUnavailableDates(ArrayList<Long> unavailableDates) {
        this.unavailableDates = unavailableDates;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public void addImage(String imageURL){
        this.images.add(imageURL);
    }

    //</editor-fold>

    @Override
    public String toString() {
        return "Listing{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", isApartment=" + isApartment +
                ", isHouse=" + isHouse +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", area=" + area +
                ", beds=" + beds +
                ", price=" + price +
                ", rating=" + rating +
                ", unavailableDates=" + unavailableDates +
                ", images=" + images +
                '}';
    }
}
