package com.example.lab4_menu;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    Button alert1, alert2, alert3, alert4, alert5, alert6;
    AlertDialog.Builder ad, builder;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        alert1 = findViewById(R.id.alertButton);
        alert2 = findViewById(R.id.alertList);
        alert3 = findViewById(R.id.alertSwitcher);
        alert4 = findViewById(R.id.alertRadio);
        alert5 = findViewById(R.id.alertRating);
        alert6 = findViewById(R.id.alertButtons);

        if(alert1 == null) System.out.println("alert1 null");

        alert1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ThirdActivity.this);
                builder.setTitle("Важливе повідомлення!")
                        .setMessage("Виконайте лабораторну №6!")
                        .setIcon(R.drawable.ic_launcher_background)
                        .setCancelable(false)
                        .setNegativeButton("ОК, роблю",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        alert6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = ThirdActivity.this;
                String title = "Вибір є завжди";
                String message = "Віберіть відповідь";
                String button1String = "Здам лабораторну";
                String button2String = "Ні, не здам";

                ad = new AlertDialog.Builder(context);
                ad.setTitle(title); // заголовок
                ad.setMessage(message); // повідомлення
                ad.setPositiveButton(button1String, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        Toast.makeText(context, "Ви зробили вірний вибір", Toast.LENGTH_LONG).show();
                    }
                });
                ad.setNegativeButton(button2String, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int arg1) {
                        Toast.makeText(context, "Можливо…", Toast.LENGTH_LONG).show();
                    }
                });
                ad.setCancelable(true);
                ad.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(context, "Ви не зробили вибір!", Toast.LENGTH_LONG).show();
                    }
                });
                ad.show();
            }
        });


        alert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] mLab6Name ={"Здам", "Не здам", "До дому піду"};
                builder = new AlertDialog.Builder(ThirdActivity.this);
                builder.setTitle("Варіанти дій"); // заголовок для діалогу
                builder.setItems(mLab6Name, new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        Toast.makeText(getApplicationContext(),
                                "Вибраний варіант: " + mLab6Name[item], Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(false);
                builder.create().show();
            }
        });

        alert3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] mChooseLab6 = {"Здам", "Не здам", "До дому піду"};
                builder = new AlertDialog.Builder(ThirdActivity.this);
                builder.setTitle("Виберіть варіант дій")
                        .setCancelable(false)
                        .setNeutralButton("Назад",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        .setSingleChoiceItems(mChooseLab6, -1,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int item) {
                                        Toast.makeText(getApplicationContext(), "Вибрали: " + mChooseLab6[item], Toast.LENGTH_SHORT).show();
                                    }
                                });
                builder.create().show();
            }
        });

        alert4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final boolean[] mCheckedItems = {false, true, false};
                final String[] mChooseLab6 = {"Здам", "Не здам", "До дому піду"};
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Оберіть декілька варіантів");
                builder.setMultiChoiceItems(mChooseLab6, mCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(
                                getApplicationContext(),
                                "Вибрали: "
                                        + mChooseLab6[which],
                                Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setCancelable(true);
                final AlertDialog dlg = builder.create();
                dlg.show();
            }
        });

        alert5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder ratingdialog = new AlertDialog.Builder(ThirdActivity.this);
                final RatingBar rating = new RatingBar(ThirdActivity.this);

                ratingdialog.setIcon(android.R.drawable.btn_star_big_on);
                ratingdialog.setTitle("Голосуємо за завдання!");
                ratingdialog.setView(rating);
                rating.setMax(5);
                rating.setNumStars(5);
                rating.setStepSize((float) 1.0);
                ratingdialog.setPositiveButton("Готово",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        String.valueOf(rating.getRating()),
                                        Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .setNegativeButton("Відміна",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int
                                            id) {
                                        dialog.cancel();
                                    }
                                });
                ratingdialog.create();
                ratingdialog.show();
            }
        });
    }

}
