package com.example.contactapp20;

import android.app.Application;

import java.io.File;

public class MyApplication extends Application {

    private AddressBook theList = new AddressBook();

    public AddressBook getTheList() {
        return theList;
    }

    public void setTheList(AddressBook theList) {
        this.theList = theList;
    }

    /*public void onCreate(){
        super.onCreate();

        FileIOService das = new FileIOService(this);
        MainActivity.app.setTheList(das.readList("contacts.txt"));

    }
    @Override
    public void onTerminate(){
        super.onTerminate();

        FileIOService das = new FileIOService(this);
        das.writeList(MainActivity.app.getTheList(), "contacts.txt");

    }*/
}
