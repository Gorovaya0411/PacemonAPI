package com.example.cardspocemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var adapter = Adapter()
    fun ClickOnImage(URL: String?, ID: String?, Name: String?, typ: String?) {
        val intent = Intent(this, PokemonDetailedInfoActivity::class.java)
        intent.putExtra("image", URL)
        intent.putExtra("id", ID)
        intent.putExtra("Name", Name)
        intent.putExtra("typ", typ)
        startActivity(intent)
    }

    fun populateData(pac: List<cards>) {
        adapter.setData(pac)
    }

    fun workWithAdapter() {
        rv_images.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_images.adapter = adapter
        adapter.attachDelegete(object : PackemonDelegate {
            override fun OpenImage(URL: String?, ID: String?, Name: String?, typ: String?) {
                ClickOnImage(URL = URL, ID = ID, Name = Name, typ = typ)
            }

        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        workWithAdapter()
        val apiService = Request.create()

        apiService.search()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                populateData(it.cards)
            }, { error ->
                error.printStackTrace()
            })


    }


}




