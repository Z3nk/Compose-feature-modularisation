package fr.zunkit.logpadv3

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import fr.zunkit.navigation.NavigationManager
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesNavigationManager() = NavigationManager()
}