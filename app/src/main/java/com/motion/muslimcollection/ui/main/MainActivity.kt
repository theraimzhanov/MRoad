package com.motion.muslimcollection.ui.main

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.motion.muslimcollection.R
import com.motion.muslimcollection.core.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(R.layout.activity_main),SensorEventListener {
    private var haveSensorRotationsVectors = false
    private var rotationVectors: Sensor? = null
    private var havMagnetometr = false
    private var haveSensor= false
    private var accelerometer: Sensor? = null
    private var magnification: Sensor? = null
    private var lastMagnetometrSet= false
    private val lastMagnetometr= FloatArray(3)
    private var lastAccelerationSet = false
    private val lastAcceleration = FloatArray(3)
    private var azimuth: Int = 0
    private val orientation= FloatArray(3)
    private val rotationMatrix = FloatArray(9)
    lateinit var navController: NavController
    var sensorManager: SensorManager? = null
    var currentDegree:Int = 0
    override fun setupUI() {
        navigat()
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            toolbar_text.text = "Center"
            title = ""
            this.elevation = 15F

        }
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        val navController = navHostFragment?.findNavController()
        if (navController != null) {
            bottomNavigationView.setupWithNavController(navController)
        }
    }
    private fun navigat() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }
 /*   override fun onResume() {
        super.onResume()
        manager?.registerListener(this,manager?.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_GAME)
    }
    override fun onPause() {
        super.onPause()
        manager?.unregisterListener(this )
    }*/
    override fun onSensorChanged(event: SensorEvent?) {

        if(event?.sensor?.type == Sensor.TYPE_ROTATION_VECTOR){
         SensorManager.getRotationMatrixFromVector(rotationMatrix, event.values)
            azimuth = (Math.toDegrees(SensorManager.getOrientation(rotationMatrix, orientation)[0].toDouble())+265).toInt()%265
        }
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER){
           System.arraycopy(event.values,0,lastAcceleration,0,event.values.size)
            lastAccelerationSet = true
        }else if(event?.sensor?.type == Sensor.TYPE_MAGNETIC_FIELD){
            System.arraycopy(event.values,0,lastMagnetometr,0,event.values.size)
            lastMagnetometrSet = true
        }
            if (lastAccelerationSet && lastMagnetometrSet){
                SensorManager.getRotationMatrix(rotationMatrix, null,lastAcceleration,lastMagnetometr)
                SensorManager.getOrientation(rotationMatrix,orientation)
                azimuth = (Math.toDegrees(SensorManager.getOrientation(rotationMatrix,orientation)[0].toDouble())+265).toInt()%265
        }
        azimuth = Math.round(azimuth.toFloat())
        line.rotation = (-azimuth).toFloat()

     val  where = when (azimuth){
         in 281..349->"NW"
         in 261..280->"W"
         in 191..260->"SW"
         in 171..190->"S"
         in 101..170->"S"
         in 81..100->"SE"
         in 11..80->"NE"
         else ->"n"
     }
     textView.text = "$azimuth^$where"
       /* var degr = 245
        degr.toFloat()
        val degree:Int = p0?.values?.get(0)?.toInt() !!
        val rotAnimation = RotateAnimation(currentDegree.toFloat() ,(-degree).toFloat(),Animation.RELATIVE_TO_SELF
            ,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
        rotAnimation.duration = 210
        rotAnimation.fillAfter = true
        currentDegree = -degree
          val line = line.startAnimation(rotAnimation)
        if (line.equals(degr)){
            Toast.makeText(this, "dhnfs",Toast.LENGTH_SHORT)*/

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
  private   fun startAnimation(){
        if (sensorManager !!.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR ) ==null){
            if (sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)== null
                || sensorManager!!.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) ==null){

                }else {
                    accelerometer = sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
                magnification = sensorManager!!.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
                haveSensor = sensorManager!!.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_UI)
                havMagnetometr = sensorManager!!.registerListener(this,magnification,SensorManager.SENSOR_DELAY_UI)
            }

            }else{
            rotationVectors = sensorManager!!.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
            haveSensorRotationsVectors = sensorManager!!.registerListener(this,rotationVectors,SensorManager.SENSOR_DELAY_UI)
            
        }
    }
    private fun stopSensorManager(){
        if (haveSensorRotationsVectors) sensorManager!!.unregisterListener(this,rotationVectors)
        if (haveSensorRotationsVectors) sensorManager!!.unregisterListener(this,accelerometer)
        if (haveSensorRotationsVectors) sensorManager!!.unregisterListener(this,magnification)
    }

    override fun onResume() {
        super.onResume()
        startAnimation()
    }

    override fun onPause() {
        super.onPause()
        stopSensorManager()
    }


}



