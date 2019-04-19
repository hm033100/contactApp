package com.example.contactapp20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class add_business_or_person extends AppCompatActivity {

    Button btn_personChoice, btn_businessChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_business_or_contact);

        btn_businessChoice = findViewById(R.id.btn_businessChoice);
        btn_personChoice = findViewById(R.id.btn_personChoice);

        btn_personChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), add_person_contact.class);
                startActivity(i);
            }
        });

        btn_businessChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), add_business_contact.class);
                startActivity(i);
            }
        });
    }
}
