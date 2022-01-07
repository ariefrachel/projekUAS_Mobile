package com.arief.myuas

data class DataModelDua (
    val wisatatimur: List<Data>
){
    data class Data(
        val id : String?,
        val nama : String?,
        val lokasi : String?
    )

}