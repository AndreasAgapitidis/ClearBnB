package models.listing;

import express.Express;

import static nosqlite.Database.collection;

public class ListingFunctions {

    Express app;

    public ListingFunctions(Express app) {
        this.app = app;
        initFunctions();
    }

    public void initFunctions(){
        app.get("/rest/listings",(req,res) -> {
            res.json(collection("Listing").find());
            System.out.println("this is listings page");
        });

        app.get("/rest/listings/:id",(req,res) -> {
            res.json(collection("Listing").findById(req.params("id")));
            System.out.println(":id");
        });

        // create listing from frontend, but this can wait
        app.post("/rest/listings",(req,res) -> {
            Listing listing = req.body(Listing.class);
            // getting an id
            collection("Listing").save(listing);
            // update
            res.json(listing);
        });
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
