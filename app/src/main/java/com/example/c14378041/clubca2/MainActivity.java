package com.example.c14378041.clubca2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button registerButton;
    DBHandler dbhandler;
    EditText email;
    EditText password;
    public static final String EXTRA_MESSAGE = "com.example.c14378041.clubca2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button registerButton= (Button)findViewById(R.id.registerbutton);
       email = (EditText) findViewById(R.id.emaillogin);
        password = (EditText) findViewById(R.id.passwordlogin);
        dbhandler = new DBHandler(this);




    }

    public void adminLogin(View view)
    {
        Intent intent = new Intent(this, Admin_Activity.class);
        startActivity(intent);
    }

    public void Ulogin(View view)
    {


        Cursor cursor = dbhandler.getAllData();
        Boolean found = false;

        while (cursor.moveToNext()){

            if ( (cursor.getString(1).equals(email.getText().toString()) ) && (cursor.getString(2).equals(password.getText().toString())) )
            {
                Intent intent = new Intent(this, Welcome_Activity.class);

                String message = email.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                found = true;
                Toast.makeText(MainActivity.this,"User Logged in!",Toast.LENGTH_SHORT).show();

            }
        }

        if ((cursor.isAfterLast()) && !found)
        {
            Toast.makeText(MainActivity.this,"Username or Password incorrect",Toast.LENGTH_SHORT).show();
            cursor.close();
        }



    }

    public void registerUser(View view){

        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }





}
