package models.reservation;

import express.Express;
import static nosqlite.Database.collection;
import static nosqlite.utilities.Filter.eq;

public class ReservationFunctions {
    Express app;

    public ReservationFunctions(Express app) {
        this.app = app;
        initFunctions();
    }

    public void initFunctions(){
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
    }
}
