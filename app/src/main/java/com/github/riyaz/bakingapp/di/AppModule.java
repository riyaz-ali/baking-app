package com.github.riyaz.bakingapp.di;

import android.content.Context;
import com.github.riyaz.bakingapp.BakingApp;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger module to provide Android 'contextual' objects
 *
 * @author Riyaz
 */
@Module public class AppModule {
  @Provides Context provideContext(BakingApp application){
    return application;
  }
}
