package com.example.bank_client


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

import com.bumptech.glide.Glide


class CardAdapter(val cards : List<Card>, private val clickListener: (Card) -> Unit) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    //номер пользователя
    var userNum = MutableLiveData<Int>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cards[position]

        //Заполнение списка карт
        holder.view.number.text = card.card_number

        Glide.with(holder.view.group)
            .load(card.type)
            .into(holder.view.group)

        if (card.blueCircle)
            Glide.with(holder.view.group)
                .load(R.drawable.ic_ellipse_1)
                .into(holder.view.circle)

        //клик
        holder.click ( cards[position], clickListener)
    }


    class CardViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    {
        //клик
        fun click (card: Card, clickListener: (Card) -> Unit) {
             itemView.setOnClickListener { clickListener(card) }
        }
    }


}
