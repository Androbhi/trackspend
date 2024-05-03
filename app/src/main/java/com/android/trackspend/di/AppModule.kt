package com.android.trackspend.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.trackspend.data.remote.apiservice.ApiService
import com.android.trackspend.data.remote.interceptors.HeaderInterceptor
import com.android.track_spend.BuildConfig
import com.android.trackspend.data.local.TrackSpendDao
import com.android.trackspend.data.local.TrackSpendDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesApiService(
        headerInformationInterceptor: HeaderInterceptor
    ): ApiService {
        return with(Retrofit.Builder()) {
            client(
                OkHttpClient
                    .Builder().apply {
                        if (BuildConfig.DEBUG) {
                            addInterceptor(
                                HttpLoggingInterceptor().apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                })
                        }
                        addInterceptor(headerInformationInterceptor)
                    }.build()
            )
            addConverterFactory(GsonConverterFactory.create())
            baseUrl(BuildConfig.BASE_URL)
        }.build().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesDataBase(
        @ApplicationContext context: Context
    ): RoomDatabase{
        return Room.databaseBuilder(
            context = context,
            klass = TrackSpendDataBase::class.java,
            name = "TrackSpendDataBase"
        ).build()
    }

    @Provides
    @Singleton
    fun providesTrackSpendDao(
        dataBase: TrackSpendDataBase
    ): TrackSpendDao{
        return dataBase.trackSpendDao()
    }

}