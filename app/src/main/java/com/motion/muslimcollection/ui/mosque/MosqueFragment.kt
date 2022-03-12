package com.motion.muslimcollection.ui.mosque

import android.content.pm.PackageManager
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseFragment
import com.motion.muslimcollection.ext.showMessage
import com.motion.muslimcollection.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_mosque.*
import java.util.jar.Manifest

class MosqueFragment : BaseFragment(R.layout.fragment_mosque) {
    override fun setupObservers() {
    }

    override fun showConnectedState() {
    }

    override fun setupUI() {
        super.setupUI()
        next()
    }

    fun next() {
        btn_madrasah.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_madrasahFragment)
        }
        btn_mosques_.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_mosquesFragment)
        }
        btn_room.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_roomFragment)
        }
        btn_college.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_mosqueCollegeFragment)
        }
        btn_library.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_libraryFragment)
        }
        btn_university.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_universityFragment)
        }
        btn_west.setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.action_mosqueFragment_to_mapsActivity)
        }
    }
    private fun chek() {
        Dexter.withContext(requireContext())
            .withPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                    context?.showMessage("LL")
                }
                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {

                }
                override fun onPermissionRationaleShouldBeShown(
                    p0: PermissionRequest?,
                    p1: PermissionToken?
                ) {
                    p1?.cancelPermissionRequest()
                }
            }).check()
    }
}
