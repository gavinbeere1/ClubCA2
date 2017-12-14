package com.example.c14378041.clubca2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterClub_Activity extends AppCompatActivity {

    EditText name;
    EditText address;
    Button b;
    DBHandler dbhandler;
    Spinner dropdown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_club_);

        dbhandler = new DBHandler(this);

        //get the spinner from the xml.
        dropdown = (Spinner) findViewById(R.id.clubTypeSpinner);
//create a list of items for the spinner.
        String[] items = new String[]{"GAA", "Rugby", "Soccer"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        b = (Button) findViewById(R.id.newregisterbutton);
        name = (EditText) findViewById(R.id.clubNameEditText);
        address = (EditText) findViewById(R.id.clubAddressEditText);
        dropdown = (Spinner) findViewById(R.id.clubTypeSpinner);
        final String text = dropdown.getSelectedItem().toString();

    }

//buttons going through twice here

    public void registerNewClub(View view) {

        new GetCoordinates().execute(address.getText().toString().replace(" ", "+"));

    }


    private class GetCoordinates extends AsyncTask<String, Void, String> {
        ProgressDialog dialog = new ProgressDialog(RegisterClub_Activity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.setMessage("Please wait....");
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();


        }

        @Override
        protected String doInBackground(String... strings) {
            String response;
            try {
                String address = strings[0];
                HTTPDataHandler http = new HTTPDataHandler();
                String url = String.format("https://maps.googleapis.com/maps/api/geocode/json?address=%s", address);
                response = http.getHTTPData(url);
                return response;
            } catch (Exception ex) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONObject jsonObject = new JSONObject(s);

                String lat = ((JSONArray) jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                        .getJSONObject("location").get("lat").toString();
                String lng = ((JSONArray) jsonObject.get("results")).getJSONObject(0).getJSONObject("geometry")
                        .getJSONObject("location").get("lng").toString();

                double x = Double.parseDouble(lat);
                double y = Double.parseDouble(lng);
                String text = dropdown.getSelectedItem().toString();
                boolean isInserted = dbhandler.addClub(name.getText().toString(),
                        address.getText().toString(),
                        x,
                        y,
                        text);


//                Toast.makeText(RegisterClub_Activity.this, String.format("Coordinates : %s / %s ",lat,lng), Toast.LENGTH_SHORT).show();
                Cursor res = dbhandler.getAllClubData();
                if (res.getCount() == 0) {
                    // show message
                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :" + res.getString(0) + "\n");
                    buffer.append("Name :" + res.getString(1) + "\n");
                    buffer.append("Address :" + res.getString(2) + "\n");
                    buffer.append("X :" + res.getString(3) + "\n");
                    buffer.append("Y :" + res.getString(4) + "\n");
                    buffer.append("Type :" + res.getString(5) + "\n\n");
                }

                // Show all data
                showMessage("Data", buffer.toString());

                if (dialog.isShowing())
                    dialog.dismiss();

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }


        public void showMessage(String title, String Message) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterClub_Activity.this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(Message);
            builder.show();


        }
    }

}

