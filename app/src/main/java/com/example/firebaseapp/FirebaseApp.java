package com.example.firebaseapp;

import android.app.Application;

import com.firebase.client.Firebase;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}

