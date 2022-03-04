package com.motion.muslimcollection.ui.mosque.mosques.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ui.mosque.mosque_madrasah.MadrasahViewModel
import com.motion.muslimcollection.ui.mosque.mosque_madrasah.maps.MadrasahMapsFragmentArgs
import com.motion.muslimcollection.ui.mosque.mosques.MosqueViewModel
import org.koin.android.ext.android.inject

class MosquesMapsFragment :  BaseFragment(R.layout.fragment_mosques_maps),OnMapReadyCallback {
    private val viewModel: MosqueViewModel by inject()
    val args: MosquesMapsFragmentArgs by navArgs()
    override fun onMapReady(googleMap: GoogleMap) {
        viewModel.item.observe(this, Observer {
            it.data?.let {
                val zoomLevel = 20f
                googleMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                val homeLatLng: LatLng
                try {
                    homeLatLng = LatLng(it.latitude.toDouble(), it.longitude.toDouble())
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng, zoomLevel))
                    googleMap.addMarker(MarkerOptions().position(homeLatLng).title(it.name))
                } catch (e :Exception){
                    context?.showMessage("error")
                }
            }
        })

    }
    override fun setupObservers() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map_ms) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun showConnectedState() {
        initData(args.msMaps)
    }
    private fun initData(id:Int) {
        viewModel.getMosqueItem(id)
    }
}