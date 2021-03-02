package com.franco.chat

import android.app.Application
import com.franco.chat.di.DaggerMyChatComponent
import com.franco.chat.di.MyChatComponent
import dagger.hilt.android.HiltAndroidApp
import dagger.internal.DaggerCollections

@HiltAndroidApp
class ChatApplication:Application() {

//    lateinit var component: MyChatComponent
//    private set
//
//    override fun onCreate() {
//        super.onCreate()
//
//        component = DaggerMyChatComponent.factory().create(this)
//
//    }
}