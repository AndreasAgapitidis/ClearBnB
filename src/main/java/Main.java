import express.Express;
import models.city.City;
import models.listing.Listing;
import models.users.UserAccount;
import utilities.HashPassword;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static nosqlite.Database.collection;
import models.listing.Listing;
import static nosqlite.utilities.Filter.*;

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

    // init Auth
    new Auth(app);
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
    newListing.setCity("Kyoto");
    newListing.setAddress(" Aisukuriimu daisuki 10");
    newListing.setDescription("A traditional japanese ryokan");
    newListing.setArea(30);
    newListing.setBeds(2);
    newListing.setPrice(850);
    newListing.setRating(9.5);

    newListing.addBookedDate("id", "date");
    newListing.addImage("https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Tamatsukuri_onsen_yado02s3648.jpg/330px-Tamatsukuri_onsen_yado02s3648.jpg");
    newListing.addImage("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Breakfast_at_Tamahan_Ryokan%2C_Kyoto.jpg/330px-Breakfast_at_Tamahan_Ryokan%2C_Kyoto.jpg");
    newListing.addImage("https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Tamatsukuri_onsen_yado02s3648.jpg/1920px-Tamatsukuri_onsen_yado02s3648.jpg");
    newListing.addImage("https://www.nicolelabarge.com/wp-content/uploads/2020/01/DOZEN-RYOKAN-1024x683.jpg");
    newListing.addImage("https://sugoii-japan.com/wp-content/uploads/2020/02/Japanese-Traditional-Inn-3-Kinnotake-Tonosawa-Adult-Only-1-1280x720.jpg");
    newListing.addImage("https://travelcollecting.com/wp-content/uploads/2019/03/Ryokan-hostess-in-kimono.jpg");

    collection(Listing.class).save(newListing);


  }

}
