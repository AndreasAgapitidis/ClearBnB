package models.city;

import express.Express;

import static nosqlite.Database.collection;

public class CityFunctions {

    Express app;

    public CityFunctions(Express app) {
        this.app = app;
        initFunctions();
    }

    public void initFunctions(){
     app.get("/SearchByCity",(req,res) -> {
            System.out.println("this is listings page");
            res.send("<h1>HEJ</h1>");
        });
    }

}
