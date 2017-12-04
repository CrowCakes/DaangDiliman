package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMap();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToWayfinding();
            }
        });
    }

    private void goToWayfinding() {
        Intent intent = new Intent(this, activity1.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    private void goToMap() {
        Intent intentM = new Intent(this, activityMap.class);
        startActivity(intentM);
        overridePendingTransition(0, 0);
    }
}
