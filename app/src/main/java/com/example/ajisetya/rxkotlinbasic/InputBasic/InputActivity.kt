package com.example.ajisetya.rxkotlinbasic.InputBasic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ajisetya.rxkotlinbasic.InputBasic.InputView
import org.jetbrains.anko.setContentView

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // untuk memasang anko ke actiity
        // bisa dipasang di activity lain
        InputView().setContentView(this)
    }
}
