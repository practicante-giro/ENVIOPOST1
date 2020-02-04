package com.enviopost.Remote


import com.enviopost.Entities.Post
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Checklist {
  @POST("/api/checklist")
  @FormUrlEncoded
  fun savePost(@Field("CLAVE") CLAVE:String,
               @Field("FECHA") FECHA:String,
               @Field("LECTOR") LECTOR:String,
               @Field("FECHA_LECTURA") FECHA_LECTURA:String) : Call<Post>



}