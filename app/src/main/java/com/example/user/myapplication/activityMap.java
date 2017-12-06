/**
 * Created by user on 12/4/2017.
 */

package com.example.user.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.events.MapEventsReceiver;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.MapEventsOverlay;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.infowindow.InfoWindow;

public class activityMap extends AppCompatActivity implements MapEventsReceiver{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitymap);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Context ctx = getApplicationContext();
        //important! set your user agent to prevent getting banned from the osm servers
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        setContentView(R.layout.activity_activitymap);

        MapView map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);

        //map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        //map's center
        IMapController mapController = map.getController();
        mapController.setZoom(17);
        GeoPoint startPoint = new GeoPoint(14.6535,121.0674);
        mapController.setCenter(startPoint);

        MapEventsOverlay mapEventsOverlay = new MapEventsOverlay(ctx, this);
        map.getOverlays().add(0, mapEventsOverlay);

        //info window
        InfoWindow infoWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);
                
                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);

                txtTitle.setText("Palma Hall (PH)");
                txtDescription.setText("Not accessible");
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("PH");
                    }
                });
                /*
                btnMoreInfo.setVisibility(Button.VISIBLE);
                btnMoreInfo.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Implement onClick behaviour
                            goToPHPage();
                    }
                });*/
            }

            @Override
            public void onClose() {

            }
        };

        //info window
        InfoWindow MHWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Melchor Hall (MH)");
                txtDescription.setText("Accessible");
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("MH");
                    }
                });

                //btnMoreInfo.setVisibility(Button.VISIBLE);
                //btnMoreInfo.setOnClickListener(new View.OnClickListener() {
                //    public void onClick(View v) {
                //        // Implement onClick behaviour
                //            goToPHPage();
                //    }
                //});
            }

            @Override
            public void onClose() {

            }
        };

        //Palma Hall
        Marker PalmaHall = new Marker(map);
        GeoPoint PHPoint = new GeoPoint(14.65349,121.06970);
        PalmaHall.setPosition(PHPoint);
        PalmaHall.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(PalmaHall);
        PalmaHall.setInfoWindow(infoWindow);

        //Melchor Hall
        Marker MelchorHall = new Marker(map);
        GeoPoint MHPoint = new GeoPoint(14.65648,121.06966);
        MelchorHall.setPosition(MHPoint);
        MelchorHall.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(MelchorHall);
        MelchorHall.setInfoWindow(MHWindow);

        map.invalidate();

        //back button
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainPage();
            }
        });
    }

    @Override
    public boolean singleTapConfirmedHelper(GeoPoint p) {
        MapView map = (MapView) findViewById(R.id.map);
        InfoWindow.closeAllInfoWindowsOn(map);
        return true;
    }

    @Override public boolean longPressHelper(GeoPoint p) {
        //DO NOTHING FOR NOW:
        return false;
    }

    private void goToMainPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    //argument bldg stands for which bldg called this function
    private void goToPHPage(String bldg) {
        Intent intent = new Intent(this, activityMoreInfo.class);
        intent.putExtra("EXTRA_SELECTED_DEST", bldg);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void onResume(){
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
    }

    private void goToFirstPage() {
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
        overridePendingTransition(0, 0);
    }
}

