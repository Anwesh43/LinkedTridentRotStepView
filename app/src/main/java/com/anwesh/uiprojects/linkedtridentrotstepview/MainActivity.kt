package com.anwesh.uiprojects.linkedtridentrotstepview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.anwesh.uiprojects.tridentrotstepview.TridentRotStepView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TridentRotStepView.create(this)
    }
}
