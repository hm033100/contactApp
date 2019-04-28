package com.example.contactapp20;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editBusinessContact extends AppCompatActivity {

    Button btn_addBusinessContact, btn_delete, btn_call, btn_email, btn_navigate, btn_text;
    EditText txt_fName, txt_lName, txt_streetAddress, txt_city, txt_state, txt_zipCode, txt_country,
            txt_phoneNumber, txt_email, txt_businessHours, txt_websiteURL, txt_companyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_business_contact);

        btn_addBusinessContact = findViewById(R.id.btn_addBusinessContact);
        btn_delete = findViewById(R.id.btn_delete);
        btn_call = findViewById(R.id.btn_call);
        btn_email = findViewById(R.id.btn_email);
        btn_navigate = findViewById(R.id.btn_navigate);
        btn_text = findViewById(R.id.btn_text);
        txt_fName = findViewById(R.id.txt_fName);
        txt_lName = findViewById(R.id.txt_lName);
        txt_streetAddress = findViewById(R.id.txt_streetAddress);
        txt_city = findViewById(R.id.txt_city);
        txt_state = findViewById(R.id.txt_state);
        txt_zipCode = findViewById(R.id.txt_zipCode);
        txt_phoneNumber = findViewById(R.id.txt_phoneNumber);
        txt_email = findViewById(R.id.txt_email);
        txt_country = findViewById(R.id.txt_country);
        txt_businessHours = findViewById(R.id.txt_businessHours);
        txt_websiteURL = findViewById(R.id.txt_websiteURL);
        txt_companyName = findViewById(R.id.txt_companyName);

        Bundle incomingMessages = getIntent().getExtras();

        if (incomingMessages != null) {

            String newfName = incomingMessages.getString("fName");
            String newlName = incomingMessages.getString("lName");
            String newstreetAddress = incomingMessages.getString("streetAddress");
            String newcity = incomingMessages.getString("city");
            String newstate = incomingMessages.getString("state");
            String newzipCode = incomingMessages.getString("zipCode");
            String newphoneNumber = incomingMessages.getString("phoneNumber");
            String newemail = incomingMessages.getString("email");
            String newbusinessHours = incomingMessages.getString("businessHours");
            String newwebsiteURL = incomingMessages.getString("websiteURL");
            String newcompanyName = incomingMessages.getString("companyName");
            String newcountry = incomingMessages.getString("country");
            String newType = incomingMessages.getString("type");
            String newPic = incomingMessages.getString("picName");

            txt_fName.setText(newfName);
            txt_lName.setText(newlName);
            txt_streetAddress.setText(newstreetAddress);
            txt_city.setText(newcity);
            txt_state.setText(newstate);
            txt_zipCode.setText(newzipCode);
            txt_phoneNumber.setText(newphoneNumber);
            txt_email.setText(newemail);
            txt_country.setText(newcountry);
            txt_businessHours.setText(newbusinessHours);
            txt_websiteURL.setText(newwebsiteURL);
            txt_companyName.setText(newcompanyName);
        }

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] addresses = new String[1];
                addresses[0] = txt_email.getText().toString();
                composeEmail(addresses, "Hello from Hermes");
            }
        });
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(txt_phoneNumber.getText().toString());
            }
        });
        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeMmsMessage(txt_phoneNumber.getText().toString(), "Suuhhh dude");
            }
        });

        btn_navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mapsQuery = "geo:0,0?q=" + txt_streetAddress.getText().toString();
                Uri mapuri = Uri.parse((mapsQuery));
                showMap(mapuri);
            }
        });



        btn_addBusinessContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fName = txt_fName.getText().toString();
                String lName = txt_lName.getText().toString();
                String streetAddress = txt_streetAddress.getText().toString();
                String city = txt_city.getText().toString();
                String state = txt_state.getText().toString();
                String country = txt_country.getText().toString();
                String zipCode = txt_zipCode.getText().toString();
                String phoneNumber = txt_phoneNumber.getText().toString();
                String email = txt_email.getText().toString();
                String businessHours = txt_businessHours.getText().toString();
                String websiteURL = txt_websiteURL.getText().toString();
                String companyName = txt_companyName.getText().toString();

                Bundle incomingMessages = getIntent().getExtras();

                if (incomingMessages != null) {

                    String newfName = incomingMessages.getString("fName");
                    String newlName = incomingMessages.getString("lName");
                    String newstreetAddress = incomingMessages.getString("streetAddress");
                    String newcity = incomingMessages.getString("city");
                    String newstate = incomingMessages.getString("state");
                    String newzipCode = incomingMessages.getString("zipCode");
                    String newphoneNumber = incomingMessages.getString("phoneNumber");
                    String newemail = incomingMessages.getString("email");
                    String newbusinessHours = incomingMessages.getString("businessHours");
                    String newwebsiteURL = incomingMessages.getString("websiteURL");
                    String newcompanyName = incomingMessages.getString("companyName");
                    String newcountry = incomingMessages.getString("country");
                    String newType = incomingMessages.getString("type");
                    String newPic = incomingMessages.getString("picName");

                    txt_fName.setText(newfName);
                    txt_lName.setText(newlName);
                    txt_streetAddress.setText(newstreetAddress);
                    txt_city.setText(newcity);
                    txt_state.setText(newstate);
                    txt_zipCode.setText(newzipCode);
                    txt_phoneNumber.setText(newphoneNumber);
                    txt_email.setText(newemail);
                    txt_country.setText(newcountry);
                    txt_businessHours.setText(newbusinessHours);
                    txt_websiteURL.setText(newwebsiteURL);
                    txt_companyName.setText(newcompanyName);

                }

                Intent i = new Intent(v.getContext(), MainActivity.class);

                i.putExtra("fName", fName);
                i.putExtra("lName", lName);
                i.putExtra("streetAddress", streetAddress);
                i.putExtra("city", city);
                i.putExtra("state", state);
                i.putExtra("zipCode", zipCode);
                i.putExtra("phoneNumber", phoneNumber);
                i.putExtra("email", email);
                i.putExtra("businessHours", businessHours);
                i.putExtra("websiteURL", websiteURL);
                i.putExtra("companyName", companyName);
                i.putExtra("country", country);

                startActivity(i);


            }
        });

    }

    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void composeMmsMessage(String phoneNumber, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phoneNumber));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
