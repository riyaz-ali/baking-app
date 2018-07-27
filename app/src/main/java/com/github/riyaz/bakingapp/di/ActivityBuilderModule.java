package com.github.riyaz.bakingapp.di;

import com.github.riyaz.bakingapp.screens.recipes.RecipeListActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Dagger module to facilitate dagger in injecting Android platform managed classes
 *
 * @author Riyaz
 */
@Module public abstract class ActivityBuilderModule {
  // [target]: RecipeListActivity
  @ContributesAndroidInjector abstract RecipeListActivity bindRecipeListActivity();
}
