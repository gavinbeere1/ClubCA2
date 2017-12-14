package com.example.c14378041.clubca2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome_Activity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.c14378041.Message";
    DBHandler myDB;
    Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_);
        myDB = new DBHandler(this);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(Register.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);


        //get the spinner from the xml.
        dropdown = (Spinner)findViewById(R.id.clubSpinner);
//create a list of items for the spinner.
        String[] items = new String[]{"GAA", "Rugby", "Soccer"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

    }

    public void buttonClick(View v) {
        Button button = (Button) v;

        dropdown = (Spinner) findViewById(R.id.clubSpinner);
        String text = dropdown.getSelectedItem().toString();

//        if (text.equals("GAA")) {
            Intent intent1 = new Intent(this, MapsActivity.class);
            intent1.putExtra(EXTRA_MESSAGE, text);
            startActivity(intent1);

//        } else if (text.equals("Rugby")) {
//            Intent intent2 = new Intent(this, MapsActivity_Rugby.class);
//            startActivity(intent2);
//        } else if (text.equals("Soccer")) {
//            Intent intent3 = new Intent(this, MapsActivity_Football.class);
//            startActivity(intent3);
//        }

    }

//
//    public void findClubs(){
//
//        Spinner dropdown = (Spinner)findViewById(R.id.clubSpinner);
//        String text = dropdown.getSelectedItem().toString();
//
//        if (text.equals("GAA"))
//        {
//            Toast.makeText(Welcome_Activity.this,"GAA!",Toast.LENGTH_SHORT).show();
//
//        }
//        if (text.equals("Rugby"))
//        {
//            Toast.makeText(Welcome_Activity.this,"Rugby!",Toast.LENGTH_SHORT).show();
//
//        }
//        if (text.equals("Soccer"))
//        {
//            Toast.makeText(Welcome_Activity.this,"Soccer!",Toast.LENGTH_SHORT).show();
//
//        }
//
//    }


    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
