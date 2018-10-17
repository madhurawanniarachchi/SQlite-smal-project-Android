package com.example.madhura.additem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class home extends AppCompatActivity {

    DataBaseHelper db_helper;
    EditText edit_txt;
    Button btn_add;
    Button btn_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        edit_txt=findViewById(R.id.item);
        btn_add=findViewById(R.id.add);
        btn_view=findViewById(R.id.view);
        db_helper = new DataBaseHelper(this);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String new_entry = edit_txt.getText().toString();
                if(new_entry.length()!=0){
                    addData(new_entry);
                    edit_txt.setText("");
                }else{
                    tostMessage("Put somthing on text");
                }
            }
        });

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this,list.class);
                startActivity(intent);
            }
        });
    }

    public void addData(String newEntry){
        boolean insertData = db_helper.addData(newEntry);

        if(insertData){
            tostMessage("Data Succsfully Inserted");
        }else{
            tostMessage("Data not Added");
        }
    }

    private void tostMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
