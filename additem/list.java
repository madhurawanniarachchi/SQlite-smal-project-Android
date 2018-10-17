package com.example.madhura.additem;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class list extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    private ListView list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list_view = (ListView) findViewById(R.id.listView);
        dataBaseHelper = new DataBaseHelper(this);

        populateListView();
    }

    public void populateListView(){
        Cursor data = dataBaseHelper.getData();
        ArrayList<String> listDta = new ArrayList<>();

        while (data.moveToNext()){
            listDta.add(data.getString(1));
        }

        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listDta);
        list_view.setAdapter(adapter);
    }


}
