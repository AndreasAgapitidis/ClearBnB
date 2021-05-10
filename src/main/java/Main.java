import express.Express;
import models.city.City;
import models.listing.Listing;
import models.users.UserAccount;
import models.users.UserFunctions;
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
    new UserFunctions(app);

    /*Listing temp = new Listing();
    ArrayList<Long> list = new ArrayList<>();
    list.add((long) 1619820000);
    list.add((long) 1619906400);
    temp.setUnavailableDates(list);
    temp.setCity("Malmö");
    collection("Listing").save(temp);

    temp = new Listing();
    ArrayList<Long> list2 = new ArrayList<>();
    temp.setUnavailableDates(list2);
    temp.setCity("Madrid");
    collection("Listing").save(temp);*/

    // start server
    app.listen(4000);
  }




}
