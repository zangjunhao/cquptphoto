package com.example.cquptphoto.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.cquptphoto.ui.Particulars
import com.example.cquptphoto.R
import com.example.cquptphoto.bean.info

class recAdapter: RecyclerView.Adapter<recAdapter.MyViewHolder> {
    lateinit var context: Context
    lateinit var list:List<info.ResultsBean>
    constructor(context:Context,list:List<info.ResultsBean>){
        this.context=context
        this.list=list
    }
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main,p0,false))
    }

    override fun getItemCount(): Int{
        return list.size as Int
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        p0.name.text=list[p1].name
        p0.stuNum.text=list[p1].stuNum
        p0.academy.text=list[p1].academy
        p0.classNum.text=list[p1].classNum
        p0.birthday.text=list[p1].birthday
        p0.theView.setOnClickListener {
            var intent :Intent=Intent(context, Particulars::class.java)
            var bundle=Bundle()
            bundle.putString("name",list[p1].name)
            bundle.putString("stuNum",list[p1].stuNum)
            bundle.putString("academy",list[p1].academy)
            bundle.putString("classNum",list[p1].classNum)
            bundle.putString("birthday",list[p1].birthday)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }


    class MyViewHolder: RecyclerView.ViewHolder{
        lateinit var name:TextView
        lateinit var stuNum:TextView
        lateinit var classNum:TextView
        lateinit var academy:TextView
        lateinit var birthday:TextView
        lateinit var theView: ConstraintLayout
        constructor(view: View):super(view){
            name=view.findViewById(R.id.name) as TextView
            stuNum=view.findViewById(R.id.stuNum) as TextView
            classNum = view.findViewById(R.id.classNum) as TextView
            academy = view.findViewById(R.id.academy) as TextView
            birthday = view.findViewById(R.id.birthday) as TextView
            theView=view as ConstraintLayout
        }
    }
}