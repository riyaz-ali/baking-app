package com.github.riyaz.bakingapp.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.github.riyaz.bakingapp.screens.ViewModelBakery;
import com.github.riyaz.bakingapp.screens.recipes.RecipeListViewModel;
import com.github.riyaz.bakingapp.screens.steps.StepsViewModel;
import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.multibindings.IntoMap;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// internal annotation
// to mark view model key
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@MapKey @interface ViewModelKey {
  Class<? extends ViewModel> value();
}

/**
 * Dagger module to provide injection support in framework-managed {@link ViewModel} class
 * @author Riyaz
 */
@Module public abstract class ViewModelModule {

  // binds the custom factory instance
  @Binds abstract ViewModelProvider.Factory bindViewModelBakeryToFactory(ViewModelBakery bakery);

  // [target]: RecipeListViewModel
  @Binds
  @IntoMap
  @ViewModelKey(RecipeListViewModel.class) abstract ViewModel recipeListViewModel(RecipeListViewModel viewModel);

  // [target]: StepsViewModel
  @Binds
  @IntoMap
  @ViewModelKey(StepsViewModel.class) abstract ViewModel stepsViewModel(StepsViewModel viewModel);
}
