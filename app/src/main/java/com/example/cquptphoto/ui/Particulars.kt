package com.example.cquptphoto.ui

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import com.bumptech.glide.Glide
import com.example.cquptphoto.R
import kotlinx.android.synthetic.main.activity_particulars.*

class Particulars : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_particulars)
        if (Build.VERSION.SDK_INT >= 21) {
            var option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        }
        var bundle=this.intent.extras
        name.text=bundle.get("name").toString()
        academy.text=bundle.get("academy").toString()
        birthday.text=bundle.get("birthday").toString()
        classNum.text=bundle.get("classNum").toString()
        stuNum.text=bundle.get("stuNum").toString()
        Glide.with(this).load("http://jwzx.cqu.pt/showstupic.php?xh=${bundle.get("stuNum").toString()}").into(imageView)
        imageView.setOnClickListener {
            var intent1=Intent(this,PhotoActivity::class.java)
            var transitionActivityOptions= ActivityOptions.makeSceneTransitionAnimation(this,imageView,"photo")
            intent1.putExtra("Photo","http://jwzx.cqu.pt/showstupic.php?xh=${bundle.get("stuNum").toString()}")
            startActivity(intent1,transitionActivityOptions.toBundle())
        }
    }
}
