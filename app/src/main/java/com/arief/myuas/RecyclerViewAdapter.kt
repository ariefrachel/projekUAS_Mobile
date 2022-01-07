package com.arief.myuas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arief.myuas.R
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerViewAdapter (
    val wisatatenggara : ArrayList<DataModel.Data>
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_row, parent ,false)
    )

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        val data = wisatatenggara[position]
        holder.txtNama.text = data.nama
        holder.txtLokasi.text = data.lokasi
    }

    override fun getItemCount()= wisatatenggara.size

    class ViewHolder (view : View):RecyclerView.ViewHolder(view){
        val txtNama = view.findViewById<TextView>(R.id.namaTextView)
        val txtLokasi = view.findViewById<TextView>(R.id.lokasiTextView)

    }

    public fun setData(data: List<DataModel.Data>){
        wisatatenggara.clear()
        wisatatenggara.addAll(data)
        notifyDataSetChanged()
    }
}