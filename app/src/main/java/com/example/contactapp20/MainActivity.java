package com.example.contactapp20;

import android.app.Activity;
import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ser.Serializers;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static MyApplication app = new MyApplication();

    Button btn_add, btn_save, btn_load, btn_search;

    public static ListView lv_contacts;

    AddressBookAdapter adapter;

    static Context c;


    AddressBook myList;
    static FileIOService das = new FileIOService(c);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_save = findViewById(R.id.btn_save);
        btn_load = findViewById(R.id.btn_load);
        btn_search = findViewById(R.id.btn_search);
        lv_contacts = findViewById(R.id.lv_contacts);

        myList = ((MyApplication) this.getApplication()).getTheList();

        adapter = new AddressBookAdapter(MainActivity.this, myList);

        lv_contacts.setAdapter(adapter);

        Bundle incomingMessages = getIntent().getExtras();


        if (incomingMessages != null){

            if (incomingMessages.containsKey("businessHours")) {

                String fName = incomingMessages.getString("fName");
                String lName = incomingMessages.getString("lName");
                String streetAddress = incomingMessages.getString("streetAddress");
                String city = incomingMessages.getString("city");
                String state = incomingMessages.getString("state");
                String zipCode = incomingMessages.getString("zipCode");
                String phoneNumber = incomingMessages.getString("phoneNumber");
                String email = incomingMessages.getString("email");
                String businessHours = incomingMessages.getString("businessHours");
                String websiteURL = incomingMessages.getString("websiteURL");
                String companyName = incomingMessages.getString("companyName");
                String country = incomingMessages.getString("country");


                BusinessContact bc = new BusinessContact(businessHours, websiteURL,
                        companyName, false, fName, lName,
                        streetAddress, city, state,
                        zipCode, country, phoneNumber, fName, email);

                myList.addOne(bc);

                adapter.notifyDataSetChanged();
            } else if (incomingMessages.containsKey("birthdate")) {

                String fName = incomingMessages.getString("fName");
                String lName = incomingMessages.getString("lName");
                String streetAddress = incomingMessages.getString("streetAddress");
                String city = incomingMessages.getString("city");
                String state = incomingMessages.getString("state");
                String zipCode = incomingMessages.getString("zipCode");
                String phoneNumber = incomingMessages.getString("phoneNumber");
                String email = incomingMessages.getString("email");
                String country = incomingMessages.getString("country");
                String birthdate = incomingMessages.getString("birthdate");
                String nickname = incomingMessages.getString("nickname");
                String memo = incomingMessages.getString("memo");

                PersonContact pc = new PersonContact(birthdate, nickname,
                        memo, fName, lName,
                        streetAddress, city, state,
                        zipCode, country, phoneNumber, fName, email);

                myList.addOne(pc);

                adapter.notifyDataSetChanged();

            }


        }

        lv_contacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editPerson(position, myList.getContact(position).getClass());
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), add_business_or_person.class);
                startActivity(i);
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), searchContact.class);
                startActivity(i);
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileIOService das = new FileIOService(v.getContext());
                das.writeList(myList, "contacts.txt");
            }
        });

        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             FileIOService das = new FileIOService(v.getContext());
            myList = das.readList("contacts.txt");
            System.out.println(myList);
            adapter.notifyDataSetChanged();
            }
        });

    }

    public void editPerson(int position, Class aClass) {

        if (aClass == PersonContact.class) {
            Intent i = new Intent(getApplicationContext(), editPersonContact.class);
            PersonContact pc = (PersonContact)myList.getContact(position);
            Boolean type = true;


            i.putExtra("fName", pc.getFirstName());
            i.putExtra("lName", pc.getLastName());
            i.putExtra("streetAddress", pc.getStreetName());
            i.putExtra("city", pc.getCity());
            i.putExtra("state", pc.getState());
            i.putExtra("zipCode", pc.getPostalCode());
            i.putExtra("phoneNumber", pc.getPhoneNumber());
            i.putExtra("email", pc.getEmail());
            i.putExtra("birthdate", pc.getBirthday());
            i.putExtra("nickname", pc.getNickName());
            i.putExtra("memo", pc.getMemo());
            i.putExtra("country", pc.getCountry());
            i.putExtra("type", type);
            i.putExtra("picName", pc.getFirstName());
            i.putExtra("position", position);

            myList.removeContactAt(position);

            startActivity(i);

        }else if (aClass == BusinessContact.class){
            Intent i = new Intent(getApplicationContext(), editBusinessContact.class);
            BusinessContact bc = (BusinessContact)myList.getContact(position);
            Boolean type = false;

            i.putExtra("fName", bc.getFirstName());
            i.putExtra("lName", bc.getLastName());
            i.putExtra("streetAddress", bc.getStreetName());
            i.putExtra("city", bc.getCity());
            i.putExtra("state", bc.getState());
            i.putExtra("zipCode", bc.getPostalCode());
            i.putExtra("phoneNumber", bc.getPhoneNumber());
            i.putExtra("email", bc.getEmail());
            i.putExtra("businessHours", bc.getBusinessHours());
            i.putExtra("websiteURL", bc.getWebsite());
            i.putExtra("companyName", bc.getCompany());
            i.putExtra("picName", bc.getFirstName());
            i.putExtra("country", bc.getCountry());
            i.putExtra("position", position);

            myList.removeContactAt(position);

            startActivity(i);

        }
    }

    public void loadFile(){

        FileIOService das = new FileIOService(this);
        app.setTheList(das.readList("contacts.txt"));
        lv_contacts.setAdapter(new AddressBookAdapter(MainActivity.this, app.getTheList()));

    }

    public void saveFile(){
        FileIOService das = new FileIOService(this);
        das.writeList(app.getTheList(), "contacts.txt");
        lv_contacts.setAdapter(new AddressBookAdapter(MainActivity.this, app.getTheList()));
    }


}
