package com.app.sehatyuk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var adapter : AdapterRVHome
    private lateinit var recyclerView : RecyclerView
    private lateinit var menuArrayList : ArrayList<DataRVHome>

    lateinit var icon : Array<Int>
    lateinit var title : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        dataInitiaize()
        val layoutManager = GridLayoutManager(this, 3)
        recyclerView = findViewById(R.id.rvHome)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)  
        adapter = AdapterRVHome(menuArrayList)
        recyclerView.adapter = adapter

        var cardCheckin = findViewById<CardView>(R.id.check_in_info_2)
        var cardCheckout = findViewById<CardView>(R.id.check_in_info)
        var btnCheckin = findViewById<CardView>(R.id.btn_check_in)
        var btnCheckout = findViewById<CardView>(R.id.btn_check_out)

        btnCheckin.setOnClickListener {
            cardCheckin.visibility = CardView.GONE
            cardCheckout.visibility = CardView.VISIBLE
        }


        btnCheckout.setOnClickListener {
            cardCheckin.visibility = CardView.VISIBLE
            cardCheckout.visibility = CardView.GONE
        }
    }

    private fun dataInitiaize() {
        menuArrayList = arrayListOf<DataRVHome>()

        icon = arrayOf(
            R.drawable.ic_sertifikat,
            R.drawable.ic_hasil_tes,
            R.drawable.ic_ehac,
            R.drawable.ic_riwayat,
            R.drawable.ic_riwayat_perjalanan,
            R.drawable.ic_teledoketer,
            R.drawable.ic_layanan,
            R.drawable.ic_stastitik,
            R.drawable.ic_daftar_vaksin,
        )

        title = arrayOf(
            "Sertifikat Vaksin",
            "Hasil Tes COVID-19",
            "EHAC",
            "Riwayat Check-In",
            "Aturan Perjalanan",
            "Teledokter",
            "Pelayanan Kesehatan",
            "Statistik COVID-19",
            "Daftar Vaksin"
        )

        for (i in icon.indices){
            val menu = DataRVHome(icon[i], title[i])
            menuArrayList.add(menu)
        }
    }
}