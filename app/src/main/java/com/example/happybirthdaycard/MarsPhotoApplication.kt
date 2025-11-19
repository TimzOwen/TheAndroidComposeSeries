package com.example.happybirthdaycard

import android.app.Application
import com.example.happybirthdaycard.data.AppContainer
import com.example.happybirthdaycard.data.DefaultAppContainer

class MarsPhotoApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}