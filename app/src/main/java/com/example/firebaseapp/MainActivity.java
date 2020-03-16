package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private ListView mlistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlistView = (ListView) findViewById(R.id.list_item);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-app-d2e04.firebaseio.com/Users");
        Query query = databaseReference.limitToLast(50).orderByKey();

        FirebaseListOptions<String> options =
                new FirebaseListOptions.Builder<String>()
                        .setLayout(android.R.layout.simple_list_item_1)
                        .setQuery(query, String.class)
                        .build();
        FirebaseListAdapter<String> firebaseListAdapter = new FirebaseListAdapter<String>(options) {
            @Override
            protected void populateView(@NonNull View v, @NonNull String model, int position) {
                TextView textView = (TextView) v.findViewById(android.R.id.text1);
                textView.setText(model);
            }
        };
        mlistView.setAdapter(firebaseListAdapter);
    }
}