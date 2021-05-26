package models.reservation;

import models.listing.Listing;

import express.Express;
import static nosqlite.Database.collection;
import static nosqlite.utilities.Filter.eq;
import java.text.*;
import java.util.Date;

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

            // remove dates from unavailableDates array in the listing
            Reservation reservation = collection("Reservation").findById(id);
            Listing listing = collection("Listing").findById(reservation.getListingId());

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String startDateString = reservation.getStartDate().substring(0, 10);
            String endDateString = reservation.getEndDate().substring(0, 10);
            Date startDate;
            Date endDate;

            try {
                startDate = dateFormat.parse(startDateString);
                endDate = dateFormat.parse(endDateString);
            } catch(Exception e) {
                System.out.println("bad date");
                return;
            }

            long startUnix = startDate.getTime() / 1000;
            long endUnix = endDate.getTime() / 1000;

            for (int i = 0; i < listing.getUnavailableDates().size(); i++) {
                if (listing.getUnavailableDates().get(i) >= startUnix && listing.getUnavailableDates().get(i) <= endUnix) {
                    listing.getUnavailableDates().remove(i);
                    i--;
                }
            }

            collection("Listing").save(listing);

            // delete the reservation
            res.json(collection("Reservation").deleteById(id));
        });
    }
}
