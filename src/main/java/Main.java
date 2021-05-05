import express.Express;
import models.city.City;
import models.city.CityFunctions;
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

      new CityFunctions(app);

    // start server
    app.listen(4000);
  }




}
