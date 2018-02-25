package com.example.ajisetya.rxkotlinbasic.RecyclerActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.example.ajisetya.rxkotlinbasic.R
import org.jetbrains.anko.*

class RecyclerActivity : AppCompatActivity() {

    // constanta untuk menyimpan data
    val data = ArrayList<String>()
    // constanta untuk kunci data
    val KEY_LIST = "LIST"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // memasukkan data ke dalam constanta data dengan menjalankan method onSaveInstanceState
        // berjalan hanya ketika savedInstanceState tidak null
        savedInstanceState?.let {
            val arrayList = savedInstanceState.get(KEY_LIST)
            data.addAll(arrayList as List<String>)
        }
        // menampilkan view dari class tampilan
        RecyclerTampilan(Adapterku(data)).setContentView(this)
    }

    // dipanggil untuk memasukkan data
    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putStringArrayList(KEY_LIST, data)
        super.onSaveInstanceState(outState)
    }
}

