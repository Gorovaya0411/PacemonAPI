package com.example.cardspocemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pacn.*

class PokemonDetailedInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pacn)
        InfoNewActivity()

    }
    fun InfoNewActivity() {Picasso.get().load(intent?.extras?.getString("image") ?: "").fit().into(imageButton)
        val Id = intent.getStringExtra("id")?: "Id Нет"
        val Name = intent.getStringExtra("Name")?: "Имени нет"
        val typ = intent.getStringExtra("typ")?: "Типа нет"
        textView.text = Name
        textView2.text = Id
        textView3.text = typ}
}
