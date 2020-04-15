package com.example.lab4menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button toSecondActivity;
    TextView name;
    EditText text;

    String textIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toSecondActivity = findViewById(R.id.to_activity);
        name = findViewById(R.id.name);
        text = findViewById(R.id.editText);

        toSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SecondActivity.newIntent(MainActivity.this, textIntent);
                startActivity(intent);
            }
        });

        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null) {
                    name.setText(s);
                    textIntent = name.toString();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_settings: name.setText(R.string.action_settings);
            case R.id.action_1: name.setText(R.string.action_1);
            case R.id.action_2: name.setText(R.string.action_2);
        }

        return super.onOptionsItemSelected(item);
    }
}
