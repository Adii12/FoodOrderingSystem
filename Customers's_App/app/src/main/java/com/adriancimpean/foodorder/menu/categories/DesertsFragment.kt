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
class DesertsFragment : Fragment() {
    var list : ListView? = null
    var listItems : ArrayList<Item>? = null
    var listAdapter : ItemListAdapter? = null
    var data : JSONObject? = null
    var arrData : JSONArray? = null
    var desertsLoader : ProgressBar? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_deserts, container, false)
        list =view.findViewById(R.id.desertsList)
        desertsLoader=view.findViewById(R.id.desertsLoader)
        listItems = ArrayList()

        listAdapter = ItemListAdapter(
            context!!,
            R.layout.custom_menu_list,
            listItems!!
        )

        list!!.adapter = listAdapter

        desertsLoader?.visibility = View.GONE

        if(ConnectionHandler.isNetworkAvailable(context!!)) {
            val getDeserts = getDeserts()
            getDeserts.execute()
        }else {
            Snackbar.make(view, R.string.no_internet, Snackbar.LENGTH_SHORT).show()
        }

        return view
    }

    inner class getDeserts : AsyncTask<Void, Void, String>(){
        override fun onPreExecute() {
            super.onPreExecute()
            desertsLoader?.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg p0: Void?): String {
            return ConnectionHandler.getRequest("https://food-order-bbcce.firebaseio.com/Categories/Deserts.json")
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
            desertsLoader?.visibility = View.GONE
        }
    }
}
