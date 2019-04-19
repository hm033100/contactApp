package com.example.contactapp20;

import java.util.Random;

/**
 *
 * @author hermesmimini
 */
public class PersonContact extends BaseContact {
    
    protected String birthday;
    protected String nickName;
    protected String memo;
    protected int random;
    Random rnd = new Random(30);

    public PersonContact(String birthday, String nickName, String memo, String firstName, String lastName, String streetName,
            String city, String state, String postalCode, String country, String phoneNumber, String photoName, String email) {
        super(firstName, lastName, streetName, city, state, postalCode, country, phoneNumber, photoName, email);
        this.birthday = birthday;
        this.nickName = nickName;
        this.memo = memo;
    }

    public PersonContact(String birthdate, String nickname, String memo, boolean b, String fName, String lName, String streetAddress, String city, String state, String zipCode, String country, String phoneNumber, String name, String email) {
        super("Person", "Contact", "Another Street", "Middletown", "AZ", "82312",
                "US", "923-324-4912", "Person.jpg", "person@gmail.com");
        this.birthday = "mm/dd/yyyy";
        this.nickName = "champ";
        this.memo = "likes carrots";
    }
    
    public String getBirthday() {
        return birthday;
    }

    public String getNickName() {
        return nickName;
    }

    public String getMemo() {
        return memo;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int randomPicNumber(){
        random = rnd.nextInt();
        return random;
    }
    
    /*@Override
    public int compareTo(BaseContact other) {
        int compare = this.firstName.compareTo(other.firstName);

        if (compare == 0) {
            return this.lastName.compareTo(other.lastName);
        } else {
            return compare;
        }
    }
    */
    @Override
    public String toString() {
        String stringReturn = "----------Person Contact--------------\n"                         
                          + "Name = " + super.firstName + " " + super.lastName + " \n"
                          + "Nickname =  " + this.nickName + "\n"
                          + "Street = " + super.streetName + "\n"
                          + "City = " + super.city + ", State = " + super.state + "\n"
                          + "Zip Code = " + super.postalCode + ", Country = " + super.country + "\n"
                          + "Phone #: = " + super.phoneNumber + ", Email = " + super.email + "\n"
                          + "Birthday = " + this.birthday + "\n"
                          + "Memo = " + this.memo;
       
       return stringReturn;
    }
    
    
    
    
    
    
}
