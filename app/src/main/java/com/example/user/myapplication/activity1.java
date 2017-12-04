/**
 * Created by user on 12/4/2017.
 */

package com.example.user.myapplication;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.Spinner;

public class activity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
        // For the route selection
        Spinner spinner = (Spinner) findViewById(R.id.build_spinner);
        Spinner spnner = (Spinner) findViewById(R.id.room_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.build_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adpter = ArrayAdapter.createFromResource(this,
                R.array.room_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spnner.setAdapter(adpter);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        spnner.setOnItemSelectedListener(this);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondPage();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainPage();
            }
        });


    // For the route selection
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String choice1 = preferences.getString("building","");
        String choice2 = preferences.getString("room","");
        if (!choice1.equalsIgnoreCase("") && !choice2.equalsIgnoreCase("")) {
            int spinnerPosition = adapter.getPosition(choice1);
            int spnnerPosition = adpter.getPosition(choice2);
            spinner.setSelection(spinnerPosition);
            spnner.setSelection(spnnerPosition);
        }
    }

    private void goToMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    private void goToSecondPage() {
        // For the route selection
        Spinner BSP = (Spinner)findViewById(R.id.build_spinner);
        Spinner RSP = (Spinner)findViewById(R.id.room_spinner);
        String txtBSP = BSP.getSelectedItem().toString();
        String txtRSP = RSP.getSelectedItem().toString();
        Button button = (Button)findViewById(R.id.button);
        String button_name = button.getText().toString();


        Intent intent = new Intent(this, activity2.class);
        intent.putExtra("EXTRA_SELECTED_DEST", (txtBSP.concat(" ".concat(txtRSP))).concat(", ".concat(button_name)) );
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    // For the route selection
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        Spinner BSP = (Spinner)findViewById(R.id.build_spinner);
        Spinner RSP = (Spinner)findViewById(R.id.room_spinner);
        String txtBSP = BSP.getSelectedItem().toString();
        String txtRSP = RSP.getSelectedItem().toString();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("building",txtBSP);
        editor.apply();
        editor.putString("room",txtRSP);
        editor.apply();

        if (txtBSP != null && txtRSP != null) {
            View b = findViewById(R.id.button);
            b.setVisibility(View.VISIBLE);
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
        View b = findViewById(R.id.button);
        b.setVisibility(View.INVISIBLE);
    }

}
