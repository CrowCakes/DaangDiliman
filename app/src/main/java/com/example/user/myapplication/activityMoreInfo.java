package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

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

        details.add("Main entrance has no ramps");
        details.add("Accessible entrances are on the west wing and at Pavilion 1");
        details.add("There are no elevators or ramps between floors");
        details.add("The west and east wings of each floor are elevated");

        ListView mainListView = (ListView) findViewById( R.id.listview );
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, details);
        mainListView.setAdapter(adapter);

        Button btn = (Button) findViewById(R.id.button2);
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
    }
}
