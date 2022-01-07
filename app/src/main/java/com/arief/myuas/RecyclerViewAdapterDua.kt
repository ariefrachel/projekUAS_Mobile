package com.arief.myuas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.arief.myuas.R
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerViewAdapterDua (
    val wisatatimur : ArrayList<DataModelDua.Data>
): RecyclerView.Adapter<RecyclerViewAdapterDua.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_row_dua, parent ,false)
    )

    override fun onBindViewHolder(holder: RecyclerViewAdapterDua.ViewHolder, position: Int) {
        val datadua = wisatatimur[position]
        holder.txtNama.text = datadua.nama
        holder.txtLokasi.text = datadua.lokasi
    }

    override fun getItemCount()= wisatatimur.size

    class ViewHolder (view : View):RecyclerView.ViewHolder(view){
        val txtNama = view.findViewById<TextView>(R.id.namaTextViewDua)
        val txtLokasi = view.findViewById<TextView>(R.id.lokasiTextViewDua)

    }

    public fun setData(datadua: List<DataModelDua.Data>){
        wisatatimur.clear()
        wisatatimur.addAll(datadua)
        notifyDataSetChanged()
    }
}