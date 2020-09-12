package com.example.bank_client

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_blank.view.*
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {


    //&&&&&&&&&&
    //@SuppressLint("ResourceType")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager
   //     supportFragmentManager.beginTransaction().add(R.layout.fragment_blank, BlankFragment.newInstance(), "frag").commit()
   //     val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()




        }

    fun clickCard(view: View){

        val intent = Intent(this, CardsActivity::class.java)
        startActivity(intent)
    }

    }
