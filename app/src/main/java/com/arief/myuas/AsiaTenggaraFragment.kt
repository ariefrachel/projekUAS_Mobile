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

class AsiaTenggaraFragment : Fragment() {
    private val api by lazy { apiClient().endpoint}
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var listWisata : RecyclerView

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_asia_tenggara, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        listWisata = view.findViewById(R.id.tenggara)
        setupList()

    }

    private fun setupList() {
        recyclerViewAdapter = RecyclerViewAdapter(arrayListOf())
        listWisata .adapter = recyclerViewAdapter
    }

    override fun onStart(){
        super.onStart()
        getWisata()
    }
    private fun getWisata(){

        api.data().enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>, response: Response<DataModel>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.wisatatenggara
                    recyclerViewAdapter.setData(listData)

                }else{
                    Toast.makeText(
                        activity,
                        "gagal get data",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Log.e("reportActivity", t.toString())
            }

        })
    }

}