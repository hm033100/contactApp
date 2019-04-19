package com.example.contactapp20;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 *
 * @author hermesmimini
 */
/*public class FileIOService implements DataAccessService{*/

	public class FileIOService {


		Context context;


		ObjectMapper om = new ObjectMapper();


		public FileIOService(Context context) { this.context = context; }

		public void writeList (AddressBook theList, String filename) {

			File path = context.getExternalFilesDir(null);

			File file = new File(path, filename);
			try {
				om.writerWithDefaultPrettyPrinter().writeValue(file, theList);
			} catch ( IOException e) {
				e.printStackTrace();
			}
		}

		public AddressBook readList (String filename) {
			File path = context.getExternalFilesDir(null);
			File file = new File(path, filename);
			AddressBook returnList = new AddressBook();
			System.out.println(returnList);

			try {
				returnList = om.readValue(file, AddressBook.class );
				System.out.println("test try");
			} catch (IOException e) {
				e.printStackTrace();
				e.getCause();
				System.out.println("test catch");
			}

			return returnList;
		}

	}
    
/*public AddressBook readAllData() {
		
		AddressBook theList = new AddressBook();
		
		try {
			theList = new ObjectMapper().readerFor(AddressBook.class).readValue(new File("contacts.json"));
		} catch (IOException e) {
			System.out.println("No File Found!");
			e.printStackTrace();
		}
		
		return theList;
	}
	
	public void writeAllData(AddressBook theList) {
		
		ObjectMapper om = new ObjectMapper();
		
		try {
			om.writerWithDefaultPrettyPrinter().writeValue(new File("contacts.json"), theList);
		} catch (JsonGenerationException e) {
			System.out.println("Error in: DataMang Class!");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("Error in: DataMang Class!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error in: DataMang Class!");
			e.printStackTrace();
		}
		
	}
	*/


