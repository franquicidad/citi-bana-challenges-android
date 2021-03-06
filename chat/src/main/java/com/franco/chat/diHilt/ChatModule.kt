package com.franco.chat.diHilt

import com.franco.chat.simNetwork.ApiService
import com.franco.chat.simNetwork.ApiServiceImpl
import com.franco.chat.simNetwork.UserRemoteDataSource
import com.franco.chat.ui.MainPresenter
import com.franco.data.sources.RemoteDataSourceSim
import com.franco.data.UserRepository
import com.franco.usecases.GetAllUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class ChatModule {
/*
    @Singleton
    @Provides
    fun providesApiService(): ApiService{
        return ApiServiceImpl()
    }

    @Provides
    fun remoteDataSourceProvider(apiService: ApiService) : RemoteDataSourceSim =  UserRemoteDataSource(apiService)

    @Provides
    fun UserRepositoryProvider( remoteUserDataSource: RemoteDataSourceSim) = UserRepository(remoteUserDataSource)*/

/*    @Provides
    fun provideUseCase(userRepository: UserRepository):GetAllUsersUseCase=GetAllUsersUseCase(userRepository)*/
/*@Provides
fun providePresenter(getAllUsersUseCase: GetAllUsersUseCase)= MainPresenter(getAllUsersUseCase)*/

}