package com.example.bank_client

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

import com.bumptech.glide.Glide

//import com.bumptech.glide.Glide
//import kotlinx.android.synthetic.main.list_item.view.*

class CardAdapter(val cards : List<Card>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cards[position]
        holder.view.number.text = card.card_number


        Glide.with(holder.view.group)
            .load(card.type)
            .into(holder.view.group)

        if (card.blueCircle)
            Glide.with(holder.view.group)
                .load(R.drawable.ic_ellipse_1)
                .into(holder.view.circle)



    }


    class CardViewHolder(val view: View) : RecyclerView.ViewHolder(view)



}
