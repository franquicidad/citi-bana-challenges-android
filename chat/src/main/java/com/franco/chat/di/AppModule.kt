package com.franco.chat.di

import com.franco.chat.ui.MainPresenter
import com.franco.data.RemoteDataSourceSim
import com.franco.data.UserRepository
import com.franco.usecases.GetAllUsersUseCase
import dagger.Module
import dagger.Provides
//
//@Module
//class AppModule {
//
//    @Provides
//    fun repositoryProvides(
//        remoteDataSourceSim: RemoteDataSourceSim
//    ) =UserRepository(remoteDataSourceSim)
//
//    @Provides
//    fun getAllUseCaseProvider(userRepository: UserRepository)= GetAllUsersUseCase(userRepository)
//
//    @Provides
//    fun mainPresenterProvider(getAllUsersUseCase: InterfaceGetAllUsersUseCase)= MainPresenter(getAllUsersUseCase)
//}