import express.Express;
import models.city.City;
import models.listing.Listing;

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

    // start server
    app.listen(4000);
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
