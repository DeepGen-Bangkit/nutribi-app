package com.bangkit.nutribiapp

import android.app.Application
import com.bangkit.nutribiapp.di.networkModule
import com.bangkit.nutribiapp.di.repositoryModule
import com.bangkit.nutribiapp.di.viewModelModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

@FlowPreview
@ExperimentalCoroutinesApi
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
//                    databaseModule,
                    networkModule,
                    repositoryModule,
//                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}