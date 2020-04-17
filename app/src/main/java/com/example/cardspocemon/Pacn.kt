package com.example.cardspocemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_pacn.*

class Pacn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pacn)
        Picasso.get().load(intent?.extras?.getString("image") ?: "").fit().into(imageButton)
        val Id = intent.getStringExtra("id")?: "Id Неть"
        val Name = intent.getStringExtra("Name")?: "Name Неть"
        val typ = intent.getStringExtra("typ")?: "Типа Неть"
        textView.text = Name.toString()
        textView2.text = Id.toString()
        textView3.text = typ.toString()
    }
}
