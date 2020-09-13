package com.example.bank_client

object Api_data_users {

var currentUser: Int = 0


    fun getUsers() = listOf(
        Card("4455 1223 3488 1000", false, R.drawable.ic_group, "Anton Ivanov", "12/22", 2617.14,
            listOf( Transaction("Netflix", "https://www.iconfinder.com/icons/143870/download/png/48", "15/12/2019", -9.85),
                Transaction("Dropbox", "https://www.iconfinder.com/icons/245986/download/png/48", "14/12/2019", -15.50),
                Transaction("Dropbox", "https://www.iconfinder.com/icons/143870/download/png/48", "14/12/2019", -15.50)
                )),
        Card("4455 8897 3135 1499", false, R.drawable.ic_group_2, "Peter Gavrilin", "12/22", 4674.2,
            listOf( Transaction("Netflix", "https://www.iconfinder.com/icons/143870/download/png/48", "14/12/2019", -9.85),
                Transaction("Dropbox", "https://www.iconfinder.com/icons/245986/download/png/48", "14/12/2019", -15.50),
                Transaction("Facebook", "https://www.iconfinder.com/icons/107175/download/png/48", "15/12/2019", -6.99),
                Transaction("Apple", "https://www.iconfinder.com/icons/291727/download/png/48", "15/12/2019", -99.85)
            )),
        Card("4455 9921 6789 1999", false, R.drawable.ic_group_1, "Igor Smolov", "12/22", 9317.14,
            listOf( Transaction("Tesla", "https://www.iconfinder.com/icons/3069743/download/png/48", "15/12/2019", -4.85),
                Transaction("Dropbox", "https://www.iconfinder.com/icons/245986/download/png/48", "14/12/2019", -85.10),
                Transaction("Facebook", "https://www.iconfinder.com/icons/107175/download/png/48", "14/12/2019", -65.00)
            )))



}


