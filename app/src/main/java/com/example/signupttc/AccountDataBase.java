package com.example.signupttc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class AccountDataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Account_Manager";
    private static final String TABLE_NAME = "Account";
    private static final String NAMEACCOUNT = "Name_Account";
    private static final String PASSWORD = "PassWord";
    private static final String PHONENUMBER = "Phone_Number";
    private static final String EMAIL = "Email";
    private static final int VERSION = 1;

    private String SQLQuery = "CREATE TABLE " + TABLE_NAME + " (" +
            NAMEACCOUNT + " TEXT primary key, " +
            PASSWORD + " TEXT, " +
            PHONENUMBER + " TEXT, " +
            EMAIL + " TEXT )";


    public AccountDataBase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addAccount(MyAccount myAccount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAMEACCOUNT, myAccount.getNameAccount());
        values.put(PASSWORD, myAccount.getPassWord());
        values.put(PHONENUMBER, myAccount.getPhoneNumber());
        values.put(EMAIL, myAccount.getEmail());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<MyAccount> getAllAccount() {
        List<MyAccount> accountList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                MyAccount myAccount = new MyAccount();
                myAccount.setNameAccount(cursor.getString(0));
                myAccount.setPassWord(cursor.getString(1));
                myAccount.setPhoneNumber(cursor.getString(2));
                myAccount.setEmail(cursor.getString(3));

                accountList.add(myAccount);
            } while (cursor.moveToNext());
        }
        db.close();
        return accountList;
    }
}
