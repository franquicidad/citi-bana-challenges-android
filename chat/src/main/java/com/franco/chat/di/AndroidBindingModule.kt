package com.franco.chat.di

import com.franco.chat.ui.ChatActivity
import com.franco.usecases.GetAllUsersUseCase
import com.franco.usecases.InterfaceGetAllUsersUseCase
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun chatActivity() : ChatActivity
}