package com.example.bank_client

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cards_1.*
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader


class CardsActivity : AppCompatActivity() {

    var userNum : Int = 1
    lateinit var userNumInCards : UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards_1)

        //Проверить нужно ли
        userNumInCards = ViewModelProvider(this).get(UserViewModel::class.java)
   //     userNumInCards.getnum(userNum)


        val cards: List<Card>? = userNumInCards.getListUsers()


       recyclerView.layoutManager = LinearLayoutManager(this)
       recyclerView.adapter = cards?.let {
           CardAdapter(it) { cards -> ItemClicked(cards)


           }
       }
    }



    private fun ItemClicked(card: Card) {
        //да, убого, но времени нет)
        if (card.card_number == "4455 1223 3488 1000")
            WriteFile(0)
        else if (card.card_number == "4455 8897 3135 1499")
            WriteFile(1)
        else
            WriteFile(2)

        //Передается во ModelView чтобы там его отследила MainActivity
        userNumInCards = ViewModelProvider(this).get(UserViewModel::class.java)
        userNumInCards.getnum(ReadFile())

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
       // Toast.makeText(this, "Clicked: ${userNum}", Toast.LENGTH_SHORT).show()
    }

    fun toast(view: View){
       // val mytoast = Toast.makeText(this, "nnnn",Toast.LENGTH_SHORT)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun clickUser(view: View)
    {
        userNum = recyclerView.getChildLayoutPosition(view)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


    fun WriteFile(value: Int) {

        //текущий пользователь
        try {
            var stream: FileOutputStream = openFileOutput(
                "currentUser.txt",
                Context.MODE_PRIVATE
            )  // /data/user/0/com.example.bank_client/files
            stream.write(value)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun ReadFile(): Int {

        var  streamin : FileInputStream = openFileInput("currentUser.txt")  // /data/user/0/com.example.bank_client/files

        var reader : InputStreamReader = InputStreamReader(streamin)
        var br: BufferedReader = BufferedReader(reader)
        var sb: StringBuffer = StringBuffer()
        var line: Int = br.read()
        sb.append(line)
        println(line)
        return line

    }




}
