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

    app.delete("/rest/reservation/:id", (req, res) -> {
      String id = req.params("id");
      res.json(collection("Reservation").deleteById(id));
    });

    // start server
    app.listen(4000);
  }

}
