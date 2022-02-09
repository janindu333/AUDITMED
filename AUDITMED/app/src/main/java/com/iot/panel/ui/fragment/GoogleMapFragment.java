package com.iot.panel.ui.fragment;

import android.os.Bundle;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.SupportActionModeWrapper;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.iot.panel.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.Getter;

public class GoogleMapFragment extends BaseFragment  {

    private View rootView;
    private static final long DEFAULT_LAT_LON_VALUE = -1000;

    private SupportMapFragment mapView;
    @Getter
    private GoogleMap map;
    private Marker mLocationMarker;
    private Polyline polyline;
    private List<Marker> markerList;
    private double destinationLat;
    private double destinationLon;
    private boolean shouldRouteDetailViewShow;
    private boolean isMapLoaded;
    private int mLocationUpdateCount;
    private Circle circle;
    static double currlat;
    static double currLon;

    String url1 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQeVhxiocTcYmfE_XkvMmf9LqbRCwo8TN8OmISBPo7IZu3Y29VHNFbKWBOLq51_5DrDio4&usqp=CAU";
    String url2 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQy3ANJ5-F-d-6i71Oz9TEsffGp2jt7Xxe9XXVy-qZ8U8Py1As8hcgDeEnIBdp2Kdk2xD0&usqp=CAU";
    String url3 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRuIjLiwJYwNR7yMD4h_atLisKban29J_7g770HUGh8eO3iYLyIP_Op25Ot5x9EHOEtEzE&usqp=CAU";

    LatLng uk = new LatLng(55.3781, 3.4360);
    LatLng poland = new LatLng(51.9194, 19.1451);
    LatLng ukraine = new LatLng(48.3794, 31.1656);

    private GoogleMap mMap;
    private ArrayList<LatLng> locationArrayList;

    public GoogleMapFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            rootView = inflater.inflate(R.layout.fragment_google_map, container, false);
            ButterKnife.bind(GoogleMapFragment.this, rootView);
            locationArrayList = new ArrayList<>();
            locationArrayList.add(uk);
            locationArrayList.add(poland);
            locationArrayList.add(ukraine);

            SupportMapFragment supportMapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map_view);

            supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(@NonNull GoogleMap googleMap) {
                    googleMap.setMapType(mMap.MAP_TYPE_SATELLITE);

                    googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                        @Override
                        public void onMapClick(@NonNull LatLng latLng) {
                           MarkerOptions markerOptions = new MarkerOptions();
                           markerOptions.position(latLng);
                           markerOptions.title("test");
                           googleMap.clear();
                            for (int i = 0; i < locationArrayList.size(); i++) {

                                // below line is use to add marker to each location of our array list.
                                if(i == 0){
                                    googleMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("uk"));
                                } else if(i == 1){
                                    googleMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("poland"));
                                } else {
                                    googleMap.addMarker(new MarkerOptions().position(locationArrayList.get(i)).title("ukraine"));
                                }
                                // below lin is use to zoom our camera on map.
                                //googleMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));
                                // below line is use to move our camera to the specific location.
                                googleMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList.get(i)));
                            }

                        }
                    });
                    googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(@NonNull Marker marker) {
                            String markerTitle = marker.getTitle();
                            return false;
                        }
                    });
                }
            });

        } catch (InflateException e) {
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map_view);
        if (mainActivity != null && isAdded()) {
            mainActivity.googleMapFragment = GoogleMapFragment.this;
        }
    }

    @Override
    public void setUpUI() {
        if (mainActivity != null && isAdded()) {

            updateUI();
        }
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    @Override
    protected void setUpToolBar() {
    }

    @Override
    public void enableView() {

    }


    @Override
    public void disableView() {

    }

}
