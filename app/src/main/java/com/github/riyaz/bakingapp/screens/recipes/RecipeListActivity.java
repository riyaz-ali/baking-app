package com.github.riyaz.bakingapp.screens.recipes;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.riyaz.bakingapp.R;
import com.github.riyaz.bakingapp.adapter.RecipeAdapter;
import com.github.riyaz.bakingapp.model.Recipe;
import dagger.android.support.DaggerAppCompatActivity;
import javax.inject.Inject;

public class RecipeListActivity extends DaggerAppCompatActivity implements RecipeAdapter.OnClickListener {
  // Log TAG
  private final static String TAG = RecipeListActivity.class.getSimpleName();

  @Inject ViewModelProvider.Factory vmFactory;

  @BindView(R.id.recipes)
    RecyclerView recipes;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recipe_list);
    ButterKnife.bind(this);

    // setup recipes adapter
    RecipeAdapter adapter =
        new RecipeAdapter(this, this);
    recipes.setAdapter(adapter);

    // setup recipes layout manager
    LinearLayoutManager layoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    recipes.setLayoutManager(layoutManager);

    RecipeListViewModel vm = ViewModelProviders.of(this, vmFactory).get(RecipeListViewModel.class);
  }

  @Override public void onRecipeClicked(@NonNull Recipe recipe) {
    Log.d(TAG, recipe.toString());
  }
}
