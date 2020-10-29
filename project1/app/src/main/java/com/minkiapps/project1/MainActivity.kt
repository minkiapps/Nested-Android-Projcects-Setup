package com.minkiapps.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minkiapps.projectlibrary.PiSolver

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PiSolver().solvePi()
    }
}