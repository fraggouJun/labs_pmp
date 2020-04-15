package com.example.lab3;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MainActivity extends Activity {

    Button btn;
    static final String ORIENTATION_PORTRAIT = "Портретний режим";
    static final String ORIENTATION_LANDSCAPE = "Альбомний режим";

    boolean mState = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button1);
        btn.setText(ORIENTATION_LANDSCAPE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mState) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    btn.setText(ORIENTATION_PORTRAIT);
                }
                else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    btn.setText(ORIENTATION_LANDSCAPE);
                }
                mState = !mState;
            }
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_LONG).show();
        } else if (newConfig.orientation ==
                Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_LONG).show();
        }
    }

}

