package com.example.contactapp20;


/**
 *
 * @author hermesmimini
 */
public interface DataAccessService {
	public AddressBook readAllData();
	public void writeAllData(AddressBook theList);
	
}
