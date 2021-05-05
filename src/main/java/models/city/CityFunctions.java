package models.city;

import express.Express;
import models.listing.Listing;

import static nosqlite.Database.collection;

public class CityFunctions {

    Express app;

    public CityFunctions(Express app) {
        this.app = app;
        initFunctions();
    }

    public void initFunctions(){
     app.get("/rest/SearchByCity",(req,res) -> {
         res.json(collection("City").find());
        });
    }

    //Temporarily function, used for adding dummy data
    public static void addNewCity(String name, String urlImage){

        City city = new City();
        city.setName(name);
        city.addImage(urlImage);

        collection("City").save(city);

    }

}
