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
    private  var mList = Adapter()


    fun populateData(Pac: List<cards>){
    mList.setData(Pac)
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_images.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        rv_images.adapter = mList

        val apiService = zapros.create()


        val repository =apiService.search ()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe ({
                fun ClickOnImage(URL:String?, ID:String?, Name:String?, typ:String?){
                    val intent = Intent(applicationContext,Pacn::class.java)
                    intent.putExtra("image",URL)
                    intent.putExtra("id",ID)
                    intent.putExtra("Name",Name)
                    intent.putExtra("typ",typ)
                    startActivity(intent)
                }
                mList.attachDelegete(object: PackemonDelegate {
                    override fun OpenImage(URL: String?, ID:String?, Name:String?, typ:String?) {
                        ClickOnImage(URL = URL, ID = ID, Name = Name, typ = typ )
                    }

                })
                populateData(it.cards)
            }, { error ->
                error.printStackTrace()
            })


        }


    }




