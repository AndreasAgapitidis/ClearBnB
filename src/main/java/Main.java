import express.Express;
import models.city.City;
import models.listing.Listing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static nosqlite.Database.collection;

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
    addNewListing();
    
    /*app.get("/rest/hello", (req, res) -> {
      res.json(Map.of("message", "Hello from express"));
    });*/
    
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
