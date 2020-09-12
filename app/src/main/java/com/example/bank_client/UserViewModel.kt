package com.example.bank_client

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel:ViewModel() {

    var userList: MutableLiveData<List<Card>> = MutableLiveData()
    init {

     //   userList.value = Api_data_users.getUsers()

    }
    fun getListUsers()  = userList



}