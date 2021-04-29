import express.Express;

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
    
    collection();
    
    app.get("/rest/hello", (req, res) -> {
      res.json(Map.of("message", "Hello from express"));
    });
    
    // start server
    app.listen(4000);
  }
}
