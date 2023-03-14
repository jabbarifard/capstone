package com.capstone

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.car.app.Screen
import androidx.car.app.Session

class CapstoneCarSession : Session() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreateScreen (intent: Intent): Screen {
        return CapstoneCarScreen(carContext);
    }
}