package com.example.ajisetya.rxkotlinbasic.RecyclerActivity

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.ajisetya.rxkotlinbasic.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7._RecyclerView
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.textChangedListener

/**
 * Created by AJISETYA on 2/25/2018.
 */
class RecyclerTampilan(val listAdapter: Adapterku) : AnkoComponent<RecyclerActivity> {

    override fun createView(ui: AnkoContext<RecyclerActivity>) = with(ui) {
        relativeLayout {
            val idtombolKirim = 2
            val idedChat = 1

            backgroundResource = R.drawable.gradient
            lparams(matchParent, matchParent)

            val viewKosong = textView("Ngomong lah"){
                textSize = 16f
                textColor = Color.WHITE
            }.lparams(){
                centerInParent()
            }

            val tombolKirim = button(){
                id = idtombolKirim
                backgroundResource = R.drawable.bg_btnkirim
            }.lparams(dip(44), dip(44)){
                topMargin = dip(8)
                alignParentBottom()
                alignParentRight()
            }

            val edChat = editText(){
                id = idedChat
                hint = "Type some text"
                leftPadding = dip(16)
                rightPadding = dip(16)
                backgroundResource = R.drawable.bg_edittext
            }.lparams(matchParent, wrapContent){
                topMargin = dip(8)
                leftOf(idtombolKirim)
                alignParentBottom()
                sameBottom(idtombolKirim)
            }

            fun tidakAdaData(rv: RecyclerView) {
                if (doesListHaveItem(rv)) {
                    viewKosong.visibility = View.GONE
                } else {
                    viewKosong.visibility = View.VISIBLE
                }
            }

            val listData = recyclerView {
                // mengatur orientasi
                val orientasi = LinearLayoutManager.VERTICAL
                // mengatur layout manager recycler
                layoutManager = LinearLayoutManager(context, orientasi, true)
                overScrollMode = View.OVER_SCROLL_NEVER
                // setAdapter
                adapter = listAdapter
                //
                adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver(){
                    override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                        super.onItemRangeInserted(positionStart, itemCount)
                    }

                    override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                        super.onItemRangeRemoved(positionStart, itemCount)
                    }
                })

                tidakAdaData(this)
            }.lparams(matchParent, matchParent){
                above(edChat)
            }

            tombolKirim.onClick {
                val teks = edChat.text.toString()
                val adapter = listData?.adapter as Adapterku

                if (teks.isBlank() && doesListHaveItem(listData)){
                    adapter.pop()
                }else{
                    if (!teks.isBlank()) {
                        adapter.push(teks)
                        listData.scrollToPosition(0)
                        edChat.text = null
                    }
                }
            }

            edChat.textChangedListener {
                afterTextChanged {
                    if (it?.isBlank() ?: true &&
                            doesListHaveItem(listData)) {
                        tombolKirim.backgroundResource = R.drawable.bg_btnkirim2
                    } else {
                        tombolKirim.backgroundResource = R.drawable.bg_btnkirim
                    }
                }
            }
        }
    }

    // untuk mengecek apakah ada item di recyclerview
    // return boolean
    private fun doesListHaveItem(list: RecyclerView?) = getListItemCount(list) > 0

    // mengambil jumlah item dari adapater recycler
    // return int
    private fun getListItemCount(list: RecyclerView?) = list?.adapter?.itemCount?:0

}