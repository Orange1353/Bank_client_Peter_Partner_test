package com.example.bank_client
/*
class Card(val number: String, var blueCircle: Boolean, val icon: String) {

}
*/

data class Card (

    val card_number: String,
    var blueCircle: Boolean,
    val type: Int,
    val cardholder_name: String,
    val valid: String,
    var balance: Double,
    var transaction: List<Transaction>

)
