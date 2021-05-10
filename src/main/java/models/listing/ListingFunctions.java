package models.listing;

import express.Express;
import java.util.ArrayList;
import models.city.City;

import static nosqlite.Database.collection;
import static nosqlite.utilities.Filter.*;

public class ListingFunctions {

    Express app;

    public ListingFunctions(Express app) {
        this.app = app;
        initFunctions();
        //addNewListing();
    }

    public void initFunctions(){
        app.get("/rest/listings",(req,res) -> {
            res.json(collection("Listing").find());
        });

        app.get("/rest/listings/:id",(req,res) -> {
            res.json(collection("Listing").findById(req.params("id")));
            System.out.println(":id");
        });

        // create listing from frontend, but this can wait
        app.post("/rest/listings",(req,res) -> {
            System.out.println("POST: ");
            Listing listing = req.body(Listing.class);
            // getting an id
            collection("Listing").save(listing);
            // update
            res.json(listing);
            System.out.println(listing);
        });

        app.get("/rest/listings/city/:id",(req,res) -> {
            City city = collection("City").findById(req.params("id"));
            res.json(collection("Listing").find(eq("city", city.getName())));
        });
    }

    //Temporarily function, used for adding dummy data
    public static void addNewListing(){
        Listing newListing = new Listing();

        newListing.setOwner("G3clEb8mGWB0GzrKY5n0Q");
        newListing.setIsApartment("Apartment");
        newListing.setIsHouse("House");
        newListing.setCity("Madrid");
        newListing.setAddress("Central 31, 241 46");
        newListing.setDescription("A lovely apartment");
        newListing.setArea(10);
        newListing.setBeds(2);
        newListing.setPrice(3424);
        newListing.setRating(10);

        ArrayList<Long> list = new ArrayList<>();
        list.add((long) 1619906400);
        list.add((long) 1619992800);
        list.add((long) 1620079200);
        newListing.setUnavailableDates(list);
        newListing.addImage("https://www.folkuniversitetet.se/contentassets/2b5398e3897f41eb9906a1fbb6063fc7/spanska-madrid.jpg?preset=article600");

        collection(Listing.class).save(newListing);

    }

}
