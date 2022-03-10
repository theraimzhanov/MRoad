package com.motion.muslimcollection.ui.mosque.location

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.motion.muslimcollection.R
import com.motion.muslimcollection.databinding.ActivityMapsIntentBinding
import com.motion.muslimcollection.ext.showMessage

class MapsIntentActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsIntentBinding

    companion object {
        private const val EXTRA_LOCATION_NAME = "location_name"
        private const val EXTRA_LOCATION_LATITUDE = "location_latitude"
        private const val EXTRA_LOCATION_LONGITUDE = "location_longitude"
        private const val DEFAULT_LOCATION1 = 41.49794
        private const val DEFAULT_LOCATION2 = 74.42994
        fun getLocationIntent(
            context: Context,
            name: String,
            latitude: String,
            longitude: String
        ): Intent {
            val intent = Intent(context, MapsIntentActivity::class.java)
            val latitudeL = parseLatitude(context, latitude)
            val longitudeL = parseLongitudel(context, longitude)
            intent.putExtra(EXTRA_LOCATION_NAME, name)
            intent.putExtra(EXTRA_LOCATION_LATITUDE, latitudeL)
            intent.putExtra(EXTRA_LOCATION_LONGITUDE, longitudeL)
            return intent
        }

        fun parseLatitude(context: Context, number: String): Double? {
            var result: Double?
            try {
                result = number.toDouble()
            } catch (e: NumberFormatException) {
                context.showMessage("no found")
                result = DEFAULT_LOCATION1
            }
            return result
        }

        fun parseLongitudel(context: Context, number: String): Double? {
            var result: Double?
            try {
                result = number.toDouble()
            } catch (e: NumberFormatException) {
                context.showMessage(context.getString(R.string.NoFound))
                result = DEFAULT_LOCATION2
            }
            return result
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map_intent) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun parseIntent() {
        if (!intent.hasExtra(EXTRA_LOCATION_NAME)) {
            throw RuntimeException("Error")
        }
        if (!intent.hasExtra(EXTRA_LOCATION_LATITUDE)) {
            throw RuntimeException("Error")
        }
        if (!intent.hasExtra(EXTRA_LOCATION_LONGITUDE)) {
            throw RuntimeException("Error")
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        parseIntent()
        val name = intent.getStringExtra(EXTRA_LOCATION_NAME)
        val latitude = intent.getDoubleExtra(EXTRA_LOCATION_LATITUDE, DEFAULT_LOCATION1)
        val longitude = intent.getDoubleExtra(EXTRA_LOCATION_LONGITUDE, DEFAULT_LOCATION2)
        try {
            val sydney = LatLng(latitude, longitude)

            mMap.addMarker(MarkerOptions().position(sydney).title(name))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16f))
        } catch (e: Exception) {
            this.showMessage("Не найденно")
        }

    }
}