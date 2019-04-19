package com.example.contactapp20;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AddressBookAdapter extends BaseAdapter {

    Activity mActivity;
    AddressBook myList;

    public AddressBookAdapter(Activity mActivity, AddressBook myList) {
        this.mActivity = mActivity;
        this.myList = myList;
    }

    @Override
    public int getCount() {
        return myList.getSize();
    }

    @Override
    public BaseContact getItem(int position) {
        return myList.getContact(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View onePersonLine;

        LayoutInflater inflater = (LayoutInflater)mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = inflater.inflate(R.layout.person_one_line, parent, false);

        TextView tv_name = onePersonLine.findViewById(R.id.tv_name);
        TextView tv_email = onePersonLine.findViewById(R.id.tv_email);
        TextView tv_phoneNumber = onePersonLine.findViewById(R.id.tv_phoneNumber);
        ImageView iv_picture = onePersonLine.findViewById(R.id.iv_picture);

        BaseContact bc = this.getItem(position);

        tv_name.setText(bc.getFirstName() + " " + bc.getLastName());
        tv_email.setText(bc.getEmail());
        tv_phoneNumber.setText(bc.getPhoneNumber());

        int icon_resource_numbers[] = {
                R.drawable.icon01_01,
                R.drawable.icon01_02,
                R.drawable.icon01_03,
                R.drawable.icon01_04,
                R.drawable.icon01_05,
                R.drawable.icon01_06,
                R.drawable.icon01_07,
                R.drawable.icon01_08,
                R.drawable.icon01_09,
                R.drawable.icon01_10,
                R.drawable.icon01_11,
                R.drawable.icon01_12,
                R.drawable.icon01_13,
                R.drawable.icon01_14,
                R.drawable.icon01_15,
                R.drawable.icon01_16,
                R.drawable.icon01_17,
                R.drawable.icon01_18,
                R.drawable.icon01_19,
                R.drawable.icon01_20,
                R.drawable.icon01_21,
                R.drawable.icon01_22,
                R.drawable.icon01_23,
                R.drawable.icon01_24,
                R.drawable.icon01_25,
                R.drawable.icon01_26,
                R.drawable.icon01_27,
                R.drawable.icon01_28,
                R.drawable.icon01_29,
                R.drawable.icon01_30,
        };

        iv_picture.setImageResource(icon_resource_numbers[position]);

        return onePersonLine;
    }
}
