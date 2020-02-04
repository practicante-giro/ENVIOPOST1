package com.enviopost.Entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("CLAVE")
    @Expose
    var CLAVE:String,

    @SerializedName("FECHA")
    @Expose
    var FECHA:String,

    @SerializedName("LECTOR")
    @Expose
    var LECTOR:String,

    @SerializedName("FECHA_LECTURA")
    @Expose
    var FECHA_LECTURA:String




){ override fun toString(): String = CLAVE + FECHA + LECTOR + FECHA_LECTURA}