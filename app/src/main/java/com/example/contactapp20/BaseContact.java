package com.example.contactapp20;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Random;

@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME, 
		  include = JsonTypeInfo.As.PROPERTY, 
		  property = "type")
		@JsonSubTypes({ 
		  @Type(value = BaseContact.class, name = "BaseContact"), 
		  @Type(value = PersonContact.class, name = "PersonContact"),
		  @Type(value = BusinessContact.class, name = "BusinessContact")
		  
		})

/**
 *
 * @author hermesmimini
 */
public class BaseContact {
    protected int random;
    Random rnd = new Random(30);
    protected String firstName;
    protected String lastName;
    protected String streetName;
    protected String city;
    protected String state;
    protected String postalCode;
    protected String country;
    protected String phoneNumber;
    protected String photoName;
    protected String email;

    public BaseContact(String firstName, String lastName, String streetName, String city, String state,
            String postalCode, String country, String phoneNumber, String photoName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.photoName = photoName;
        this.email = email;
    }

    public BaseContact() {
        
        this.firstName = "No First Name Input";
        this.lastName = "No Last Name Input";
        this.streetName = "No Street Input";
        this.city = "No city input";
        this.state = "No State Input";
        this.postalCode = "N/A";
        this.country = "USA";
        this.phoneNumber = "N/A";
        this.photoName = "N/A";
        this.email = "N/A";
    }



    public int randomPicNumber(){
        random = rnd.nextInt();
        return random;
    }

    public String getFirstName() {
        return firstName;
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

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
