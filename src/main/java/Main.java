import express.Express;
import models.city.City;
import models.city.CityFunctions;
import models.listing.Listing;

import java.util.Map;

import static nosqlite.Database.collection;
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


    new CityFunctions(app);
    new ListingFunctions(app);

    // start server
    app.listen(4000);
  }




}
