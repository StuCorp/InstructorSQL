package example.codeclan.com.sqlfun;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.tech.NfcA;

import java.util.ArrayList;

/**
 * Created by user on 06/07/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "instructorDB";

    //Table Name
    private static final String TABLE_INSTRUCTORS = "instructors";

    // instructor table column names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_FAV_LANG = "favourite_language";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create Tables
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE " + TABLE_INSTRUCTORS + "(" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT, " + KEY_FAV_LANG + " TEXT)";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_INSTRUCTORS);
        onCreate(db);
    }

    public int addInstructor(Instructor instructor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, instructor.getName());
        values.put(KEY_FAV_LANG, instructor.getFavourite_language());

        // db.insert returns the id of last inserted row
         int id = (int)db.insert(TABLE_INSTRUCTORS, null, values);
        db.close();
        return id;
    }

    public Instructor getInstructor(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Instructor instructor = null;

        Cursor cursor = db.query(TABLE_INSTRUCTORS, new String[] {KEY_ID, KEY_NAME, KEY_FAV_LANG}, KEY_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();

            instructor = new Instructor(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
        }
        return instructor;

    }

    public ArrayList<Instructor> getAllInstructors() {
        ArrayList<Instructor> instructorList = new ArrayList<Instructor>();

        String sql = "SELECT * FROM " + TABLE_INSTRUCTORS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        Instructor instructor = null;
        if (cursor.moveToFirst()){
            do {
                instructor = new Instructor();
                instructor.set_id(Integer.parseInt(cursor.getString(0)));
                instructor.setName(cursor.getString(1));
                instructor.setFavourite_language(cursor.getString(2));
                instructorList.add(instructor);
            } while (cursor.moveToNext());
        }
        return instructorList;
    }
    // Deleting single contact
    public void deleteContact(Instructor instructor) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_INSTRUCTORS, KEY_ID + " = ?",
                new String[] { String.valueOf(instructor.get_id()) });
        db.close();
    }


    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_INSTRUCTORS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    public void deleteAllInstructors(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_INSTRUCTORS);
        db.close();
    }



}






















