package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class activityEntrancePicture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance_picture);

        String bldg = getIntent().getStringExtra("EXTRA_SELECTED_DEST");
        ImageView img1 = (ImageView) findViewById(R.id.im1);
        TextView text = (TextView) findViewById(R.id.textView5);

        switch (bldg) {
            case "PH1": //CAL-side
                img1.setImageResource(R.drawable.calside);
                text.setText("Entrance facing College of Arts and Letters (CAL)");
                break;
            case "PH2": //Pav1
                img1.setImageResource(R.drawable.pav1e);
                text.setText("Pavilion 1 Entrance");
                break;
            case "PH3": //Pav4
                img1.setImageResource(R.drawable.phwe);
                text.setText("Pavilion 4 Entrance");
                break;
            case "MH1":
                //img1.setImageResource(R.drawable.pav1e);
                text.setText("Left Wing Entrance");
                break;
            case "MH2":
                //img1.setImageResource(R.drawable.pav1e);
                text.setText("Parking Lot Entrance");
                break;
            case "CE1": //ChemEngg back
                //img1.setImageResource(R.drawable.pav1e);
                text.setText("Back Entrance");
                break;
            case "Bio1":
                img1.setImageResource(R.drawable.pav1e);
                text.setText("Parking Lot Entrance");
                break;
            case "Civil1":
                //img1.setImageResource(R.drawable.pav1e);
                text.setText("Back Entrance");
                break;
            case "V1":
                //img1.setImageResource(R.drawable.pav1e);
                text.setText("Parking Lot Entrance");
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
        Intent intent2 = new Intent(this, activityMap.class);
        startActivity(intent2);
        overridePendingTransition(0, 0);
        finish();
    }
}
