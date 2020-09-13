package com.example.bank_client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_trans.view.*
import kotlinx.android.synthetic.main.list_item_trans.view.amount

class TransactionAdapter(val transactions: List<Transaction>) : RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_trans, parent, false))



    }

    override fun getItemCount() = transactions.size

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {


        //Заполнение списка транзакций
        val transaction = transactions[position]
        holder.view.namelogo.text = transaction.title


        Glide.with(holder.view.logo)
            .load(transaction.icon_url)
            .into(holder.view.logo)

        if(transaction.amount < 0)
        holder.view.amount.text= ("- $ " + (transaction.amount*(-1)).toString())
        else
            holder.view.amount.text= ("$ " + (transaction.amount*(-1)).toString())

        holder.view.data.text = transaction.date

        if(transaction.amount < 0)
            holder.view.amount_2.text= ("- ₽ " + (transaction.amount*(-75)).toString())
        else

        holder.view.amount_2.text= ("₽" + (transaction.amount*75).toString())
    }


    class TransactionViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun clickRUB5(view: View) {

    }


}





