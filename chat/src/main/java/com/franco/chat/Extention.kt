package com.franco.chat.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.franco.chat.R

fun ViewGroup.inflar(@LayoutRes layoutRes:Int): View =
    LayoutInflater.from(context)
        .inflate(layoutRes,this,false)


inline fun <reified T: Activity> Context.startActivity(){
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}
