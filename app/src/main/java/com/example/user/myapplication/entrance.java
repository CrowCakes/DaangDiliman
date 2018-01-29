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
        //ImageView img2 = (ImageView) findViewById(R.id.im2);

        switch (bldg) {
            case "PH":
                img1.setImageResource(R.drawable.pav1e);
                //img2.setImageResource(R.drawable.phwe);
                break;
            case "MH":
                img1.setImageResource(R.drawable.pav1e);
                //img2.setImageResource(R.drawable.phwe);
                break;
            case "CHK":
                img1.setImageResource(R.drawable.chk);
                break;
            case "Arki":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "CAL":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "Edu":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "Law":
                img1.setImageResource(R.drawable.law);
                break;
            case "MC":
                img1.setImageResource(R.drawable.masscomm);
                break;
            case "Music":
                img1.setImageResource(R.drawable.music);
                break;
            case "CSL":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "CSWCD":
                img1.setImageResource(R.drawable.cswcd);
                break;
            case "CE":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "DCS":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "Mine":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "Psych":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "FA":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "HE":
                img1.setImageResource(R.drawable.he);
                break;
            case "Bio":
                //img1.setImageResource(R.drawable.);
                break;
            case "Chem":
                img1.setImageResource(R.drawable.chem);
                break;
            case "Civil":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "EEE":
                img1.setImageResource(R.drawable.eee);
                break;
            case "Math":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "LawC":
                img1.setImageResource(R.drawable.lawc);
                break;
            case "Lib":
                img1.setImageResource(R.drawable.lib);
                break;
            case "NCPAG":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "Geol":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "NIMBB":
                img1.setImageResource(R.drawable.nimbb);
                break;
            case "NIP":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "Econ":
                img1.setImageResource(R.drawable.econ1);
                break;
            case "Stat":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "SURP":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "V":
                //img1.setImageResource(R.drawable.pav1e);
                break;
            case "BA":
                img1.setImageResource(R.drawable.ba);
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
