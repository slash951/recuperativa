package cl.ipvg.recuperativa;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import cl.ipvg.recuperativa.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    
    @Override

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Coordenadas de la ubicación deseada (Bulnes)
        LatLng bulnes = new LatLng(-34.74243, -72.29705);
        LatLng Bajon = new LatLng(-36.74344, -72.29647);
        LatLng Sushi = new LatLng(-36.74402, -72.29605);
        LatLng pizza = new LatLng(-36.74413, -72.29648);


        // Agregar marcador en la ubicación
        mMap.addMarker(new MarkerOptions().position(bulnes).title("Paradero"));
        mMap.addMarker(new MarkerOptions().position(Bajon).title("El Bajón"));
        mMap.addMarker(new MarkerOptions().position(Sushi).title("Evyta Sushi"));
        mMap.addMarker(new MarkerOptions().position(pizza).title("Pizzeria MammaMia"));


        // Mover la cámara a la ubicación con un nivel de zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bulnes, 15));
    }

}