package com.capstone

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.hardware.CarHardwareManager
import androidx.car.app.hardware.common.CarValue
import androidx.car.app.hardware.common.OnCarDataAvailableListener
import androidx.car.app.hardware.info.CarSensors
import androidx.car.app.hardware.info.Compass
import androidx.car.app.model.*

//import androidx.car.app.notification.CarAppExtender
//import androidx.core.app.NotificationCompat
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@RequiresApi(Build.VERSION_CODES.P)
class CapstoneCarScreen(carContext: CarContext) : Screen(carContext) {
    override fun onGetTemplate(): Template {
        val row = Row.Builder().setTitle("Hello world!").build()
        val pane = Pane.Builder().addRow(row).build()
        return PaneTemplate.Builder(pane)
            .setHeaderAction(Action.APP_ICON)
            .build()
    }

    private val carSensors = carContext.getCarService(CarHardwareManager::class.java).carSensors

    private val listener = OnCarDataAvailableListener<Compass> { data ->
        if (data.orientations.status == CarValue.STATUS_SUCCESS) {
            val orientation = data.orientations.value
            Log.d(TAG, "onGetTemplate: Compass status = $orientation")
        } else {
            // Data not available, handle error
        }
    }

    init {
        carSensors.addCompassListener(
            CarSensors.UPDATE_RATE_NORMAL,
            carContext.mainExecutor,
            listener
        )
    }
}


