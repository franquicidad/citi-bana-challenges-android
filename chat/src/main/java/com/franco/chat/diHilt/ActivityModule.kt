package com.franco.chat.diHilt

import com.franco.chat.simNetwork.ApiService
import com.franco.chat.simNetwork.ApiServiceImpl
import com.franco.chat.simNetwork.UserRemoteDataSource
import com.franco.data.IUserRepository
import com.franco.data.UserRepository
import com.franco.data.sources.RemoteDataSourceSim
import com.franco.usecases.GetAllUsersUseCase
import com.franco.usecases.IGetAllUsersUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class ActivityModule {
@Binds
abstract fun bindRepository(userRepository: UserRepository):IUserRepository
@Binds
abstract fun bindApi(apiServiceImpl: ApiServiceImpl):ApiService
@Binds
abstract fun bindRemoteDatasource(apiServiceImpl: UserRemoteDataSource): RemoteDataSourceSim
@Binds
abstract fun bindUseCase(getallUser: GetAllUsersUseCase): IGetAllUsersUseCase


}