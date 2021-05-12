package models.users;

import express.Express;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static nosqlite.Database.collection;
import static nosqlite.utilities.Filter.*;

public class UserFunctions {

    Express app;

    public UserFunctions(Express app) {
        this.app = app;
        initFunctions();
    }

    public void initFunctions(){

        app.get("/rest/getAllUsers", (request, response) -> {
            response.json(collection("UserAccount").find());
        });

        app.get("/rest/findUser/:id", (request, response) -> {
            String name = request.params("id");
            char firstLetter = name.toUpperCase().charAt(0);
            String restOfLetters = name.toLowerCase().substring(1);

            name = firstLetter + restOfLetters;

            response.json(collection("UserAccount").find(text("firstName", "%" + name + "%")));
        });
    }

}
