package com.example.lab4_menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String textIdentifier = "TEXT_INTENT";

    Button toSecondActivity, popup;
    TextView name;
    EditText text;

    String textIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        toSecondActivity = findViewById(R.id.to_activity);
        name = findViewById(R.id.name);
        text = findViewById(R.id.editText);
        popup = findViewById(R.id.popup);

        View.OnClickListener viewClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast3 = Toast.makeText(getApplicationContext(),
                        R.string.app_name, Toast.LENGTH_LONG);
                toast3.setGravity(Gravity.RIGHT, 0, 0);
                LinearLayout toastView = (LinearLayout) toast3.getView();
                ImageView ImageDef = new ImageView(getApplicationContext());
                ImageDef.setImageResource(R.drawable.ic_launcher_background);
                toastView.addView(ImageDef, 0);
                toast3.show();

                showPopupMenu(v);
            }
        };

        popup.setOnClickListener(viewClickListener);

        toSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(textIdentifier, name.getText().toString());
                startActivity(intent);
            }
        });

        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null) {
                    name.setText(s);
                    textIntent = name.toString();
                }
            }
        });


    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
        popupMenu.inflate(R.menu.popupmenu); // Для Android 4.0
       // для версії Android 3.0 треба використовувати довший
       // popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.menu1:
                        Toast.makeText(MainActivity.this,
                                "Вибрали PopupMenu 1",
                                Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu2:
                        Toast.makeText(MainActivity.this,
                                "Вибрали PopupMenu 2",
                                Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.menu3:
                        Toast.makeText(MainActivity.this,
                                "Вибрали PopupMenu 3",
                                Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                name.setText(R.string.action_settings);
                break;
            case R.id.action_1:
                name.setText(R.string.action_1);
                break;
            case R.id.action_2:
                name.setText(R.string.action_2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public static Intent newIntent(Context packageContext, String textIntent) {
        Intent intent = new Intent(packageContext, MainActivity.class);
        intent.putExtra(textIdentifier, textIntent);
        return intent;
    }
}
