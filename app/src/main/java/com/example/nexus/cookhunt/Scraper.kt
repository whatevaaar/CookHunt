package com.example.nexus.cookhunt

import android.os.AsyncTask
import android.widget.ArrayAdapter
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import android.app.Activity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class Scraper (act: Activity) : AsyncTask<Void, Void, Void>() {
    lateinit var pagina: Document
    lateinit var recetas: List<String>
    val actividad= WeakReference(act)

    override fun doInBackground(vararg params: Void?): Void? {
        pagina = Jsoup.connect("https://www.cocinacaserayfacil.net/todas-las-recetas/").get()
        recetas = pagina.select("a") .map { it.text() }. filter{it.contains("–")}
        println("$recetas")
        return null
    }

    override fun onPostExecute(result: Void?) {
        val lista = ArrayList(recetas)
        (actividad.get() as MainActivity).updateList(lista)
        return
    }
}
