package com.example.c14378041.clubca2;

/**
 * Created by C14378041 on 12/12/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;



public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private final View mWindow;
    private Context mContext;

    public CustomInfoWindowAdapter(Context context) {
        this.mContext = mContext;
        this.mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
    }

    private void rendowWindowText(Marker marker, View v){

        String title = marker.getTitle();
        TextView clubtitle = (TextView) v.findViewById(R.id.title);

        if(!title.equals(" ")){
            clubtitle.setText(title);
        }

        String snippet = marker.getSnippet();
        TextView clubsnippet = (TextView) v.findViewById(R.id.snippet);

        if(!title.equals(" ")){
            clubsnippet.setText(snippet);
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        rendowWindowText(marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        rendowWindowText(marker, mWindow);
        return mWindow;
    }


}