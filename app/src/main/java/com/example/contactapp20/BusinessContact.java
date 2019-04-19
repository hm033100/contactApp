package com.example.contactapp20;

import java.util.Random;

/**
 *
 * @author hermesmimini
 */
public class BusinessContact extends BaseContact {

    protected String businessHours;
    protected String website;
    protected String Company;
    protected int random;
    Random rnd = new Random(30);

    public BusinessContact(String businessHours, String website, String Company,
                           boolean b, String firstName, String lastName, String streetName, String city, String state, String postalCode,
                           String country, String phoneNumber, String photoName, String email) {
        super(firstName, lastName, streetName, city, state, postalCode, country, phoneNumber, photoName, email);
        this.businessHours = businessHours;
        this.website = website;
        this.Company = Company;
    }
    
    

    public String getBusinessHours() {
		return businessHours;
	}



	public String getWebsite() {
		return website;
	}



	public String getCompany() {
		return Company;
	}



	public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public BusinessContact() {
        super("Business", "Contact", "Another Street", "Middletown", "AZ", "82312",
                "US", "923-324-4912", "BusinessStoreFront.jpg", "business@gmail.com");
        this.businessHours = "MTWThF 8 am - 7 pm";
        this.website = "www.business.com";
        this.Company = "Company Name";
    }

    public int randomPicNumber(){
        random = rnd.nextInt();
        return random;
    }

    public void openURL() {
        System.out.println(this.website);
    }

    /*@Override
    public int compareTo(BaseContact other) {
        int compare = this.firstName.compareTo(other.firstName);

        if (compare == 0) {
            return this.lastName.compareTo(other.lastName);
        } else {
            return compare;
        }
    }*/
    
    @Override
    public String toString() {
        String stringReturn = "----------Business Contact--------------\n"
                + "Business Name " + this.Company + "\n"
                + "Name = " + super.firstName + " " + super.lastName + " \n"
                + "Street = " + super.streetName + "\n"
                + "City = " + super.city + ", State = " + super.state + "\n"
                + "Zip Code = " + super.postalCode + ", Country = " + super.country + "\n"
                + "Phone #: = " + super.phoneNumber + ", Email = " + super.email + "\n"
                + "Business Hours = " + this.businessHours + "\n"
                + "Website = " + this.website;

        return stringReturn;
    }

}
