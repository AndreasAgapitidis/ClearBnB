import express.Express;
import static nosqlite.Database.collection;

import models.users.UserFunctions;
import models.city.CityFunctions;
import models.users.AdminFunctions;
import models.reservation.ReservationFunctions;
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

    // initialize classes with CRUD functions
    new CityFunctions(app);
    new ListingFunctions(app);
    new UserFunctions(app);
    new Booking(app);
    new AdminFunctions(app);
    new ReservationFunctions(app);

    // start server
    app.listen(4000);
  }

}
