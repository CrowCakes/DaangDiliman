package com.example.user.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.support.constraint.ConstraintSet.VISIBLE;

public class entrance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        String bldg = getIntent().getStringExtra("EXTRA_SELECTED_DEST");

        ImageView img1 = (ImageView) findViewById(R.id.im1);
        ImageView img2 = (ImageView) findViewById(R.id.im2);

        switch (bldg) {
            case "PH":
                img1.setImageResource(R.drawable.pav1e);
                img2.setImageResource(R.drawable.phwe);
                break;
            case "MH":
                img1.setImageResource(R.drawable.pav1e);
                img2.setImageResource(R.drawable.phwe);
                break;
        }

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFirstPage();
            }
        });
    }

    private void goToFirstPage() {
        Intent intent2 = new Intent(this, activityMoreInfo.class);
        startActivity(intent2);
        overridePendingTransition(0, 0);
    }
}
