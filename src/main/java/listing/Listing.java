package listing;

import nosqlite.annotations.Document;
import nosqlite.annotations.Id;

import java.util.ArrayList;
import java.util.HashMap;

@Document
public class Listing {

    @Id
    private String id;
    private String owner;
    private boolean isApartment = false;
    private boolean isHouse = false;
    private String city;
    private String address;
    private String description;
    private int area;
    private int beds;
    private int price;
    private double rating;
    private HashMap<String, String> unavailableDates = new HashMap<>();
    private ArrayList <String> images = new ArrayList<>();

    public Listing() {}
}
