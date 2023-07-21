package uz.nabijonov.otabek.todoapp_bek.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.nabijonov.otabek.todoapp_bek.data.source.local.dao.TodoDao
import uz.nabijonov.otabek.todoapp_bek.data.source.local.db.AppDatabase
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @[Provides Singleton]
    fun provideDB(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "contacts"
    ).allowMainThreadQueries().build()

    @[Provides Singleton]
    fun provideContactDao(db: AppDatabase): TodoDao = db.getContactDao()
}