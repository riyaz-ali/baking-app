package com.github.riyaz.bakingapp.net;

import com.github.riyaz.bakingapp.model.Recipe;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * REST service interface implemented by retrofit
 *
 * @author Riyaz
 */
public interface RecipeService {
  /**
   * Get all recipes from the server
   *
   * @return Call that resolves to List of Recipe objects
   */
  @GET("android-baking-app-json") Call<List<Recipe>> recipes();
}
