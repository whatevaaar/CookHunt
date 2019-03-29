package com.example.nexus.cookhunt

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Scraper(this).execute()
    }

    fun updateList(lista: ArrayList<String>){
        val adapter = ArrayAdapter(this, R.layout.listview_item, lista)
        recipe_list_view.adapter = adapter

    }
}
