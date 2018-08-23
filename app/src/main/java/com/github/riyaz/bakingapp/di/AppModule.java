package com.github.riyaz.bakingapp.di;

import android.content.Context;
import com.github.riyaz.bakingapp.BakingApp;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module to provide Android 'contextual' objects
 *
 * @author Riyaz
 */
@Module public class AppModule {
  @Singleton @Provides Context provideContext(BakingApp application){
    return application;
  }
}
