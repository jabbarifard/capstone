package com.capstone // replace com.your-app-name with your app’s name
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import android.util.Log
import android.car.Car
import android.car.hardware.CarSensorManager

class AndroidAutoModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    @ReactMethod
    fun createHello(message: String) {
        Log.d("AndroidAutoModule", "Create event called: $message")
    }

    // add to CalendarModule.kt
    override fun getName() = "AndroidAutoModule"
}
















//    private fun watchSpeedSensor() {
//
//        val sensorManager = carContext.getCarManager(Car.SENSOR_SERVICE) as CarSensorManager
//
//        sensorManager.registerListener(
//            { carSensorEvent ->
//                Log.d("MainActivity", "Speed: ${carSensorEvent.floatValues[0]}") },
//            CarSensorManager.SENSOR_TYPE_CAR_SPEED,
//            CarSensorManager.SENSOR_RATE_NORMAL
//        )
//    }
//}
