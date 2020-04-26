package com.example.lab4_menu;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String textIdentifier = "TEXT_INTENT";

    Button orientation;
    TextView name;
    EditText text;

    String textIntent;

    boolean mState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        orientation = findViewById(R.id.orientation);
        name = findViewById(R.id.name);
        text = findViewById(R.id.editText);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra(textIdentifier));

        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && !s.toString().isEmpty()) {
                    name.setText(s);
                    textIntent = name.toString();
                }
            }
        });

        orientation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mState) setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                else setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                mState = !mState;
            }
        });

    }

    public static Intent newIntent(Context packageContext, String textIntent) {
        Intent intent = new Intent(packageContext, SecondActivity.class);
        intent.putExtra(textIdentifier, textIntent);
        return intent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                name.setText(R.string.action_settings);
                break;
            case R.id.action_1: name.setText(R.string.action_4);
                break;
            case R.id.action_2: name.setText(R.string.action_3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
