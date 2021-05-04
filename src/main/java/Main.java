import express.Express;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static nosqlite.Database.collection;
import static nosqlite.utilities.Filter.*;

/*
    C - Create  POST
    R - Read    GET
    U - Update  PUT
    D - Delete  DELETE
 */

public class Main {
  public static void main(String[] args) {
    Express app = new Express();
    
    collection();

    // init Auth
    new Auth(app);
    
    // start server
    app.listen(4000);
  }
}
