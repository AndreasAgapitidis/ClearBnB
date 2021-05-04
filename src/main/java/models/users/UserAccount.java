package models.users;

import nosqlite.annotations.Document;
import nosqlite.annotations.Id;

@Document
public class UserAccount {

    @Id
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String profilePicture;

    public UserAccount(){} //Default constructor, think this is needed with the use of Java Express. //Mac

    //<editor-fold desc="----------- GETTER & SETTERS -----------">
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    //</editor-fold>

    @Override
    public String toString() {
        return "UserAccount{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }
}
