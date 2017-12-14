package com.example.c14378041.clubca2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_Activity extends AppCompatActivity {

    EditText email;
    EditText pword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_);
        email = (EditText) findViewById(R.id.adminEmaillogin);
        pword = (EditText) findViewById(R.id.adminPasswordlogin);
        login = (Button) findViewById(R.id.adminButton);
    }

    public void aLogin(View view)
    {
        if (email.getText().toString().equals("Admin") && pword.getText().toString().equals("admin"))
        {
            Intent intent = new Intent(this, RegisterClub_Activity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(Admin_Activity.this,"Username or Password incorrect",Toast.LENGTH_SHORT).show();
        }
    }
}
