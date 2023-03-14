package com.capstone

import android.car.Car
import android.content.ContentValues
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.car.app.CarContext
import androidx.car.app.hardware.CarHardwareManager
import androidx.car.app.hardware.common.CarValue
import androidx.car.app.hardware.common.OnCarDataAvailableListener
import androidx.car.app.hardware.info.CarSensors
import androidx.car.app.hardware.info.Compass
import com.facebook.react.ReactActivity
import com.facebook.react.ReactActivityDelegate
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.concurrentReactEnabled
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.fabricEnabled
import com.facebook.react.defaults.DefaultReactActivityDelegate

class MainActivity : ReactActivity() {
    /**
     * Returns the name of the main component registered from JavaScript. This is used to schedule
     * rendering of the component.
     */
    override fun getMainComponentName(): String? {
        return "capstone"
    }

    /**
     * Returns the instance of the [ReactActivityDelegate]. Here we use a util class [ ] which allows you to easily enable Fabric and Concurrent React
     * (aka React 18) with two boolean flags.
     */
    override fun createReactActivityDelegate(): ReactActivityDelegate {
        return DefaultReactActivityDelegate(
            this,
            mainComponentName!!,  // If you opted-in for the New Architecture, we enable the Fabric Renderer.
            fabricEnabled,  // fabricEnabled
            // If you opted-in for the New Architecture, we enable Concurrent React (i.e. React 18).
            concurrentReactEnabled // concurrentRootEnabled
        )
    }

    private lateinit var carContext: CarContext

    @RequiresApi(Build.VERSION_CODES.P)
    private fun watchSpeedSensor() {
        val carSensors = carContext.getCarService(CarHardwareManager::class.java).carSensors

        val listener = OnCarDataAvailableListener<Compass> { data ->
            if (data.orientations.status == CarValue.STATUS_SUCCESS) {
                val orientation = data.orientations.value
                Log.d(ContentValues.TAG, "onGetTemplate: Compass status = $orientation")
            } else {
                // Data not available, handle error
            }
        }
        carSensors.addCompassListener(
            CarSensors.UPDATE_RATE_NORMAL,
            carContext.mainExecutor,
            listener
        )

    }
}














