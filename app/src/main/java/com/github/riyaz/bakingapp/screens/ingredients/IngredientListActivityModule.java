package com.github.riyaz.bakingapp.screens.ingredients;

import com.github.riyaz.bakingapp.model.Recipe;
import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for injecting into {@link IngredientListActivity}
 *
 * @author Riyaz
 */
@Module public class IngredientListActivityModule {
  // provide Recipe injection
  @Provides Recipe recipe(IngredientListActivity activity){
    return activity.getIntent().getParcelableExtra(IngredientListActivity.ARG_RECIPE);
  }
}
