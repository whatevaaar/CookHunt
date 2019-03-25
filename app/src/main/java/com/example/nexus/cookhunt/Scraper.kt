package com.example.nexus.cookhunt

import android.os.AsyncTask
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.nexus.cookhunt.R.id.recipe_list_view
import org.jsoup.Jsoup
import org.jsoup.nodes.Document


class Scraper() : AsyncTask<Void, Void, Void>() {
    lateinit var pagina: Document
    lateinit var recetas: List<String>
    override fun doInBackground(vararg params: Void?): Void? {
        pagina = Jsoup.connect("https://www.cocinacaserayfacil.net/todas-las-recetas/").get()
        recetas = pagina.select("a") .map { it.text() }. filter{it.contains("–")}
        println("$recetas")
        return null
    }

    override fun onPostExecute(result: Void?) {
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, recetas)
        return
    }
}