package com.example.c14378041.clubca2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.UserDictionary;

import java.util.ArrayList;

/**
 * Created by C14378041 on 12/4/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    public static final String DB__NAME = "ClubDB2";
    public static final int DB_VERSION=10;
    public static final String TABLE_USER="User";
    public static final String TABLE_CLUB="Club";
    public static final String TABLE_USERCLUBS="ClubPlayers";


    public static final String COL_ID="ID";
    public static final String COL_ID2="ID";
    public static final String COL_ID3="ID";



    public static final String COL_EMAIL="Email";
    public static final String COL_PASSWORD="Password";


    public static final String COL_CLUBNAME="ClubName";
    public static final String COL_CLUBADDRESS="ClubAddress";
    public static final String COL_X="X";
    public static final String COL_Y="Y";
    public static final String COL_TYPE="Type";



    public static final String COL_NAME="Name";
    public static final String COL_SURNAME="Surname";
    public static final String COL_ADDRESS="Address";
    public static final String COL_SPORT="SportType";
    public static final String COL_MOBILE="Mobile";
    public static final String COL_POSITION="Position";



    public DBHandler (Context context){
        super(context, DB__NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db){

        String sqlstatement = "CREATE TABLE " + TABLE_USER + "( " +
                COL_ID + " integer primary key autoincrement, " +
                COL_EMAIL + " text, " +
                COL_PASSWORD + " text, " +
                COL_NAME + " text, " +
                COL_SURNAME +  " text, " +
                COL_ADDRESS + " text, " +
                COL_SPORT + " text, " +
                COL_MOBILE + " text, " +
                COL_POSITION + " text ) ";

        String clubstatement = "CREATE TABLE " + TABLE_CLUB + "( " +
                COL_ID2 + " integer primary key autoincrement, " +
                COL_CLUBNAME + " text, " +
                COL_CLUBADDRESS + " text, " +
                COL_X + " double, " +
                COL_Y + " double, " +
                COL_TYPE + " text ) ";

        String clubplayers = "CREATE TABLE " + TABLE_USERCLUBS + "( " +
                COL_ID3 + " integer primary key autoincrement, " +
                COL_EMAIL + "text, " +
                COL_CLUBNAME + "text ) ";



        db.execSQL(sqlstatement);
        db.execSQL(clubstatement);
        db.execSQL(clubplayers);




    }

    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion)
    {
        db.execSQL("drop table if exists " + TABLE_USER);
        db.execSQL("drop table if exists " + TABLE_CLUB);
        db.execSQL("drop table if exists " + TABLE_USERCLUBS);


        onCreate(db);
    }


    public boolean addClubUser(String clubName, String playerName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CLUBNAME, clubName);
        contentValues.put(COL_NAME, playerName);



        long result = db.insert(TABLE_USERCLUBS,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;




    }

    public boolean addUser(String email, String password, String name, String surname,
                           String address, String sport, String mobile, String position)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_PASSWORD, password);
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_SURNAME, surname);
        contentValues.put(COL_ADDRESS, address);
        contentValues.put(COL_SPORT, sport);
        contentValues.put(COL_MOBILE, mobile);
        contentValues.put(COL_POSITION, position);





        long result = db.insert(TABLE_USER,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;




    }



    public boolean addClub(String Clubname, String Clubaddress, double x, double y, String type)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_CLUBNAME, Clubname);
        contentValues.put(COL_CLUBADDRESS, Clubaddress);
        contentValues.put(COL_X, x);
        contentValues.put(COL_Y, y);
        contentValues.put(COL_TYPE, type);


        long result = db.insert(TABLE_CLUB,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }
    public void insert_User(String sqlInsert)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sqlInsert );
        db.close();
    }

    public void insert_Club(String sqlInsert)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL( sqlInsert );

        db.close();
    }

    public void update_User(String sqlUpdate){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sqlUpdate );
        db.close();
    }

    public void update_Club(String sqlUpdate){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL( sqlUpdate );
        db.close();
    }


    public ArrayList<User> selectAll_User( ){

        String sqlQuery = "select * from " + TABLE_USER;

        SQLiteDatabase db = this.getReadableDatabase( );
        Cursor cursor = db.rawQuery( sqlQuery, null);

        ArrayList<User> users = new ArrayList<User>( );
        while ( cursor.moveToNext( ) ) {
            User currentUser = new User(cursor.getInt( 0 ) ,
                    cursor.getString( 1 ) , cursor.getString( 2 ) , cursor.getString( 3 ) ,
                    cursor.getString( 4 ) , cursor.getString( 5 ) ,
                    cursor.getString( 6 ) , cursor.getString( 7 ) , cursor.getString( 8 ) , cursor.getString( 9 ) ,
                    cursor.getString( 10 ));
            users.add ( currentUser );
        }
        cursor.close();
        db.close( );
        return users;
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_USER, null);
        return res;
    }

    public Cursor getAllClubUserData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_USERCLUBS, null);
        return res;
    }

    public ArrayList<Club> getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Club> clubs= new ArrayList<Club>();
        Cursor result = db.rawQuery("select * from "+TABLE_CLUB , null);
        while(result.moveToNext()){
            clubs.add( new Club(result.getInt(result.getColumnIndex(COL_ID2)),result.getString(result.getColumnIndex(COL_CLUBNAME)), result.getString(result.getColumnIndex(COL_CLUBADDRESS)),result.getString(result.getColumnIndex(COL_TYPE))));

        }
        return clubs;
    }

    public Cursor getAllClubData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_CLUB, null);
        return res;
    }





}
