package com.example.bank_client

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cards.view.*
import kotlinx.android.synthetic.main.activity_cards_1.*



class CardsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards_1)

       val cards = listOf( Card("6565 6115 5555 5555", false, R.drawable.ic_group, "Anton Ivanov", "12/22", 2617.14 ), Card("6565 6115 5555 5555", false, R.drawable.ic_group_1, "Anton Ivanov", "12/22", 2617.14 ))


       recyclerView.layoutManager = LinearLayoutManager(this)
       recyclerView.adapter = CardAdapter(cards)

    }

    fun toast(view: View){
       // val mytoast = Toast.makeText(this, "nnnn",Toast.LENGTH_SHORT)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
