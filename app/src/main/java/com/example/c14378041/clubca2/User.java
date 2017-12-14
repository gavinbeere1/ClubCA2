package com.example.c14378041.clubca2;

/**
 * Created by C14378041 on 12/4/2017.
 */

class User {


    public int id;
    public String Email;
    public String Password;
    public String Name;
    public String Surname;
    public String Address;
    public String SportType;
    public String Mobile;
    public String Position;


    public User(int anInt, String string, String cursorString, String s, String string1, String cursorString1, String s1, String string2, String cursorString2, String s2, String string3) {
    }

    public User(int id, String email, String password, String name, String surname, String address, String sportType, String mobile, String position) {
        this.id = id;
        Email = email;
        Password = password;
        Name = name;
        Surname = surname;
        Address = address;

        SportType = sportType;
        Mobile = mobile;
        Position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSportType() {
        return SportType;
    }

    public void setSportType(String sportType) {
        SportType = sportType;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }
}
