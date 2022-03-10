package com.motion.muslimcollection.ui.mosque.location

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.motion.muslimcollection.R
import com.motion.muslimcollection.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private lateinit var mMap: GoogleMap
    private lateinit var lastLocation: Location
    private lateinit var binding: ActivityMapsBinding
    private lateinit var fusedLocationClients: FusedLocationProviderClient
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.map_loc) as SupportMapFragment
        mapFragment.getMapAsync(this)
        fusedLocationClients = LocationServices.getFusedLocationProviderClient(this)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnMarkerClickListener(this)
        setUpMap()
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }

        mMap.isMyLocationEnabled = true
        fusedLocationClients.lastLocation.addOnSuccessListener(this) { location ->
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                val a = 21.394954255772983
                val b = 39.8576207295903
                val mekke = LatLng(a, b)
                place(currentLatLng, mekke)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 12f))
                mMap.addPolyline(
                    PolylineOptions().add(currentLatLng, mekke).width(15f).color(R.color.color_line)
                        .geodesic(true)
                )
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mekke, 0f))
            }
        }
    }

    private fun place(currentLotLong: LatLng, mekke: LatLng) {
        val markerOptions = MarkerOptions().position(currentLotLong)
        val mm = MarkerOptions().position(mekke)
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        val userLoc = getString(R.string.user_loc)

        markerOptions.title("$userLoc")
        val name = "Мекка, Makkah Al-Mukarramah Саудовская Аравия"
        mm.title("$name")
        mMap.addMarker(markerOptions)
        mMap.addMarker(mm)
    }

    override fun onMarkerClick(p0: Marker) = false
}
