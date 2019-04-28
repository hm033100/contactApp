package com.example.contactapp20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class searchContact extends AppCompatActivity {

    AddressBook myList;
    AddressBook searchList;
    AddressBookAdapter adapter;
    ListView lv_contactsSearched;
    Button btn_search, btn_cancle;
    EditText txt_searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);

        lv_contactsSearched = findViewById(R.id.lv_contactsSearched);
        btn_search = findViewById(R.id.btn_search);
        btn_cancle = findViewById(R.id.btn_cancle);
        txt_searchText = findViewById(R.id.txt_searchText);

        myList = ((MyApplication) this.getApplication()).getTheList();

        searchList = new AddressBook();
        adapter = new AddressBookAdapter(searchContact.this, searchList);



        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = txt_searchText.getText().toString();

                for (int i = 0; i < myList.getSize(); i++){
                    if (myList.getContact(i).getFirstName().contains(search)){
                        searchList.addOne(myList.getContact(i));
                    } else if (myList.getContact(i).getLastName().contains(search)){
                        searchList.addOne(myList.getContact(i));
                    }
                }

                lv_contactsSearched.setAdapter(adapter);

                adapter.notifyDataSetChanged();



            }
        });

        lv_contactsSearched.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editPerson(position, myList.getContact(position).getClass());
            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
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
}
