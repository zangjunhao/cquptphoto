package com.example.cquptphoto.net

import com.example.cquptphoto.bean.info
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InfoService {
     @GET("query")
fun search(@Query("search")search:String):Call<info>
}