package com.arief.myuas

data class DataModel (
    val wisatatenggara: List<Data>
){
    data class Data(
        val id : String?,
        val nama : String?,
        val lokasi : String?
    )

}