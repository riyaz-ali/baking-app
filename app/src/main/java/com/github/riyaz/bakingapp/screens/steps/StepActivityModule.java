package com.github.riyaz.bakingapp.screens.steps;

import android.arch.lifecycle.ViewModelProviders;
import com.github.riyaz.bakingapp.model.Recipe;
import com.github.riyaz.bakingapp.screens.ViewModelBakery;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger module to inject into {@link StepsActivity}
 *
 * @author Riyaz
 */
@Module public class StepActivityModule {

  @Provides Recipe provideRecipe(StepsActivity activity){
    return activity.getIntent().getParcelableExtra(StepsActivity.ARG_RECIPE);
  }

  @Provides StepsViewModel provideViewModel(ViewModelBakery bakery, StepsActivity activity){
    return ViewModelProviders.of(activity, bakery).get(StepsViewModel.class);
  }
}
