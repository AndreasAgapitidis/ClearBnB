package models.listing;

import express.Express;
import static nosqlite.Database.collection;
import static nosqlite.utilities.Filter.*;

public class ListingFunctions {

    Express app;

    public ListingFunctions(Express app) {
        this.app = app;
        initFunctions();
    }

    public void initFunctions(){

        app.get("/rest/listings",(req,res) -> {
            res.json(collection("Listing").find());
        });

        app.get("/rest/listings/:id",(req,res) -> {
            res.json(collection("Listing").findById(req.params("id")));
        });

        // create listing from frontend, but this can wait
        app.post("/rest/listings",(req,res) -> {
            Listing listing = req.body(Listing.class);
            // getting an id
            collection("Listing").save(listing);
            // update
            res.json(listing);

        });

        app.get("/rest/listings/city/:id",(req,res) -> {
            res.json(collection("Listing").find(eq("city", req.params("id"))));
        });

        app.put("/rest/listings",(req,res) ->{
            Listing listing = req.body(Listing.class);
            collection("Listing").save(listing);
        });
    }
}
