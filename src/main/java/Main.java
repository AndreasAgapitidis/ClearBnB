import express.Express;
import models.city.City;
import models.listing.Listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static nosqlite.Database.collection;
import models.listing.Listing;
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

      app.get("/rest/listings",(req,res) -> {
          res.json(collection("Listing").find());
      });

      app.get("/rest/listings/:id",(req,res) -> {
          res.json(collection("Listing").findById(req.params("id")));
          System.out.println(req.params("id"));
      });

      // create listing from frontend, but this can wait
      app.post("/rest/listings",(req,res) -> {
          Listing listing = req.body(Listing.class);
          // getting an id
          collection("Listing").save(listing);
          // update
          res.json(listing);
      });

    // start server
    app.listen(4000);
  }


  //Temporarily function, used for adding dummy data
  public static void addNewCity(String name, String urlImage){

    City city = new City();
    city.setName(name);
    city.addImage(urlImage);

    collection(City.class).save(city);

  }


  //Temporarily function, used for adding dummy data
  public static void addNewListing(){
    Listing newListing = new Listing();

    newListing.setOwner("G3clEb8mGWB0GzrKY5n0Q");
    newListing.setApartment(true);
    newListing.setHouse(false);
    newListing.setCity("Malmö");
    newListing.setAddress("Btc valley 18");
    newListing.setDescription("An otaku apartment");
    newListing.setArea(10);
    newListing.setBeds(3);
    newListing.setPrice(650);
    newListing.setRating(9.5);

    newListing.addBookedDate("id", "date");
    newListing.addImage("https://i.pinimg.com/originals/96/f9/12/96f91221f7719729c142d1d15f63ac59.jpg");
    newListing.addImage("http://pm1.narvii.com/5879/e761ec65257a70b84ff1d988c517fae086ad3691_00.jpg");
    newListing.addImage("https://p1-tt.byteimg.com/large/pgc-image/1af894d774f2409d89710241a2d3d92f");
    collection(Listing.class).save(newListing);


  }

}
