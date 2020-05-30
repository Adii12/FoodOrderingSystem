package com.adriancimpean.foodorder.menu.categories

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
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class DesertsFragment : Fragment() {
    var list : ListView? = null
    var listItems : ArrayList<String>? = null
    var adapter : ArrayAdapter<String>? = null
    var data : JSONObject? = null
    var desertsLoader : ProgressBar? = null

    inner class getDeserts : AsyncTask<Void, Void, String>(){
        override fun onPreExecute() {
            super.onPreExecute()
            desertsLoader?.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg p0: Void?): String {
            return FetchData.getRequest("https://food-order-bbcce.firebaseio.com/Categories/Deserts.json")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            data = JSONObject(result)

            for(i in 0 until data?.names()!!.length()){
                listItems!!.add(data?.names()!![i].toString())
                adapter!!.notifyDataSetChanged()
            }

            desertsLoader?.visibility = View.GONE
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_deserts, container, false)
        list =view.findViewById(R.id.desertsList)
        desertsLoader=view.findViewById(R.id.desertsLoader)
        listItems = ArrayList()

       adapter = ArrayAdapter(context!!,R.layout.custom_row,R.id.Name,listItems!!)

        list!!.adapter = adapter

        desertsLoader?.visibility = View.GONE

        val getDeserts = getDeserts()
        getDeserts.execute()

        return view
    }

}
