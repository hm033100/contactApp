package com.example.contactapp20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class searchContact extends AppCompatActivity {

    AddressBook myList;
    AddressBook searchList;
    AddressBookAdapter adapter;
    ListView lv_contactsSearched;
    Button btn_search;
    EditText txt_searchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);

        lv_contactsSearched = findViewById(R.id.lv_contactsSearched);
        btn_search = findViewById(R.id.btn_search);
        txt_searchText = findViewById(R.id.txt_searchText);

        myList = ((MyApplication) this.getApplication()).getTheList();

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


    }
}
