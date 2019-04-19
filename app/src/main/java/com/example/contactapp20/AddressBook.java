package com.example.contactapp20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.Serializers;

/**
 *
 * @author hermesmimini
 */




public class AddressBook {

    public static final String red = "\u001B[31m";
    public static final String reset = "\u001B[0m";
    public List<BaseContact> theList;
    
    
    
    public List<BaseContact> getTheList() {
		return theList;
	}

	public void setTheList(List<BaseContact> theList) {
		this.theList = theList;
	}

	private Scanner scanIn = new Scanner(System.in);

    /**
     * Constructor for the AdressBook class. An array list is auto-generated
     */
    public AddressBook() {
        //String[] startingNames = {"Hermes"};
        this.theList = new ArrayList<>();
       // BaseContact b = new BaseContact();
        //for(int i = 0; i<startingNames.length; i++){
        //    theList.add(b);
      //  }

    }

    /**
     *
     * This method will add a contact to the array list.
     *
     * First it checks if the contact already exists.
     *
     * @param <T>
     * @param contact Contact that has to be added.
     */
    public <T extends BaseContact> void addOne(T contact) {
        this.theList.add(contact);
        System.out.println("Contact added! Name: " + contact.getFirstName()
                + " " + contact.getLastName());

    }
    
    /**
     * This method goes through the contacts before a contact is added to make sure
     * there are no phone number duplicates.
     * 
     * @param <T> Element
     * @param contact BaseContact
     * @return boolean
     */
    public <T extends BaseContact> boolean exactChecker(T contact) {
        boolean checker = true;
        for (int i = 0; i < theList.size(); i++){
            if (contact.getPhoneNumber().equals(theList.get(i).getPhoneNumber()) == true){
                checker = false;
                break;
            } else if (contact.getPhoneNumber().equals(theList.get(i).getPhoneNumber()) == false) {
                checker = true;
            }
        }
        return checker;
    }




    /**
     * Method that returns the size of the array list.
     *
     * @return Integer
     */
    
    @JsonIgnore
    public int getSize() {
        return theList.size();
    }

    /**
     * Returns the contact at position i.
     *
     * @param i Integer (Position)
     * @return Contact
     */
    public BaseContact getContact(int i) {
        return theList.get(i);
    }

    /**
     * Searches for a contact and displays it if found.
     *
     * @param name String
     */
    public void search(String name) {
        name = name.toLowerCase();
        if (searchList(name) == true) {
            for (int i = 0; i < theList.size(); i++) {
                if (theList.get(i).getFirstName().toLowerCase().contains(name)) {
                    System.out.println("-----Found Contact--------");
                    System.out.println(theList.get(i).toString());
                } else if (theList.get(i).getLastName().toLowerCase().contains(name)) {
                    System.out.println("-----Found Contact--------");
                    System.out.println(theList.get(i).toString());
                }
            }
        } else {
            System.out.println("No Contact Matched the search!");
        }

    }

    /**
     *
     * This method goes through all the contacts and displays them.
     *
     */
    public void displayContacts() {
        System.out.println("Printing Contacts...");
        int position = 0;
        for (int i = 0; i < theList.size(); i++) {
            position = theList.indexOf(theList.get(i)) + 1;
            System.out.println("---------------------------------------------------------");
            System.out.println("Contact Position: " + position);
            System.out.println(theList.get(i).toString());
        }
    }

