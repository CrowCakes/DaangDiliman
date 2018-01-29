package com.example.user.myapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
//import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class activityMoreInfo extends AppCompatActivity {

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;
    List<String> details = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitymaininfo);

        String bldg = getIntent().getStringExtra("EXTRA_SELECTED_DEST");

        switch (bldg) {
            case "PH":
                details.add("BUILDING ENTRANCE FEATURES");
                details.add("Main entrance has no ramps");
                details.add("Accessible entrances are on the west wing and at Pavilion 1");
                details.add("");
                details.add("BUILDING FEATURES");
                details.add("There are no elevators or ramps between floors");
                details.add("The west and east wings of each floor are elevated");
                break;
            case "MH":
                details.add("BUILDING ENTRANCE FEATURES");
                details.add("Main entrance has no ramps");
                details.add("Accessible entrances are on the west wing and in the parking lot at the back");
                details.add("");
                details.add("BUILDING FEATURES");
                details.add("The west and east wings of each floor are elevated");
                details.add("There is an elevator that serves each floor, but can only be used with staff permission");
                break;
            case "CHK":

                break;
            case "Arki":

                break;
            case "CAL":

                break;
            case "Edu":

                break;
            case "Law":

                break;
            case "MC":

                break;
            case "Music":

                break;
            case "CSL":

                break;
            case "CSWCD":

                break;
            case "CE":

                break;
            case "DCS":

                 break;

            case "Mine":

                break;
            case "Psych":

                break;
            case "FA":

                break;
            case "HE":

                break;
            case "Bio":

                break;
            case "Chem":

                break;
            case "Civil":

                break;
            case "EEE":

                break;
            case "Math":

                break;
            case "LawC":

                break;
            case "Lib":

                break;
            case "NCPAG":

                break;
            case "Geol":

                break;
            case "NIMBB":

                break;
            case "NIP":

                break;
            case "Econ":

                break;
            case "Stat":

                break;
            case "SURP":

                break;
            case "V":

                break;
            case "BA":

                break;
        }

        ListView mainListView = (ListView) findViewById( R.id.listview );
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, details);
        mainListView.setAdapter(adapter);

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFirstPage();
                finish();
            }
        });

        Button pics = (Button) findViewById(R.id.pics);
        pics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getIntent().getStringExtra("EXTRA_SELECTED_DEST");
                goToImages(s);
            }
        });

    }
    private void goToFirstPage() {
        Intent intent2 = new Intent(this, activityMap.class);
        startActivity(intent2);
        overridePendingTransition(0, 0);
        finish();
    }

    private void goToImages(String s) {
        //String s = getIntent().getStringExtra("EXTRA_SELECTED_DEST");
        String b = s;
        Intent intent3 = new Intent(this, entrance.class);
        intent3.putExtra("EXTRA_SELECTED_DEST", b);
        startActivity(intent3);
        overridePendingTransition(0, 0);
    }

}
