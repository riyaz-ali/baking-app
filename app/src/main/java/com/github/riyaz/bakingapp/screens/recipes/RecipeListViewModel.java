package com.github.riyaz.bakingapp.screens.recipes;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import com.github.riyaz.bakingapp.model.Recipe;
import com.github.riyaz.bakingapp.net.RecipeService;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * {@link ViewModel} class for the {@link RecipeListActivity}
 *
 * @author Riyaz
 */
public class RecipeListViewModel extends ViewModel implements Callback<List<Recipe>>{

  // Log TAG
  private static final String TAG = RecipeListViewModel.class.getSimpleName();

  // recipes stream
  public final MutableLiveData<List<Recipe>> recipes = new MutableLiveData<>();

  // idling resource
  private final RecipeListIdlingResource idlingResource;

  @Inject RecipeListViewModel(RecipeService service, RecipeListIdlingResource idlingResource){
    // start fetching the recipes right away
    this.idlingResource  = idlingResource;
    this.idlingResource.setIdle(false);
    service.recipes().enqueue(this);
  }

  @Override public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
    idlingResource.setIdle(true);
    if(response.isSuccessful()){
      List<Recipe> _recipes = response.body();
      if(null != _recipes)
        recipes.setValue(_recipes);
    }
  }

  @Override public void onFailure(Call<List<Recipe>> call, Throwable t) {
    Log.e(TAG, "Failed to fetch recipes", t);
  }
}
