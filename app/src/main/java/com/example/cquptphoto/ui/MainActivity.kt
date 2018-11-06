package com.example.cquptphoto.ui

import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import com.example.cquptphoto.bean.info

import kotlinx.android.synthetic.main.activity_main.*
import com.example.cquptphoto.R
import com.example.cquptphoto.adapter.recAdapter
import com.example.cquptphoto.net.InfoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), TextWatcher {


    lateinit var list:List<info.ResultsBean>
    lateinit var  retrofit:Retrofit
    lateinit var api: InfoService
    lateinit var recAdapter: recAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= 21) {
            var option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        }
        init()
        submitButton.setOnClickListener {
            if(textInputedix2.text.toString().equals("张俊豪")||textInputedix2.text.toString().equals("2017214133")){
                Toast.makeText(this,"重邮吴彦祖，无法搜索",Toast.LENGTH_SHORT).show()
                submitButton.doResult(false)
            }
            else
            api.search(textInputedix2.text.toString()).enqueue(object : Callback<info> {
                override fun onResponse(call: Call<info>, response: Response<info>) {

                    if(response.body()!!.info.equals("没有查询到符合的人选"))
                    {
                        Toast.makeText(this@MainActivity,"没有查询到符合的人选",Toast.LENGTH_SHORT).show()
                        submitButton.doResult(false)
                    }
                    else {
                        submitButton.doResult(true)
                        list = response.body()!!.results
                        runOnUiThread { recyclerView.adapter = recAdapter(this@MainActivity, list) }
                    } }

                override fun onFailure(call: Call<info>, t: Throwable) {
                    submitButton.doResult(false)
                }
            })

        }
   }

    fun init(){
        retrofit=Retrofit.Builder()
            .baseUrl("http://120.79.143.238/cqupt/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api=retrofit.create(InfoService::class.java)
        list= listOf()
        recAdapter= recAdapter(this,list)
        recyclerView.adapter=recAdapter
        recyclerView.layoutManager= LinearLayoutManager(this) as RecyclerView.LayoutManager?
        textInputedix2.addTextChangedListener(this)
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        submitButton.reset()
    }
}
