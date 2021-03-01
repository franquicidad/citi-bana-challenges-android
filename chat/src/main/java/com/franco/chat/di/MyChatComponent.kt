package com.franco.chat.di

import com.franco.chat.ChatApplication
import com.franco.chat.ui.MainPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,UseCaseModule::class])
interface MyChatComponent {

    val chatPresenter:MainPresenter

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance app:ChatApplication): MyChatComponent
    }
}