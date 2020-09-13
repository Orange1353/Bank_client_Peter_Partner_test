package com.example.bank_client
import android.app.PendingIntent.getActivity
import java.io.File
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils.getActivity
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {

    var userNum : Int = 1
    lateinit var userNumInCards : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userNumInCards = ViewModelProvider(this).get(UserViewModel::class.java)

        //Узнаем текущий номер юзера
        try {
            userNum = activity?.let{
                (it as MainActivity).ReadFile()

            }!!
            userNumInCards.getnum(userNum)
        }
        catch (e: Exception) {
            userNumInCards.getnum(userNum)
        }

    /*    activity?.let{
            (it as MainActivity).ReadFile()
        }
    */

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


      //Получим текущего пользователя
        val user = userNumInCards.getCurrentUser()
      // И его список транзакций
        val transList = user!!.transaction


        //где находится
        val rootView = inflater.inflate(R.layout.fragment_blank, container, false)

        val recyclerViewTrans = rootView.findViewById(R.id.recyclerViewTrans) as RecyclerView // Add this

        //адаптор
        recyclerViewTrans.layoutManager = LinearLayoutManager(activity)
        recyclerViewTrans.adapter = TransactionAdapter(transList)

        return rootView

    }


}