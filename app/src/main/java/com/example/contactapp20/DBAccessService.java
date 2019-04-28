package com.example.contactapp20;


import android.content.Context;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author hermesmimini
 */
public class DBAccessService implements DataAccessService {

	Context context;
	ObjectMapper om = new ObjectMapper();

	//constructor with context parameter
	public DBAccessService(Context context){
		this.context = context;
	}
	//create method that writes to a file
	public void writeAllData(AddressBook ab, String filename){
		File path = context.getExternalFilesDir(null);
		File file = new File(path, filename);

		try {
			om.writerWithDefaultPrettyPrinter().writeValue(file, ab);
		}

		catch (IOException e){
			e.printStackTrace();
		}
	}
	//create method that returns an Addressbook from a file
	public AddressBook readAllData(String filename){
		File path = context.getExternalFilesDir(null);
		File file = new File(path, filename);
		//create a new AddressBook
		AddressBook ab = new AddressBook();

		try {
			ab = om.readValue(file, AddressBook.class);

		} catch (IOException e){
			e.printStackTrace();
		}
		return ab;
	}


}
