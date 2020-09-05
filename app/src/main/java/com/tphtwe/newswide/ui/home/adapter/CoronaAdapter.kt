package com.tphtwe.newswide.ui.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.tphtwe.newswide.R
import com.tphtwe.newswide.model.model1.AllCountry1Item
import kotlinx.android.synthetic.main.item_corona_country.view.*
import kotlinx.android.synthetic.main.nav_header_main.view.*

class CoronaAdapter (var listCountry:List<AllCountry1Item> = ArrayList<AllCountry1Item>()):RecyclerView.Adapter<CoronaAdapter.CoronaViewHolder>(){
    class CoronaViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        fun bind(allCountryItem: AllCountry1Item){
            Picasso.get().load(allCountryItem.countryInfo.flag).into(itemView.flagValue)
            itemView.nameValue.text=allCountryItem.country
        }
    }
    fun updateCountry(countrylist:List<AllCountry1Item>){
        this.listCountry=countrylist
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