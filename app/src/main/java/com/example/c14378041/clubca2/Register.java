package com.example.c14378041.clubca2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.c14378041.clubca2";
    Button registerUserButton;
    DBHandler dbhandler;

    EditText editEmail;
    EditText editPassword;
    EditText editName;
    EditText editSname;
    EditText editAddress;
    EditText editMobile;
    EditText editPosition;
    String sport = "test";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbhandler = new DBHandler(this);

       editEmail = (EditText) findViewById(R.id.emailEditText);
        editPassword = (EditText) findViewById(R.id.passwordEditText);
        editName = (EditText) findViewById(R.id.nameEditText);
        editSname = (EditText) findViewById(R.id.lastnameEditText);
         editAddress = (EditText) findViewById(R.id.addressEditText);
         editMobile = (EditText) findViewById(R.id.mobileEditText);
        editPosition = (EditText) findViewById(R.id.positionEditText);

    }


    public void registerNewUser(View view){


        String email = editEmail.getText().toString().trim();
        String number = editMobile.getText().toString();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String regexStr = "^[0][0-9]{8,12}$";


        //check if the user already exists

//        Cursor cursor = dbhandler.getAllData();
//        Boolean found = false;
////
//        while (found = false) {
//            while (cursor.moveToNext()) {
//
//                if (cursor.getString(1).equals(editEmail.getText().toString())) {
//                    Toast.makeText(Register.this, "User Already Exists!", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//
//            found = true;
//
//        }


        if (!email.matches(emailPattern))
        {
            Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();

        }
        else if (!number.matches(regexStr))
        {
            Toast.makeText(getApplicationContext(),"Invalid phone number", Toast.LENGTH_SHORT).show();

        }
        else
        {
            boolean isInserted = dbhandler.addUser(editEmail.getText().toString(),
                    editPassword.getText().toString(),
                    editName.getText().toString(),
                    editSname.getText().toString(),
                    editAddress.getText().toString(),
                    sport,
                    editMobile.getText().toString(),
                    editPosition.getText().toString());



            Intent intent = new Intent(this, Welcome_Activity.class);
            EditText editText1 = (EditText) findViewById(R.id.nameEditText);
            String message = editText1.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
            Toast.makeText(Register.this,"User Registered & Logged in!",Toast.LENGTH_SHORT).show();

        }
//        editMobile.getText().toString().length()<8 || number.length()>12 ||

//
//        String regexStr = "^\0[0-9]{10,10}$";
//
//        String number=entered_number.getText().toString();
//
//        if(entered_number.getText().toString().length()<10 || number.length()>13 || number.matches(regexStr)==false  ) {
//            Toast.makeText(MyDialog.this,"Please enter "+"\n"+" valid phone number",Toast.LENGTH_SHORT).show();
//            // am_checked=0;
//        }


    }
}




