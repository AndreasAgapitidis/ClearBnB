import express.Express;
import models.city.City;
import models.listing.Listing;
import models.users.UserAccount;
import utilities.HashPassword;
import models.city.CityFunctions;
import models.listing.Listing;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static nosqlite.Database.collection;
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

    // init Auth
    new Auth(app);
    

    new CityFunctions(app);
    new ListingFunctions(app);

    //ListingFunctions.addNewListing();

    // start server
    app.listen(4000);
  }




}
