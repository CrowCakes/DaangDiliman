package com.example.user.myapplication;

//import android.content.SharedPreferences;
//import android.preference.PreferenceManager;
import android.content.Context;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
//import android.widget.Spinner;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* For the route selection
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
        */

        Context ctx = getApplicationContext();
        //important! set your user agent to prevent getting banned from the osm servers
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        setContentView(R.layout.activity_main);

        MapView map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);

        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
    /* For the route selection
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String choice1 = preferences.getString("building","");
        String choice2 = preferences.getString("room","");
        if (!choice1.equalsIgnoreCase("") && !choice2.equalsIgnoreCase("")) {
            int spinnerPosition = adapter.getPosition(choice1);
            int spnnerPosition = adpter.getPosition(choice2);
            spinner.setSelection(spinnerPosition);
            spnner.setSelection(spnnerPosition);
        }
    */
    }

    public void onResume(){
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
    }

    private void goToSecondPage() {
        /* For the route selection
        Spinner BSP = (Spinner)findViewById(R.id.build_spinner);
        Spinner RSP = (Spinner)findViewById(R.id.room_spinner);
        String txtBSP = BSP.getSelectedItem().toString();
        String txtRSP = RSP.getSelectedItem().toString();
        Button button = (Button)findViewById(R.id.button);
        String button_name = button.getText().toString();
        */

        Intent intent = new Intent(this, activity2.class);
        //intent.putExtra("EXTRA_SELECTED_DEST", (txtBSP.concat(" ".concat(txtRSP))).concat(", ".concat(button_name)) );
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    /* For the route selection
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
    */
}
