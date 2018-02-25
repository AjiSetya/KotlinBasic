package com.example.ajisetya.rxkotlinbasic.RecyclerActivity

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.ajisetya.rxkotlinbasic.R
import org.jetbrains.anko.*

/**
 * Created by AJISETYA on 2/25/2018.
 */
class Adapterku(val data: ArrayList<String> = ArrayList<String>()) : RecyclerView.Adapter<Holder>() {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder?, position: Int) {
        holder?.teks?.text = data.get(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        return Holder(TextView(parent?.context).apply {
            textColor = Color.WHITE
            textSize = 20f
            background = context.obtainStyledAttributes(arrayOf(R.attr.selectableItemBackground).toIntArray()).getDrawable(0)
            verticalPadding = context.dip(8)
            isClickable = true
            layoutParams = ViewGroup.LayoutParams(matchParent, wrapContent)
        })
    }


    fun pop() {
        data.remove(data.last())
        notifyItemRemoved(data.size)
    }

    fun push(teks: String) {
        data.add(0, teks)
        notifyItemInserted(0)
    }
}
