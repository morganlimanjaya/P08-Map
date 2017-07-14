package sg.edu.rp.c347.p08_map;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    private GoogleMap map;

    //spinners object
    Spinner spinner;
    ArrayAdapter<String> aa;
    ArrayList<String> areas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinnerList);

        //spinners elements
        areas = new ArrayList<String>();
        areas.add(new String("NORTH"));
        areas.add(new String("CENTRAL"));
        areas.add(new String("EAST"));

        //set adapter
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, areas);
        spinner.setAdapter(aa);

        //locations
        final LatLng north_hq = new LatLng(1.4582775898253464, 103.79470825195312);
        final LatLng central_hq = new LatLng(1.3041705098113472, 103.83187294006348);
        final LatLng east_hq = new LatLng(1.3565989220863888, 103.9500617980957);


        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                //set some controls on the map by calling some methods.
                UiSettings ui = map.getUiSettings();
                //compass
                ui.setCompassEnabled(true);
                //zoom control
                ui.setZoomControlsEnabled(true);

                //show current location on map
                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                }

            }
        });

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //placing markers on maps
                LatLng NORTH_HQ = new LatLng(1.4582775898253464, 103.79470825195312);
                Marker cp = map.addMarker(new
                        MarkerOptions()
                        .position(NORTH_HQ)
                        .title("North - HQ")
                        .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm\n" +
                                "Tel:65433456\n")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));

                //Build camera position
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(NORTH_HQ)
                        .zoom(17).build();
                //Zoom in and animate the camera.
                map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                //Show Toast when snippet is clicked
                map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

                    @Override
                    public void onInfoWindowClick(Marker arg0) {
                        // TODO Auto-generated method stub

                        Toast.makeText(getApplicationContext(), "North - HQ",  Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //placing markers on maps
                LatLng CENTRAL_HQ = new LatLng(1.3041705098113472, 103.83187294006348);
                Marker cp = map.addMarker(new
                        MarkerOptions()
                        .position(CENTRAL_HQ)
                        .title("Central - HQ")
                        .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                "Operating hours: 11am-8pm\n" +
                                "Tel:67788652\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                //Build camera position
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(CENTRAL_HQ)
                        .zoom(17).build();
                //Zoom in and animate the camera.
                map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                //Show Toast when snippet is clicked
                map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

                    @Override
                    public void onInfoWindowClick(Marker arg0) {
                        // TODO Auto-generated method stub

                        Toast.makeText(getApplicationContext(), "Central - HQ",  Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //placing markers on maps
                LatLng EAST_HQ = new LatLng(1.3565989220863888, 103.9500617980957);
                Marker cp = map.addMarker(new
                        MarkerOptions()
                        .position(EAST_HQ)
                        .title("EAST - HQ")
                        .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                "Operating hours: 9am-5pm\n" +
                                "Tel:66776677\"\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

                //Build camera position
                CameraPosition cameraPosition = new CameraPosition.Builder()
                        .target(EAST_HQ)
                        .zoom(17).build();
                //Zoom in and animate the camera.
                map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                //Show Toast when snippet is clicked
                map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

                    @Override
                    public void onInfoWindowClick(Marker arg0) {
                        // TODO Auto-generated method stub

                        Toast.makeText(getApplicationContext(), "EAST - HQ",  Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

        //modify the MapDemo app to zoom to Singapore
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                LatLng sg = new LatLng(1.3521, 103.8198);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(sg,
                        15));
            }
        });

        //spinners
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String getArea = spinner.getItemAtPosition(position).toString();
                if (getArea.equals("NORTH") && map != null) {
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(north_hq, 15));

                } else if (getArea.equals("CENTRAL") && map != null) {
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(central_hq, 15));


                } else if (getArea.equals("EAST") && map != null) {
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(east_hq, 15));

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }
}
