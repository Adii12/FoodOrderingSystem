package com.adriancimpean.foodorder.menu.categories

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast

import com.adriancimpean.foodorder.R
import com.adriancimpean.foodorder.connection.ConnectionHandler
import com.adriancimpean.foodorder.order.Item
import com.adriancimpean.foodorder.menu.ItemListAdapter
import com.google.android.material.snackbar.Snackbar
import org.json.JSONArray
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class BurgersFragment : Fragment() {
    var list : ListView? = null
    var listItems : ArrayList<Item>? = null
    var listAdapter : ItemListAdapter? = null
    var data : JSONObject? = null
    var arrData : JSONArray? = null
    var loader : ProgressBar? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_burgers, container, false)
        loader = view.findViewById(R.id.loader)
        loader!!.visibility = View.GONE

        list = view.findViewById(R.id.burgersList)

        listItems = ArrayList()
        listAdapter = ItemListAdapter(context!!, R.layout.custom_menu_list, listItems!!)

        list!!.adapter = listAdapter

        if(ConnectionHandler.isNetworkAvailable(context!!)) {
            val getBurgers = getBurgers()
            getBurgers.execute()
        }else{
            Snackbar.make(view, R.string.no_internet, Snackbar.LENGTH_SHORT).show()
        }

        return view
    }

    inner class getBurgers : AsyncTask<Void, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            loader!!.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg p0: Void?): String {
            return ConnectionHandler.getRequest("https://food-order-bbcce.firebaseio.com/Categories/Burgers.json")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            data = JSONObject(result!!)
            arrData=data!!.toJSONArray(data!!.names())

            for (i in 0 until arrData!!.length()) {
                var name = data?.names()!![i].toString()
                var description = arrData!!.getJSONObject(i).get("description").toString()
                var price = arrData!!.getJSONObject(i).getDouble("price")

                var item = Item(name,description,price)

                listItems!!.add(item)
                listAdapter!!.notifyDataSetChanged()
            }

            loader!!.visibility = View.GONE
        }
    }
}
