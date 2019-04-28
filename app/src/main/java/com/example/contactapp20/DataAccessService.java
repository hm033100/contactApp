package com.example.contactapp20;


/**
 *
 * @author hermesmimini
 */
public interface DataAccessService {
	public AddressBook readAllData(String filename);
	public void writeAllData(AddressBook theList, String filename);
	
}
