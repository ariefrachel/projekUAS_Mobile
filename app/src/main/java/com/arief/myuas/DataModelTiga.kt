package com.arief.myuas

data class DataModelTiga (
    val wisataselatan: List<Data>
){
    data class Data(
        val id : String?,
        val nama : String?,
        val lokasi : String?
    )

}