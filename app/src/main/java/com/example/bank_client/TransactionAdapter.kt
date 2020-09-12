package com.example.bank_client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item_trans.view.*

class TransactionAdapter(val transactions: List<Transaction>) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_trans, parent, false))
    }

    override fun getItemCount() = transactions.size

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {

        val transaction = transactions[position]
        holder.view.namelogo.text = transaction.title


        Glide.with(holder.view.logo)
            .load(transaction.icon_url)
            .into(holder.view.logo)


    }


    class TransactionViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}




/*
class CardAdapter(val cards : List<Card>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {




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




}

* */