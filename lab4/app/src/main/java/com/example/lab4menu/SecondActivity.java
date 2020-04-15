package com.example.lab4menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String textIdentifier = "TEXT_INTENT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    public static Intent newIntent(Context packageContext, String textIntent) {
        Intent intent = new Intent(packageContext, SecondActivity.class);
        intent.putExtra(textIdentifier, textIntent);
        return intent;
    }


}
