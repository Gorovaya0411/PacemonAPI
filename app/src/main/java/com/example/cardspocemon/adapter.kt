package com.example.cardspocemon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

interface PackemonDelegate {
    fun OpenImage (URL: String?, ID:String?, Name:String?, typ:String?)
}


class Adapter(): RecyclerView.Adapter<Adapter.MyViewHolder>() {
    private var delegate: PackemonDelegate? = null
    private val dataPac: MutableList<cards> = ArrayList()
 fun setData(data: List<cards>){
    dataPac.clear()
     dataPac.addAll(data)
     notifyDataSetChanged()
 }
    fun attachDelegete (delegate: PackemonDelegate){
        this.delegate = delegate
    }
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image,parent,false), delegate = delegate)
    }

    override fun getItemCount(): Int {
        return dataPac.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataPac[position])

    }
    class MyViewHolder(itemView: View, val delegate: PackemonDelegate?):RecyclerView.ViewHolder(itemView){
        var photoImageView: ImageView = itemView.findViewById(R.id.iv_photo)



        fun bind(Pac: cards){
            Picasso.get()
                .load(Pac.imageUrl)
                .into(photoImageView)

            photoImageView.setOnClickListener{
                if ( Pac.types == null) {
                delegate?.OpenImage(URL = Pac.imageUrl,ID = Pac.id, Name = Pac.name, typ = "Типа нет")}
                else {delegate?.OpenImage(URL = Pac.imageUrl,ID = Pac.id, Name = Pac.name, typ = Pac.types.toString())}

            }}}}
