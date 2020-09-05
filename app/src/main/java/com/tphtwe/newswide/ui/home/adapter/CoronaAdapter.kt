package com.tphtwe.newswide.ui.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tphtwe.newswide.R
import com.tphtwe.newswide.model.AllCountryItem
import kotlinx.android.synthetic.main.item_corona_country.view.*

class CoronaAdapter (var listCountry:List<AllCountryItem> = ArrayList<AllCountryItem>()):RecyclerView.Adapter<CoronaAdapter.CoronaViewHolder>(){
    class CoronaViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bind(allCountryItem: AllCountryItem){
            Picasso.get().load(allCountryItem.countryInfo.flag)
            itemView.nameValue.text=allCountryItem.country
        }
    }
    fun updateCountry(Countrylist:List<AllCountryItem>){
        this.listCountry=Countrylist
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoronaViewHolder {
       var view=LayoutInflater.from(parent.context).inflate(R.layout.item_corona_country,parent,false)
        return CoronaViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("size", listCountry.size.toString())

        return listCountry.size
    }

    override fun onBindViewHolder(holder: CoronaViewHolder, position: Int) {
       holder.bind(listCountry[position])
    }
}