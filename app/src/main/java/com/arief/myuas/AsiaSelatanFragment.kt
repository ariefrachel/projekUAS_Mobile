package com.arief.myuas

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import com.arief.myuas.retrofit.apiClient
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AsiaSelatanFragment : Fragment() {
    private val api by lazy { apiClient().endpoint}
    private lateinit var recyclerViewAdapter: RecyclerViewAdapterTiga
    private lateinit var listWisata : RecyclerView

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_asia_selatan, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        listWisata = view.findViewById(R.id.selatan)
        setupList()

    }

    private fun setupList() {
        recyclerViewAdapter = RecyclerViewAdapterTiga(arrayListOf())
        listWisata .adapter = recyclerViewAdapter
    }

    override fun onStart(){
        super.onStart()
        getWisata()
    }
    private fun getWisata(){

        api.datatiga().enqueue(object : Callback<DataModelTiga> {
            override fun onResponse(call: Call<DataModelTiga>, response: Response<DataModelTiga>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.wisataselatan
                    recyclerViewAdapter.setData(listData)

                }else{
                    Toast.makeText(
                        activity,
                        "gagal get data",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<DataModelTiga>, t: Throwable) {
                Log.e("reportActivity", t.toString())
            }

        })
    }

}