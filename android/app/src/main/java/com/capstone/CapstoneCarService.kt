package com.capstone

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.ApplicationInfo
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.car.app.*
import androidx.car.app.hardware.CarHardwareManager
import androidx.car.app.hardware.common.CarValue
import androidx.car.app.hardware.common.OnCarDataAvailableListener
import androidx.car.app.hardware.info.CarSensors
import androidx.car.app.hardware.info.Compass
import androidx.car.app.model.*
import androidx.car.app.validation.HostValidator

class CapstoneCarService : CarAppService() {

    override fun onCreateSession(): Session {
        Log.d(TAG, "This is onCreateSession.")
        return CapstoneCarSession()
        return object : Session(){
            @RequiresApi(Build.VERSION_CODES.P)
            override fun onCreateScreen(intent: Intent): Screen {
                return CapstoneCarScreen(carContext)
            }
        }
    }

    override fun createHostValidator(): HostValidator {
        return if (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE !== 0) {
            HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
        } else {
            HostValidator.Builder(this)
                .addAllowedHosts(R.array.hosts_allowlist_sample)
                .build()
        }
    }
}












