package com.motion.muslimcollection.ui.maps

import android.Manifest

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.navigation.navArgs

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.motion.muslimcollection.R
import com.motion.muslimcollection.databinding.ActivityMapsBinding
import com.motion.muslimcollection.ui.mosque.mosques.MosqueViewModel
import org.koin.android.ext.android.inject

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    val args: MapsActivityArgs by navArgs()
    private val viewModel: MosqueViewModel by inject()
    private lateinit var binding: ActivityMapsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.maps_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initData(args.maps)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    fun initData(id:Int) {
        viewModel.getMosqueItem(id)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        viewModel.item.observe(this, Observer {
            it.data?.let {
                val zoomLevel = 20f
                googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                val homeLatLng = LatLng(it.latitude.toDouble(), it.longitude.toDouble())
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng, zoomLevel))
                googleMap.addMarker(MarkerOptions().position(homeLatLng))
                
            }
        })
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        googleMap.setMyLocationEnabled(true)
    }

}

