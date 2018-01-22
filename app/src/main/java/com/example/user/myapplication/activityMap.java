/**
 * Created by user on 12/4/2017.
 */

package com.example.user.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
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

        //PH info window
        InfoWindow infoWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -1.35";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);
                
                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);

                txtTitle.setText("Palma Hall (PH), College of Science and Philosophy");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
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

        InfoWindow PH1Window = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                /*
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -1.35";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);
                */

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);

                txtTitle.setText("West Entrance to PH");
                txtDescription.setText("Facing College of Arts and Letters (CAL)");
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToEntrancePage("PH1");
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

        InfoWindow PH2Window = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                /*
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -1.35";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);
                */

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);

                txtTitle.setText("Southern Entrance to PH");
                txtDescription.setText("Enters directly to PH Pavilion 1");
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToEntrancePage("PH2");
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

        InfoWindow PH3Window = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                /*
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -1.35";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);
                */

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);

                txtTitle.setText("East Entrance to PH");
                txtDescription.setText("Facing PH Annex (PHAN)");
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToEntrancePage("PH3");
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

        //MH info window
        InfoWindow MHWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: 0.72";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.BLUE), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Melchor Hall (MH), College of Engineering");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
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

        InfoWindow MH1Window = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                /*
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -1.35";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);
                */

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);

                txtTitle.setText("Left Wing Entrance to MH");
                txtDescription.setText("Across Eng'g Tennis Court");
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToEntrancePage("MH1");
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

        InfoWindow MH2Window = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                /*
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -1.35";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);
                */

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                //TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);

                txtTitle.setText("Parking Lot Entrance of MH");
                //txtDescription.setText("");
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToEntrancePage("MH2");
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

        //CHK info window
        InfoWindow CHKWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.28";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Ylanan Hall/UP Gym, College of Human Kinetics");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("CHK");
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

        //Arki info window
        InfoWindow ArkiWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: 0.23";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.BLUE), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("College of Architecture (Arki)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Arki");
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

        //CAL info
        InfoWindow CALWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.12";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("College of Arts and Letters (CAL)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("CAL");
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

        //Edu info
        InfoWindow EduWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.54";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Benitez Hall (BH), College of Education");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Edu");
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

        //Law info
        InfoWindow LawWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.58";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Malcolm Hall (LAW), College of Law");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Law");
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

        //MassComm info
        InfoWindow MCWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.70";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Plaridel Hall (MCB), College of Mass Communication");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("MC");
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

        //Music info
        InfoWindow MusicWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.40";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Abelardo Hall (AH), College of Music");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Music");
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

        //CSLib info
        InfoWindow CSLWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.68";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("College of Science Library (CS)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("CSL");
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

        //CSWCD info
        InfoWindow CSWCDWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: 1.23";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.BLUE), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Melchora Aquino Hall (CSWCD), College of Social Work and Community Development");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("CSWCD");
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

        //ChemEngg info
        InfoWindow CEWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.58";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Department of Chemical Engineering (ChE)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("CE");
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
        //CE1 info
        InfoWindow CE1Window = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                /*
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.58";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);*/

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                //TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Back Entrance to DChE");
                //txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToEntrancePage("CE1");;
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

        //DCS info
        InfoWindow DCSWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.40";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Alumni Engineering Centennial Hall (AECH), Department of Computer Science");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("DCS");
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

        //Mine info
        InfoWindow MineWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.65";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Department of Mining Metallurgical and Materials Engineering (DMMME)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Mine");
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

        //Psych info
        InfoWindow PsychWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.77";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Lagmay Hall (LH), Department of Psychology");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Psych");
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

        //FA info
        InfoWindow FAWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.51";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Bartlett Hall (FA), College of Fine Arts");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("FA");
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

        //HomeEcon info
        InfoWindow HEWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.54";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Alonso Hall (ALON), College of Home Economics");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("HE");
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

        //Bio info
        InfoWindow BioWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.19";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Institute of Biology (IB)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Bio");
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
        //Bio1 info
        InfoWindow Bio1Window = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {/*
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.19";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);*/

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                //TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Parking Lot entrance to IB");
                //txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToEntrancePage("Bio1");
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

        //Chem info
        InfoWindow ChemWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.19";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Institute of Chemistry (IC)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Chem");
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

        //CivilEngg info
        InfoWindow CivilWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: 1.53";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.BLUE), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Institute of Civil Engineering (ICE)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Civil");
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
        //Back
        InfoWindow Civil1Window = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {/*
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: 1.53";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.BLUE), 22, sample.length(), 0);
                builder.append(rating);*/

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                //TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Back Entrance to ICE");
                //txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToEntrancePage("Civil1");
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

        //EEE info
        InfoWindow EEEWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.67";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Institute of Electrical and Electronics Engineering (IEEE)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("EEE");
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

        //Math info
        InfoWindow MathWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: 0.08";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.BLUE), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Institute of Mathematics (MB)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Math");
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

        //Law Center info
        InfoWindow LawCWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibil ity rating: 1.01";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.BLUE), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Bocobo Hall, Law Center");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("LawC");
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

        //MainLib info
        InfoWindow LibWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.35";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Gonzales Hall, Main/University Library");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Lib");
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

        //NCPAG info
        InfoWindow NCPAGWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.63";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("National College of Public Administration and Governance (NCPAG)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("NCPAG");
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

        //Geol info
        InfoWindow GeolWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: 0.18";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.BLUE), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("National Institute of Geological Sciences (NIGS)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Geol");
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

        //NIMBB info
        InfoWindow NIMBBWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.20";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("National Institute of Molecular Biology and Biotechnology (NIMBB)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("NIMBB");
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

        //Physics info
        InfoWindow NIPWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.38";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("National Institute of Physics (NIP)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("NIP");
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

        //Econ info
        InfoWindow EconWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.52";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Encarnacion Hall (SE), School of Economics");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Econ");
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

        //Stat info
        InfoWindow StatWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.53";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("School of Statistics (Stat)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Stat");
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

        //SURP info
        InfoWindow SURPWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.73";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("School of Urban and Regional Planning (SURP)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("SURP");
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

        //Film info
        InfoWindow FilmWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.39";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("UP Film Institute (UPFI)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("Film");
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

        //Vanguard info
        InfoWindow VWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.12";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Vanguard Building (V)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("V");
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
        //Parking
        InfoWindow V1Window = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {/*
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: 1.53";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.BLUE), 22, sample.length(), 0);
                builder.append(rating);*/

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                //TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Parking Lot entrance to V");
                //txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToEntrancePage("V1");
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

        //Business info
        InfoWindow BAWindow = new InfoWindow(R.layout.bonuspack_bubble, map) {
            @Override
            public void onOpen(Object item) {
                SpannableStringBuilder builder = new SpannableStringBuilder();
                String sample = "Accessibility rating: -0.12";
                SpannableString rating = new SpannableString(sample);
                rating.setSpan(new ForegroundColorSpan(Color.RED), 22, sample.length(), 0);
                builder.append(rating);

                MapView map = (MapView) findViewById(R.id.map);
                InfoWindow.closeAllInfoWindowsOn(map);

                LinearLayout layout = (LinearLayout) mView.findViewById(R.id.bubble_layout);
                TextView txtTitle = (TextView) mView.findViewById(R.id.bubble_title);
                TextView txtDescription = (TextView) mView.findViewById(R.id.bubble_description);
                //Button btnMoreInfo = (Button) mView.findViewById(R.id.bubble_moreinfo);
                //TextView txtSubdescription = (TextView) mView.findViewById(R.id.bubble_subdescription);

                txtTitle.setText("Cesar E.A. Virata School of Business (BA)");
                txtDescription.setText(builder, TextView.BufferType.SPANNABLE);
                layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        // Override Marker's onClick behaviour here
                        goToPHPage("BA");
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
        //..........................................//

        //Palma Hall
        Marker PalmaHall = new Marker(map);
        GeoPoint PHPoint = new GeoPoint(14.65349,121.06970);
        PalmaHall.setPosition(PHPoint);
        PalmaHall.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(PalmaHall);
        PalmaHall.setInfoWindow(infoWindow);
        //CAL-side
        Marker PH1 = new Marker(map);
        GeoPoint PH1Point = new GeoPoint(14.6535081,121.0688995);
        PH1.setPosition(PH1Point);
        PH1.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        PH1.setIcon(getResources().getDrawable(R.drawable.ic_accessible_black_24dp));
        map.getOverlays().add(PH1);
        PH1.setInfoWindow(PH1Window);
        //Pav1
        Marker PH2 = new Marker(map);
        GeoPoint PH2Point = new GeoPoint(14.6525877,121.0688380);
        PH2.setPosition(PH2Point);
        PH2.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        PH2.setIcon(getResources().getDrawable(R.drawable.ic_accessible_black_24dp));
        map.getOverlays().add(PH2);
        PH2.setInfoWindow(PH2Window);
        //Pav4
        Marker PH3 = new Marker(map);
        GeoPoint PH3Point = new GeoPoint(14.6531707,121.0705906);
        PH3.setPosition(PH3Point);
        PH3.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        PH3.setIcon(getResources().getDrawable(R.drawable.ic_accessible_black_24dp));
        map.getOverlays().add(PH3);
        PH3.setInfoWindow(PH3Window);

        //Melchor Hall
        Marker MelchorHall = new Marker(map);
        GeoPoint MHPoint = new GeoPoint(14.65648,121.06966);
        MelchorHall.setPosition(MHPoint);
        MelchorHall.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(MelchorHall);
        MelchorHall.setInfoWindow(MHWindow);
        //Left Wing
        Marker MH1 = new Marker(map);
        GeoPoint MH1Point = new GeoPoint(14.6564462,121.0688224);
        MH1.setPosition(MH1Point);
        MH1.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        MH1.setIcon(getResources().getDrawable(R.drawable.ic_accessible_black_24dp));
        map.getOverlays().add(MH1);
        MH1.setInfoWindow(MH1Window);
        //Parking Lot
        Marker MH2 = new Marker(map);
        GeoPoint MH2Point = new GeoPoint(14.6565792,121.0695234);
        MH2.setPosition(MH2Point);
        MH2.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        MH2.setIcon(getResources().getDrawable(R.drawable.ic_accessible_black_24dp));
        map.getOverlays().add(MH2);
        MH2.setInfoWindow(MH2Window);

        //CHK
        Marker CHK = new Marker(map);
        GeoPoint CHKPoint = new GeoPoint(14.6590431,121.0624862);
        CHK.setPosition(CHKPoint);
        CHK.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(CHK);
        CHK.setInfoWindow(CHKWindow);

        //Arki
        Marker Arki = new Marker(map);
        GeoPoint ArkiPoint = new GeoPoint(14.6510167,121.0655638);
        Arki.setPosition(ArkiPoint);
        Arki.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Arki);
        Arki.setInfoWindow(ArkiWindow);

        //CAL
        Marker CAL = new Marker(map);
        GeoPoint CALPoint = new GeoPoint(14.6528399,121.0673767);
        CAL.setPosition(CALPoint);
        CAL.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(CAL);
        CAL.setInfoWindow(CALWindow);

        //Edu
        Marker Edu = new Marker(map);
        GeoPoint EduPoint = new GeoPoint(14.6536275,121.0721916);
        Edu.setPosition(EduPoint);
        Edu.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Edu);
        Edu.setInfoWindow(EduWindow);

        //Law
        Marker Law = new Marker(map);
        GeoPoint LawPoint = new GeoPoint(14.6564333,121.0720798);
        Law.setPosition(LawPoint);
        Law.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Law);
        Law.setInfoWindow(LawWindow);

        //MassComm
        Marker MC = new Marker(map);
        GeoPoint MCPoint = new GeoPoint(14.6565510,121.0644204);
        MC.setPosition(MCPoint);
        MC.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(MC);
        MC.setInfoWindow(MCWindow);

        //Music
        Marker Music = new Marker(map);
        GeoPoint MusicPoint = new GeoPoint(14.6565086,121.0654349);
        Music.setPosition(MusicPoint);
        Music.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Music);
        Music.setInfoWindow(MusicWindow);

        //CSLibrary
        Marker CSL = new Marker(map);
        GeoPoint CSLPoint = new GeoPoint(14.6492411,121.0691929);
        CSL.setPosition(CSLPoint);
        CSL.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(CSL);
        CSL.setInfoWindow(CSLWindow);

        //CSWCD
        Marker CSWCD = new Marker(map);
        GeoPoint CSWCDPoint = new GeoPoint(14.6571362,121.0636141);
        CSWCD.setPosition(CSWCDPoint);
        CSWCD.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(CSWCD);
        CSWCD.setInfoWindow(CSWCDWindow);

        //ChemEngg
        Marker CE = new Marker(map);
        GeoPoint CEPoint = new GeoPoint(14.6480529,121.0669295);
        CE.setPosition(CEPoint);
        CE.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(CE);
        CE.setInfoWindow(CEWindow);
        //Back
        Marker CE1 = new Marker(map);
        GeoPoint CE1Point = new GeoPoint(14.6482010,121.067003);
        CE1.setPosition(CE1Point);
        CE1.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        CE1.setIcon(getResources().getDrawable(R.drawable.ic_accessible_black_24dp));
        map.getOverlays().add(CE1);
        CE1.setInfoWindow(CE1Window);

        //DCS
        Marker DCS = new Marker(map);
        GeoPoint DCSPoint = new GeoPoint(14.6486574,121.0686573);
        DCS.setPosition(DCSPoint);
        DCS.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(DCS);
        DCS.setInfoWindow(DCSWindow);

        //Mining
        Marker Mine = new Marker(map);
        GeoPoint MinePoint = new GeoPoint(14.6482776,121.0681096);
        Mine.setPosition(MinePoint);
        Mine.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Mine);
        Mine.setInfoWindow(MineWindow);

        //Psych
        Marker Psych = new Marker(map);
        GeoPoint PsychPoint = new GeoPoint(14.6536141,121.0713047);
        Psych.setPosition(PsychPoint);
        Psych.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Psych);
        Psych.setInfoWindow(PsychWindow);

        //FA
        Marker FA = new Marker(map);
        GeoPoint FAPoint = new GeoPoint(14.6522542,121.0620108);
        FA.setPosition(FAPoint);
        FA.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(FA);
        FA.setInfoWindow(FAWindow);

        //HomeEcon
        Marker HE = new Marker(map);
        GeoPoint HEPoint = new GeoPoint(14.6523121,121.0732541);
        HE.setPosition(HEPoint);
        HE.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(HE);
        HE.setInfoWindow(HEWindow);

        //Bio
        Marker Bio = new Marker(map);
        GeoPoint BioPoint = new GeoPoint(14.6504826,121.0706753);
        Bio.setPosition(BioPoint);
        Bio.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Bio);
        Bio.setInfoWindow(BioWindow);
        //Parking
        Marker Bio1 = new Marker(map);
        GeoPoint Bio1Point = new GeoPoint(14.6508784,121.0710165);
        Bio1.setPosition(Bio1Point);
        Bio1.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        Bio1.setIcon(getResources().getDrawable(R.drawable.ic_accessible_black_24dp));
        map.getOverlays().add(Bio1);
        Bio1.setInfoWindow(Bio1Window);

        //Chem
        Marker Chem = new Marker(map);
        GeoPoint ChemPoint = new GeoPoint(14.6502979,121.0728018);
        Chem.setPosition(ChemPoint);
        Chem.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Chem);
        Chem.setInfoWindow(ChemWindow);

        //CivilEngg
        Marker Civil = new Marker(map);
        GeoPoint CivilPoint = new GeoPoint(14.6485715,121.0659663);
        Civil.setPosition(CivilPoint);
        Civil.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Civil);
        Civil.setInfoWindow(CivilWindow);
        //Back
        Marker Civil1 = new Marker(map);
        GeoPoint Civil1Point = new GeoPoint(14.6485545,121.0663435);
        Civil1.setPosition(Civil1Point);
        Civil1.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        Civil1.setIcon(getResources().getDrawable(R.drawable.ic_accessible_black_24dp));
        map.getOverlays().add(Civil1);
        Civil1.setInfoWindow(Civil1Window);

        //EEE
        Marker EEE = new Marker(map);
        GeoPoint EEEPoint = new GeoPoint(14.6496902,121.0682031);
        EEE.setPosition(EEEPoint);
        EEE.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(EEE);
        EEE.setInfoWindow(EEEWindow);

        //Math
        Marker Math = new Marker(map);
        GeoPoint MathPoint = new GeoPoint(14.6483747,121.0712139);
        Math.setPosition(MathPoint);
        Math.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Math);
        Math.setInfoWindow(MathWindow);

        //Law Center
        Marker LawC = new Marker(map);
        GeoPoint LawCPoint = new GeoPoint(14.6572080,121.0721295);
        LawC.setPosition(LawCPoint);
        LawC.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(LawC);
        LawC.setInfoWindow(LawCWindow);

        //MainLib
        Marker Lib = new Marker(map);
        GeoPoint LibPoint = new GeoPoint(14.6550093,121.0708898);
        Lib.setPosition(LibPoint);
        Lib.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Lib);
        Lib.setInfoWindow(LibWindow);

        //NCPAG
        Marker NCPAG = new Marker(map);
        GeoPoint NCPAGPoint = new GeoPoint(14.6565034,121.0606137);
        NCPAG.setPosition(NCPAGPoint);
        NCPAG.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(NCPAG);
        NCPAG.setInfoWindow(NCPAGWindow);

        //Geol
        Marker Geol = new Marker(map);
        GeoPoint GeolPoint = new GeoPoint(14.6483131,121.0694578);
        Geol.setPosition(GeolPoint);
        Geol.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Geol);
        Geol.setInfoWindow(GeolWindow);

        //NIMBB
        Marker NIMBB = new Marker(map);
        GeoPoint NIMBBPoint = new GeoPoint(14.6506183,121.0717023);
        NIMBB.setPosition(NIMBBPoint);
        NIMBB.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(NIMBB);
        NIMBB.setInfoWindow(NIMBBWindow);

        //Physics
        Marker NIP = new Marker(map);
        GeoPoint NIPPoint = new GeoPoint(14.6493239,121.0730182);
        NIP.setPosition(NIPPoint);
        NIP.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(NIP);
        NIP.setInfoWindow(NIPWindow);

        //Econ
        Marker Econ = new Marker(map);
        GeoPoint EconPoint = new GeoPoint(14.6559229,121.0734854);
        Econ.setPosition(EconPoint);
        Econ.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Econ);
        Econ.setInfoWindow(EconWindow);

        //Stat
        Marker Stat = new Marker(map);
        GeoPoint StatPoint = new GeoPoint(14.6512251,121.0675457);
        Stat.setPosition(StatPoint);
        Stat.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Stat);
        Stat.setInfoWindow(StatWindow);

        //SURP
        Marker SURP = new Marker(map);
        GeoPoint SURPPoint = new GeoPoint(14.6568746,121.0628476);
        SURP.setPosition(SURPPoint);
        SURP.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(SURP);
        SURP.setInfoWindow(SURPWindow);

        //Film
        Marker Film = new Marker(map);
        GeoPoint FilmPoint = new GeoPoint(14.6563252,121.0633143);
        Film.setPosition(FilmPoint);
        Film.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(Film);
        Film.setInfoWindow(FilmWindow);

        //Vanguard
        Marker V = new Marker(map);
        GeoPoint VPoint = new GeoPoint(14.6588935,121.0642223);
        V.setPosition(VPoint);
        V.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(V);
        V.setInfoWindow(VWindow);
        //Back
        Marker V1 = new Marker(map);
        GeoPoint V1Point = new GeoPoint(14.6587647,121.0642231);
        V1.setPosition(V1Point);
        V1.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        V1.setIcon(getResources().getDrawable(R.drawable.ic_accessible_black_24dp));
        map.getOverlays().add(V1);
        V1.setInfoWindow(V1Window);

        //Business Ad
        Marker BA = new Marker(map);
        GeoPoint BAPoint = new GeoPoint(14.6552587,121.0732459);
        BA.setPosition(BAPoint);
        BA.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(BA);
        BA.setInfoWindow(BAWindow);

        map.invalidate();

        //back button
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainPage();
                finish();
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
        finish();
    }

    //argument bldg stands for which bldg called this function
    private void goToPHPage(String bldg) {
        Intent intent = new Intent(this, activityMoreInfo.class);
        intent.putExtra("EXTRA_SELECTED_DEST", bldg);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }

    private void goToEntrancePage(String bldg) {
        Intent intent = new Intent(this, activityEntrancePicture.class);
        intent.putExtra("EXTRA_SELECTED_DEST", bldg);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }

    public void onResume(){
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
    }
}

