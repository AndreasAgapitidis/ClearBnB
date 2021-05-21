package models.users;

import express.Express;

import static nosqlite.Database.collection;
import static nosqlite.utilities.Filter.*;

import models.reservation.Reservation;
import java.util.List;

public class AdminFunctions {
    Express app;

    public AdminFunctions(Express app) {
        this.app = app;
        initFunctions();
    }

    private void initFunctions() {
        app.get("/api/totalCurrentListings/", (req, res) -> {
            res.json(collection("Listing").count());
        });

        app.get("/api/reservationsAlltime/", (req, res) -> {
            res.json(collection("Reservation").count());
        });

        app.get("/api/reservationsThisYear/:year", (req, res) -> {
            String regex = "^" + req.params("year") + ".*";
            res.json(collection("Reservation").find(
                    regex("startDate", regex)).size());
        });

        app.get("/api/reservationsThisMonth/:year/:month", (req, res) -> {
            String regex = "^" + req.params("year") + "-" + req.params("month") + ".*";
            res.json(collection("Reservation").find(
                    regex("startDate", regex)).size());
        });

        app.get("/api/cashflowAlltime/", (req, res) -> {
            List<Reservation> list = collection("Reservation").find();
            int count = 0;
            for (Reservation r : list) {
                count += r.getPrice();
            }
            res.json(count);
        });

        app.get("/api/cashflowThisYear/:year", (req, res) -> {
            String regex = "^" + req.params("year") + ".*";
            List<Reservation> list = collection("Reservation").find(
                    regex("startDate", regex));
            int count = 0;
            for (Reservation r : list) {
                count += r.getPrice();
            }
            res.json(count);
        });

        app.get("/api/cashflowThisMonth/:year/:month", (req, res) -> {
            String regex = "^" + req.params("year") + "-" + req.params("month") + ".*";
            List<Reservation> list = collection("Reservation").find(
                    regex("startDate", regex));
            int count = 0;
            for (Reservation r : list) {
                count += r.getPrice();
            }
            res.json(count);
        });
    }
}
