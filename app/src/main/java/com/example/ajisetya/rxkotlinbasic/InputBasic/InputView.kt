package com.example.ajisetya.rxkotlinbasic.InputBasic

import android.graphics.Color
import android.text.InputType
import android.view.Gravity
import com.example.ajisetya.rxkotlinbasic.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by AJISETYA on 2/23/2018.
 */
class InputView : AnkoComponent<InputActivity> {

    override fun createView(ui: AnkoContext<InputActivity>) = with(ui) {
        verticalLayout {
            backgroundResource = R.drawable.gradient
            padding = 16
            lparams(width = matchParent, height = matchParent)

            val alas = editText {
                hint = "Masukkan angka alas"
                inputType = InputType.TYPE_CLASS_NUMBER
                backgroundResource = R.drawable.bg_edittext
                leftPadding = 30
                rightPadding = 30
            }.lparams(width = matchParent, height = wrapContent){
                bottomMargin = 8
            }

            val tinggi = editText {
                hint = "Masukkan angka tinggi"
                inputType = InputType.TYPE_CLASS_NUMBER
                backgroundResource = R.drawable.bg_edittext
                leftPadding = 30
                rightPadding = 30
            }.lparams(width = matchParent, height = wrapContent){
                bottomMargin = 16
            }

            val hasilnya = textView("Hasil"){
                gravity = Gravity.CENTER_HORIZONTAL
                textColor = Color.WHITE

            }.lparams(width = matchParent, height = wrapContent){
                bottomMargin = 16
            }

            button("Hitung"){
                onClick {
                    var alas = alas.text.toString().toDouble()
                    var tinggi = tinggi.text.toString().toDouble()
                    var hasil = alas * tinggi /2
                    hasilnya.text = hasil.toString()
                }
            }
        }
    }

}