package com.arief.myuas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerViewAdapterTiga (
    val wisataselatan : ArrayList<DataModelTiga.Data>
): RecyclerView.Adapter<RecyclerViewAdapterTiga.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_row_tiga, parent ,false)
    )

    override fun onBindViewHolder(holder: RecyclerViewAdapterTiga.ViewHolder, position: Int) {
        val datatiga = wisataselatan[position]
        holder.txtNama.text = datatiga.nama
        holder.txtLokasi.text = datatiga.lokasi
    }

    override fun getItemCount()= wisataselatan.size

    class ViewHolder (view : View):RecyclerView.ViewHolder(view){
        val txtNama = view.findViewById<TextView>(R.id.namaTextViewTiga)
        val txtLokasi = view.findViewById<TextView>(R.id.lokasiTextViewTiga)

    }

    public fun setData(datatiga: List<DataModelTiga.Data>){
        wisataselatan.clear()
        wisataselatan.addAll(datatiga)
        notifyDataSetChanged()
    }
}