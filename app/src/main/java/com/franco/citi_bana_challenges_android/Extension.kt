package com.franco.citi_bana_challenges_android

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView

fun ViewGroup.inflate(@LayoutRes layoutRes:Int):View=
      LayoutInflater.from(context)
         .inflate(R.layout.item_main_menu_recycler,this,false)


inline fun <reified T: Activity> Context.startActivity(){
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}

//fun DataBindingUtil.content(context: Context,@LayoutRes layoutRes:Int){
//    setContentView(context as Activity,layoutRes)
//
//}