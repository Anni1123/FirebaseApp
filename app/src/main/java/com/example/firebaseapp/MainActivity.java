package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private Button sendData;
    private EditText adddata;
    private Firebase mroorRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mroorRef=new Firebase("https://fir-app-d2e04.firebaseio.com/Users");
        sendData=(Button)findViewById(R.id.addBtn);
        adddata=(EditText) findViewById(R.id.valueField);
        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=adddata.getText().toString();
                //Firebase childref=mroorRef.child("Name");
                //childref.setValue(data);
                mroorRef.push().setValue(data);
            }
        });

    }
}
