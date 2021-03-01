package com.franco.chat.di

import com.franco.chat.simNetwork.ApiService
import com.franco.chat.simNetwork.ApiServiceImpl
import com.franco.chat.simNetwork.UserRemoteDataSource
import com.franco.data.RemoteDataSourceSim
import com.franco.usecases.GetAllUsersUseCase
import com.franco.usecases.InterfaceGetAllUsersUseCase
import dagger.Binds
import dagger.Module

@Module
abstract class UseCaseModule {

    @Binds
    abstract fun BindUseCase(getAllUsersUseCase: GetAllUsersUseCase):InterfaceGetAllUsersUseCase

    @Binds
    abstract fun BindsApiService(apiServiceImpl: ApiServiceImpl):ApiService
    @Binds
    abstract fun BindsRemoteDatasource(userRemoteDataSource: UserRemoteDataSource):RemoteDataSourceSim

}



