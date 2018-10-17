package com.example.madhura.additem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DataBaseHelper";
    private static final String TABLE_NAME = "people_table";
    private static final String col1 = "id";
    private static final String col2 = "name";
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT)", TABLE_NAME, col1,col2);
        db.execSQL(create_table);

    }

    public DataBaseHelper(Context context) {
        super(context, TABLE_NAME, null,1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(String.format("DROP IF TABLE EXISTS %s", TABLE_NAME));
        onCreate(db);
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    public boolean addData(String text){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content_values = new ContentValues();
        content_values.put(col2,text);
        Log.d(TAG,"add data to "+TABLE_NAME);
        long result = db.insert(TABLE_NAME,null,content_values);

        if(result == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }


}
