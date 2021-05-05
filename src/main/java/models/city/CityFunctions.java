package models.city;

import express.Express;
import models.listing.Listing;

import static nosqlite.Database.collection;

public class CityFunctions {

    Express app;

    public CityFunctions(Express app) {
        this.app = app;
        initFunctions();
    }

    public void initFunctions(){
     app.get("/SearchByCity",(req,res) -> {
         System.out.println("this is listings page");
         System.out.println(collection("Listing").find());
         res.json(collection("Listing").find());
        });
    }

    //Temporarily function, used for adding dummy data
    public static void addNewCity(String name, String urlImage){

        City city = new City();
        city.setName(name);
        city.addImage(urlImage);

        collection("City").save(city);

    }

    //Temporarily function, used for adding dummy data
    public static void addNewListing(){
        Listing newListing = new Listing();

        newListing.setOwner("G3clEb8mGWB0GzrKY5n0Q");
        newListing.setApartment(true);
        newListing.setHouse(false);
        newListing.setCity("Malmö");
        newListing.setAddress("Bragegatan 31, 241 46");
        newListing.setDescription("A lovely apartment");
        newListing.setArea(10);
        newListing.setBeds(3);
        newListing.setPrice(650);
        newListing.setRating(9.5);

        newListing.addBookedDate("id", "date");
        newListing.addImage("");

        collection(Listing.class).save(newListing);

    }

}
