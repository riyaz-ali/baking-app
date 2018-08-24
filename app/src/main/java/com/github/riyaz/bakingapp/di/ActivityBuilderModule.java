package com.github.riyaz.bakingapp.di;

import com.github.riyaz.bakingapp.screens.ingredients.IngredientListActivity;
import com.github.riyaz.bakingapp.screens.ingredients.IngredientListActivityModule;
import com.github.riyaz.bakingapp.screens.recipes.RecipeListActivity;
import com.github.riyaz.bakingapp.screens.steps.StepActivityModule;
import com.github.riyaz.bakingapp.screens.steps.StepFragmentModule;
import com.github.riyaz.bakingapp.screens.steps.StepsActivity;
import com.github.riyaz.bakingapp.widget.WidgetConfigurationActivity;
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
  // [target]: IngredientListActivity
  @ContributesAndroidInjector(modules = { IngredientListActivityModule.class })
    abstract IngredientListActivity bindIngredientListActivity();
  // [target]: StepsActivity
  @ContributesAndroidInjector(modules = { StepActivityModule.class, StepFragmentModule.class }) abstract StepsActivity bindStepsActivity();
  // [target]: WidgetConfigurationActivity
  @ContributesAndroidInjector abstract WidgetConfigurationActivity bindWidgetConfigurationActivity();
}
