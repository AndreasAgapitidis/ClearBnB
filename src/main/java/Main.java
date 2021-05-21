import express.Express;
import models.listing.Listing;
import models.reservation.Reservation;
import models.users.UserFunctions;
import models.city.CityFunctions;
import models.users.AdminFunctions;

import java.nio.file.Paths;
import java.util.*;

import static nosqlite.Database.collection;
import static nosqlite.utilities.Filter.*;

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
    new AdminFunctions(app);

    app.post("/rest/test",(req,res) -> {
      System.out.println(req.body());
    });

    app.get("/rest/userlistings/:id", (req, res) -> {
      String id = req.params("id");
      res.json(collection("Reservation").find(eq("userId", id)));
    });

    app.get("/rest/reservation/:id", (req, res) -> {
      String id = req.params("id");
      res.json(collection("Listing").findById(id));
    });


    //ListingFunctions.addNewListing();

    // start server
    app.listen(4000);
  }

  //Temporarily function, used for adding dummy data
  public static void addNewListing(){
    Listing newListing = new Listing();

    newListing.setOwner("G3clEb8mGWB0GzrKY5n0Q");
    newListing.setIsApartment("true");
    newListing.setIsHouse("false");
    newListing.setCity("Madrid");
    newListing.setAddress(" aaaaaaaaa");
    newListing.setDescription("A traditional japanese ryokan");
    newListing.setArea(30);
    newListing.setBeds(2);
    newListing.setPrice(850);
    newListing.setRating(9);
    ArrayList<String> amenity = new ArrayList<>();
    amenity.add("Wi-Fi");
    amenity.add("Pool");
    amenity.add("Balcony");
    amenity.add("Family");
    amenity.add("Handicap-accessible");

    newListing.setAmenities(amenity);

    Date date = new Date();

    newListing.addImage("https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Tamatsukuri_onsen_yado02s3648.jpg/330px-Tamatsukuri_onsen_yado02s3648.jpg");
    newListing.addImage("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/Breakfast_at_Tamahan_Ryokan%2C_Kyoto.jpg/330px-Breakfast_at_Tamahan_Ryokan%2C_Kyoto.jpg");
    newListing.addImage("https://upload.wikimedia.org/wikipedia/commons/thumb/2/27/Tamatsukuri_onsen_yado02s3648.jpg/1920px-Tamatsukuri_onsen_yado02s3648.jpg");
    newListing.addImage("https://www.nicolelabarge.com/wp-content/uploads/2020/01/DOZEN-RYOKAN-1024x683.jpg");
    newListing.addImage("https://sugoii-japan.com/wp-content/uploads/2020/02/Japanese-Traditional-Inn-3-Kinnotake-Tonosawa-Adult-Only-1-1280x720.jpg");
    newListing.addImage("https://travelcollecting.com/wp-content/uploads/2019/03/Ryokan-hostess-in-kimono.jpg");

    collection(Listing.class).save(newListing);


  }

}
