package com.example.nexus.cookhunt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Scraper().execute()
        main()
    }

    fun main(){
        lateinit var listView: ListView

    }
}
