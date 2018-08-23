package com.github.riyaz.bakingapp.screens;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/**
 * Factory class for {@link ViewModel} to allow Dagger injections
 *
 * @author Riyaz
 */
@Singleton public class ViewModelBakery implements ViewModelProvider.Factory {
  // view model provider collection
  private Map<Class<? extends ViewModel>, Provider<ViewModel>> models;

  @Inject ViewModelBakery(@NonNull Map<Class<? extends ViewModel>, Provider<ViewModel>> models){
    this.models = models;
  }

  @NonNull @Override public <T extends ViewModel> T create(@NonNull Class<T> klass) {
    if(null != models.get(klass)){
      return klass.cast(models.get(klass).get());
    } else {
      throw new IllegalArgumentException("unknown model class '" + klass + "'");
    }
  }
}
