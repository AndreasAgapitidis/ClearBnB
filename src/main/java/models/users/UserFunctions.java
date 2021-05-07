package models.users;

import express.Express;

import static nosqlite.Database.collection;

public class UserFunctions {

    Express app;

    public UserFunctions(Express app) {
        this.app = app;
        initFunctions();
    }

    public void initFunctions(){
        app.get("/rest/getAllUsers", (request, response) -> {
            System.out.println("Hej");
            response.json(collection("UserAccount").find());
        });
        app.get("/rest/findUser/:id", (request, response) -> {
            System.out.println("id");
            response.json(collection("UserAccount").find());
        });
    }

}
