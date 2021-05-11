import express.Express;
import models.reservation.Reservation;

import static nosqlite.Database.collection;

public class Booking {

    private Express app;

    public Booking(Express app) {
        this.app = app;
        createReservation();
    }

    public void createReservation() {

        app.post("/rest/reservations",(req,res) -> {
            Reservation reservation = req.body(Reservation.class);

            // will generate an id
            collection("Reservation").save(reservation);

            // since it got an id from collection.save above, we update this recipe with id
            res.json(reservation);
        });
    }
}
