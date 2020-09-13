package com.example.bank_client

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity()  {

    //номер пользователя
    var userNum : Int = 0

    //наблюдатель номера пользователя в списке карт
    lateinit var observer: Observer<Int>
    lateinit var userNumInCards : UserViewModel



    override fun onCreate(savedInstanceState: Bundle?) {

        //Для первого запуска создаём файл текущего пользователя.
try {
    ReadFile()
}
catch (e: Exception){
    WriteFile(1)

}
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userNumInCards = ViewModelProvider(this).get(UserViewModel::class.java)
        //Смотрим текущего пользователя
        userNum = ReadFile()
        //заносим его во вью
        userNumInCards.getnum(userNum)

        val user = userNumInCards.getCurrentUser()


        number.text = user!!.card_number
        username.text = user.cardholder_name
        validdata.text = user.valid
        amount2.text = ("$"+ user.balance.toString() )
        Glide.with(this)
            .load(user.type)
            .into(groupcard)

amount.text = ("£"+ userNumInCards.clickGBR(user!!.balance))







    }
    fun clickGBR (view: View){
        val user = userNumInCards.getCurrentUser()
        amount.text = ("£"+ userNumInCards.clickGBR(user!!.balance))
    }
    fun clickRUB(view: View) {

        val user = userNumInCards.getCurrentUser()
        amount.text = ("₽"+ userNumInCards.clickRUB(user!!.balance))
    }
    fun clickEUR(view: View){
        val user = userNumInCards.getCurrentUser()
        amount.text = ("€"+ userNumInCards.clickEUR(user!!.balance))
    }
    fun clickCard(view: View){

        val intent = Intent(this, CardsActivity::class.java)
        startActivity(intent)
    }


//нужно вынести отсюда
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
        var br: BufferedReader  = BufferedReader(reader)
        var sb: StringBuffer = StringBuffer()
        var line: Int = br.read()
        sb.append(line)
        println(line)
        return line

    }






    }

