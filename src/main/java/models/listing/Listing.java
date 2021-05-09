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
    private boolean isApartment;
    private boolean isHouse;
    private String city;
    private String address;
    private String description;
    private int area;
    private int beds;
    private int price;
    private double rating;
    private HashMap<String, String> unavailableDates = new HashMap<>();
    private ArrayList <String> images = new ArrayList<>();

    //Default constructor, think this is needed with the use of Java Express. //Mac
    public Listing() {
    }

    public void addBookedDate(String reservationID, String date){
        this.unavailableDates.put(reservationID, date);
    }

    //<editor-fold desc="----------- GETTER & SETTERS ----------">

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isApartment() {
        return isApartment;
    }

    public void setApartment(boolean apartment) {
        isApartment = apartment;
    }

    public boolean isHouse() {
        return isHouse;
    }

    public void setHouse(boolean house) {
        isHouse = house;
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public HashMap<String, String> getUnavailableDates() {
        return unavailableDates;
    }

    public void setUnavailableDates(HashMap<String, String> unavailableDates) {
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
