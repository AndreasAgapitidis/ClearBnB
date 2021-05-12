import express.Express;
import models.city.City;
import models.listing.Listing;
import models.users.UserAccount;
import models.users.UserFunctions;
import utilities.HashPassword;
import models.city.CityFunctions;
import models.listing.Listing;

import java.nio.file.Paths;
import java.util.*;

import static nosqlite.Database.collection;
import models.listing.Listing;
import static nosqlite.utilities.Filter.*;

import models.listing.Listing;
import models.listing.ListingFunctions;
/*
    C - Create  POST
    R - Read    GET
    U - Update  PUT
    D - Delete  DELETE
 */

public class Main {

  public static void main(String[] args) {
    Express app = new Express();
    collection(op -> op.useBrowser = true);

    collection();
//    addNewListing();
    
    /*app.get("/rest/hello", (req, res) -> {
      res.json(Map.of("message", "Hello from express"));
    });*/
//    Listing l = new Listing("test");
//    collection("Listing").save(l);

//    app.get("/rest/listing/:id",(req,res) -> {
////               get dynamic url variable with req.params
//              String id = req.params("id");
//              System.out.println(id); // :id  ??
//              Listing listing = collection("Listing").findById(id);
//            System.out.println(listing);
//              res.json(listing);
////        res.json(collection("Listing").findById("XYkYPbku0bidOmixpU0EE"));
//            });


    // init Auth
    new Auth(app);

    new CityFunctions(app);
    new ListingFunctions(app);
    new UserFunctions(app);
    new Booking(app);

    app.post("/rest/test",(req,res) -> {
      System.out.println(req.body());
    });

    //ListingFunctions.addNewListing();

    // start server
    app.listen(4000);
  }

  }

