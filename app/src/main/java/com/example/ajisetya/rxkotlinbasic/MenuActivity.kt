package com.example.ajisetya.rxkotlinbasic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ajisetya.rxkotlinbasic.InputBasic.InputActivity
import com.example.ajisetya.rxkotlinbasic.RecyclerActivity.RecyclerActivity
import kotlinx.android.synthetic.main.activity_menu.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        // menampilkan toast
        btn_toast.onClick { toast("Ehek") }

        // menampilkan alert
        btn_alert.onClick {
            alert("This is message", "Title"){
                yesButton { toast("Ehek yes") }
                noButton { toast("Ehek no") }
            }.show()
        }

        // menampilkan alert dengan list pilihan
        btn_selector.onClick {
            var nama_negara = listOf("Amerika", "Arab", "Afrika", "Brunei", "Malaysia", "Rusia")

            selector("Pilih negaramu", nama_negara, {dialogInterface, i ->
                toast("Negaramu di ${nama_negara[i]}, kan?")
            })
        }

        // ganti activity
        btn_rx_input.onClick { startActivity<MainActivity>() }
        btn_input.onClick { startActivity<InputActivity>() }

        // memangil telephone
        btn_call.onClick { makeCall("082390607564") }
        // mengirim pesan
        btn_send_sms.onClick { sendSMS("082390607564", "This message from Anko Kotlin") }
        // mengirim email
        btn_send_email.onClick {
            browse("http://blogsetyaaji.blogspot.com")
            // share text biasa
            share("Hai this is email from Anko Kotlin", "Anko send email")
            // ngirim email
            email("putra.java.famili@gmail.com", "Anko email", "This Anko email")
        }

        btn_recycler.onClick { startActivity<RecyclerActivity>() }
    }
}
