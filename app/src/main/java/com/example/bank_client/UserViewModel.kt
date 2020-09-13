package com.example.bank_client


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class UserViewModel:ViewModel() {

    var userNum: MutableLiveData<Int> = MutableLiveData()
    var userList: MutableLiveData<List<Card>> = MutableLiveData<List<Card>>()
    var currentUser: MutableLiveData<Card> = MutableLiveData<Card>()

    init {


        userList.value = Api_data_users.getUsers()

    }

    //Список всех юзеров со всеми их транзакциями
    fun getListUsers()  = userList.value

    //Только текущий юзер
    fun getCurrentUser() = currentUser.value


    fun getUserNum() = userNum.value

    //функции чтения работают только здесь, исправить
    var mm:MainActivity = MainActivity()



    fun setUserNum(ptr: Int) = mm.WriteFile(ptr)

fun getnum(num: Int)
{

    println("get num $num")
    userNum.value = num
    currentUser.value =  userList.value!![userNum.value!!]
}


    fun clickGBR (num: Double): String {

        val df = DecimalFormat("#.###")
        return (df.format(num*0.78))
    }
    fun clickRUB (num: Double): String {

        val df = DecimalFormat("#.###")
        return (df.format(num*75))

    }
    fun clickEUR (num: Double): String {
        val df = DecimalFormat("#.###")
        return (df.format(num*0.84))
    }


}


