package com.github.riyaz.bakingapp.screens.recipes;

import android.arch.lifecycle.ViewModel;
import android.util.Log;
import com.github.riyaz.bakingapp.net.RecipeService;
import javax.inject.Inject;

/**
 * {@link ViewModel} class for the {@link RecipeListActivity}
 *
 * @author Riyaz
 */
public class RecipeListViewModel extends ViewModel {
  @Inject RecipeListViewModel(RecipeService service){
    Log.d("ViewModel", service.toString());
  }
}
