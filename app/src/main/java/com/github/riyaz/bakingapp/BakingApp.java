package com.github.riyaz.bakingapp;

import android.app.Application;
import com.github.riyaz.bakingapp.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Android {@link Application} subclass for the Baking application
 *
 * @author Riyaz
 */
public final class BakingApp extends DaggerApplication {
  @Override protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerAppComponent.builder()
        .server(BuildConfig.SERVER)
        .create(this);
  }
}
