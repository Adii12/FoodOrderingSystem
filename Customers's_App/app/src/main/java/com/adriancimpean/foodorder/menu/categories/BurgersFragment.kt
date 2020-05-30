package com.adriancimpean.foodorder.menu.categories

import android.opengl.Visibility
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar

import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.connection.FetchData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.loader
import kotlinx.android.synthetic.main.fragment_burgers.*
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class BurgersFragment : Fragment() {
    var list : ListView? = null
    var listItems : ArrayList<String>? = null
    var listAdapter : ArrayAdapter<String>? = null
    var data : JSONObject? = null
    var loader : ProgressBar? = null


    inner class getBurgers : AsyncTask<Void, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            loader!!.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg p0: Void?): String {
            return FetchData.getRequest("https://food-order-bbcce.firebaseio.com/Categories/Burgers.json")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            data = JSONObject(result!!)

            for (i in 0 until data?.names()!!.length()) {
                listItems!!.add(data?.names()!![i].toString())
                listAdapter!!.notifyDataSetChanged()
            }

            loader!!.visibility = View.GONE
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_burgers, container, false)
        loader = view.findViewById(R.id.loader)
        loader!!.visibility = View.GONE

        list = view.findViewById(R.id.burgersList)

        listItems = ArrayList()
        listAdapter = ArrayAdapter(context!!,R.layout.custom_row, R.id.Name, listItems!!)

        list!!.adapter = listAdapter

        val getBurgers = getBurgers()
        getBurgers.execute()

        return view
    }

}
