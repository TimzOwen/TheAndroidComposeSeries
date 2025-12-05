package com.example.happybirthdaycard

import android.app.Application
import com.example.happybirthdaycard.network.GoogleBooksService
import com.example.happybirthdaycard.network.provideHttpClient
import com.example.happybirthdaycard.repository.BooksRepository
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

// DI injection setup
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModules())
        }
    }
}

private fun appModules() = listOf(
    module {
        single { provideHttpClient() }
        single { GoogleBooksService(get()) }
        single { BooksRepository(get()) }
    },
    module {
        viewModel<com.example.happybirthdaycard.ui.books.BooksViewModel> { com.example.happybirthdaycard.ui.books.BooksViewModel(get()) }
    }
)
