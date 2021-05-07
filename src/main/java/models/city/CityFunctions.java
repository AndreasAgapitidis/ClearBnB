package models.city;

import express.Express;
import models.listing.Listing;

import java.util.ArrayList;
import java.util.List;

import static nosqlite.Database.collection;
import static nosqlite.utilities.Filter.eq;

public class CityFunctions {

    Express app;

    public CityFunctions(Express app) {
        this.app = app;
        initFunctions();
        getAllListingsFromACity();
        //addNewCity("Madrid", "https://malmo.se/images/18.4f363e7d1766a784af11e2b2/1614241290216/Flygfoto%20Malm%C3%B6%20stad_2015_webben_Fotograf%20Bojana%20Lukac.jpg");
    }

    public void initFunctions(){
     app.get("/rest/SearchByCity",(req,res) -> {
         res.json(collection("City").find());
         System.out.println("searched");
        });
     app.get("/rest/listingsFromChosenCity/:id", (request, response) -> {
         List<Listing> filteredListings = collection("Listing").find(eq("city",request.params("id")));
         response.json(filteredListings);
         System.out.println("getAll");
     });
    }

    public void getAllListingsFromACity(){

    }

    //Temporarily function, used for adding dummy data
    public static void addNewCity(String name, String urlImage){

        City city = new City();
        city.setName(name);
        city.addImage(urlImage);

        collection("City").save(city);

    }

}