    /**
     * This method goes through the array list and returns true if it finds a
     * match with the name it is sent as string.
     *
     * @param name String
     * @return Boolean
     */
    public boolean searchList(String name) {
        for (int i = 0; i < theList.size(); i++) {
            if (theList.get(i).getFirstName().toLowerCase().contains(name)) {
                return true;
            } else if (theList.get(i).getLastName().toLowerCase().contains(name)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method will remove a contact that will be determined
     * by the string you give it.
     * 
     * @param name String
     */
    public void removeContactExact(String name) {
        BaseContact yeet = returnExactContact(name);

        for (int i = 0; i < theList.size(); i++) {
            if (yeet.getPhoneNumber().equals(theList.get(i).phoneNumber)
                    && yeet.getFirstName().equals(theList.get(i).firstName)
                    && yeet.getLastName().equals(theList.get(i).lastName)) {
                System.out.println(theList.get(i).toString());
                theList.remove(i);
            }
        }
        System.out.println("Contact Removed");
    }

    public void removeContactAt(int position){
        theList.remove(theList.get(position));
    }

    /**
     * Uses editableContacts method to search for a contact and
     * returns that contact.
     * 
     * @param name String
     * @return BaseContact
     */
    public BaseContact returnExactContact(String name) {
        return theList.get(editableContacts(name));

    }
    
    /**
     * Uses the editableContacts method to search for a contact. 
     * 
     * @param name String 
     */
    public void searchExactContact(String name) {
        System.out.println(theList.get(editableContacts(name)).toString());
    }

    /**
     * This is the complex search method which is used other places as well.
     * It takes in string and checks if there is a first/last name that contains
     * the string given. If there are multiple results it will go on to ask about
     * more specifics such as last/first name or phone number.
     * 
     * @param search String
     * @return Integer
     */
    public int editableContacts(String search) {
        search = search.toLowerCase();
        int position = -1;
        int countMatch = 0;
        int countExactMatch = 0;
        if (searchList(search) == true) {
            for (int i = 0; i < theList.size(); i++) {
                if (theList.get(i).getFirstName().toLowerCase().contains(search)
                        || theList.get(i).getLastName().toLowerCase().contains(search)) {
                    countMatch++;
                    position = i;
                }
            }

            if (countMatch > 1) {
                System.out.println();
                System.out.println(red + "There is more than one person with that name!" + reset);
                System.out.println("Enter last/first name as well of the contact: ");
                System.out.println("Type 0 to cancle search!");
                if (theList.get(position).getFirstName().toLowerCase().contains(search)) {
                    search = theList.get(position).getFirstName().toLowerCase();
                    //
                    //
                } else if (theList.get(position).getLastName().toLowerCase().contains(search)) {
                    search = theList.get(position).getLastName().toLowerCase();
                }
                String search2 = scanIn.nextLine();
                search2 = search2.toLowerCase();
                boolean searchStop = false;
                int secondSearch = 0;
                while (searchStop == false && !search2.equals("0") && secondSearch < theList.size() - 1) {
                    if (secondSearch > 0) {
                        System.out.println(red + "No match! Try Again!" + reset);
                        search2 = scanIn.nextLine();
                    }
                    for (int i = 0; i < theList.size(); i++) {
                        if (theList.get(i).getFirstName().toLowerCase().equals(search) == true
                                && theList.get(i).getLastName().toLowerCase().equals(search2) == true) {
                            position = i;
                            countExactMatch++;
                            searchStop = true;
                        } else if (theList.get(i).getFirstName().toLowerCase().equals(search2) == true
                                && theList.get(i).getLastName().toLowerCase().equals(search) == true) {
                            position = i;
                            countExactMatch++;
                            searchStop = true;
                        }
                    }
                    secondSearch++;
                }
                if (search2.equals("0")) {
                    position = -1;
                } else if (secondSearch >= theList.size() - 1) {
                    position = -2;
                }

                if (countExactMatch > 1) {
                    position = -2;
                    System.out.println("There are multiple people with that first and last name");
                    System.out.println("Enter phone number of searched contact (xxx-xxx-xxxx): ");
                    String phoneNumber = scanIn.nextLine();
                    for (int i = 0; i < theList.size(); i++) {
                        if (theList.get(i).getPhoneNumber().equals(phoneNumber)) {
                            position = i;
                        }
                    }

                }

            }
        }
        return position;
    }

	@Override
	public String toString() {
		return "AddressBook [theList=" + theList + "]";
	}

    
    
}
