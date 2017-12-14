package com.example.c14378041.clubca2;

import android.graphics.Point;

/**
 * Created by C14378041 on 12/7/2017.
 */

public class Club {

    private int id;
    private String name;
    private String address;
    private float x;
    private float y;
    private String type;

    public Club() {
    }

    public Club(int id, String name, String address, String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.type = type;
    }

    public Club(int id, String name, String address, float x, float y, String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
