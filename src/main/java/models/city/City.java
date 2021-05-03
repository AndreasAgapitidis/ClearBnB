package models.city;

import nosqlite.annotations.Document;

@Document
public class City {

    private String id;
    private String name;

    public City() {    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
