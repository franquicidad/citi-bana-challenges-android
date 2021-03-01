package com.franco.chat

import android.app.Application
import com.franco.chat.di.MyChatComponent
import dagger.internal.DaggerCollections

class ChatApplication:Application() {

    lateinit var component: MyChatComponent
    private set

    override fun onCreate() {
        super.onCreate()

    }
}