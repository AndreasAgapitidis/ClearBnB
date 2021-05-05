package models.listing;

import express.Express;

import static nosqlite.Database.collection;

public class ListingFunctions {

    Express app;

    public ListingFunctions(Express app) {
        this.app = app;

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
