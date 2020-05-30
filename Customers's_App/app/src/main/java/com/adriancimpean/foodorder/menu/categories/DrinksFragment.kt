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
class DrinksFragment : Fragment() {
   private var list : ListView? = null
    private var drinksList : ArrayList<String>? = null
    private var drinksListAdapter : ArrayAdapter<String>? = null
    private var drinksLoader : ProgressBar? = null
    private var data : JSONObject? = null

    inner class getDrinks : AsyncTask<Void, Void, String>(){
        override fun onPreExecute() {
            super.onPreExecute()
            drinksLoader?.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg p0: Void?): String {
            return FetchData.getRequest("https://food-order-bbcce.firebaseio.com/Categories/Drinks.json")
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            data = JSONObject(result)

            for (i in 0 until data?.names()!!.length()){
                drinksList!!.add(data?.names()!![i].toString())
                //println(data?.names()!![i].toString())
                drinksListAdapter!!.notifyDataSetChanged()
            }
            println(drinksList)
            drinksLoader!!.visibility = View.GONE
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_drinks, container, false)
        list =view.findViewById(R.id.drinksList)
        drinksLoader = view.findViewById(R.id.drinksLoader)

        drinksList = ArrayList()

        drinksListAdapter = ArrayAdapter(context!! ,R.layout.custom_row, R.id.Name, drinksList!!)

        list?.adapter = drinksListAdapter

        drinksLoader!!.visibility = View.GONE

        val getDrinks = getDrinks()
        getDrinks.execute()

        return view
    }

}
