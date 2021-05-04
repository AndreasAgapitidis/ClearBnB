package models.city;

import nosqlite.annotations.Document;
import nosqlite.annotations.Id;

import java.util.ArrayList;

@Document
public class City {

    @Id
    private String id;
    private String name;
    private ArrayList<String> images = new ArrayList<>();

    public City() {    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
