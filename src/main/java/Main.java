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

    collection("City").save(city);

  }

}
