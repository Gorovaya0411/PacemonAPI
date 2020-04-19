package com.example.cardspocemon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_image.view.*

interface PackemonDelegate {
    fun OpenImage (URL: String?, ID:String?, Name:String?, typ:String?)
}


class Adapter(var delegate: PackemonDelegate? = null): RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private var dataPac = listOf<cards>()
 fun setData(data: List<cards>){
     this.dataPac = data
     notifyDataSetChanged()
 }
    fun attachDelegete (delegate: PackemonDelegate){
        this.delegate = delegate
    }
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image,parent,false), delegate = delegate)
    }

    override fun getItemCount(): Int = dataPac.count()

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataPac[position])

    }
    class MyViewHolder(itemView: View, val delegate: PackemonDelegate?):RecyclerView.ViewHolder(itemView){
        var photoImageView: ImageView = itemView.iv_photo



        fun bind(Pac: cards){
            Picasso.get()
                .load(Pac.imageUrl)
                .into(photoImageView)

            photoImageView.setOnClickListener{
                if ( Pac.types == null) {
                delegate?.OpenImage(URL = Pac.imageUrl,ID = Pac.id, Name = Pac.name, typ = "Типа нет")}
                else {delegate?.OpenImage(URL = Pac.imageUrl,ID = Pac.id, Name = Pac.name, typ = Pac.types.toString())}

            }}}}
