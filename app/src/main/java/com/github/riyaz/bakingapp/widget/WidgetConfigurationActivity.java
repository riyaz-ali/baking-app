package com.github.riyaz.bakingapp.widget;

import android.appwidget.AppWidgetManager;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.riyaz.bakingapp.R;
import com.github.riyaz.bakingapp.adapter.RecipeAdapter;
import com.github.riyaz.bakingapp.model.Recipe;
import com.github.riyaz.bakingapp.screens.recipes.RecipeListViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dagger.android.support.DaggerAppCompatActivity;
import java.util.List;
import javax.inject.Inject;

public class WidgetConfigurationActivity extends DaggerAppCompatActivity implements RecipeAdapter.OnClickListener {

  @Inject ViewModelProvider.Factory vmFactory;
  @Inject Gson gson;

  @BindView(R.id.recipes)
    RecyclerView recipes;

  // widget id
  int appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recipe_list);
    ButterKnife.bind(this);

    setResult(RESULT_CANCELED);

    Intent intent = getIntent();
    Bundle extras = intent.getExtras();

    if (extras != null) {
      appWidgetId = extras.getInt(
          AppWidgetManager.EXTRA_APPWIDGET_ID,
          AppWidgetManager.INVALID_APPWIDGET_ID);

      if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
        finish();
      }
    }

    // setup recipes adapter
    final RecipeAdapter adapter =
        new RecipeAdapter(this, this);
    recipes.setAdapter(adapter);

    // setup recipes layout manager
    LinearLayoutManager layoutManager =
        new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    recipes.setLayoutManager(layoutManager);

    // get the viewmodel and start fetching recipes
    RecipeListViewModel vm = ViewModelProviders.of(this, vmFactory).get(RecipeListViewModel.class);
    vm.recipes.observe(this, new Observer<List<Recipe>>() {
      @Override public void onChanged(@Nullable List<Recipe> recipes) {
        adapter.clear();
        adapter.addAll(recipes);
      }
    });
  }

  @Override public void onRecipeClicked(@NonNull Recipe recipe) {
    // persist the recipe object's json in shared preference
    String recipeJSON = gson.getAdapter(new TypeToken<Recipe>(){}.getRawType()).toJson(recipe);
    PreferenceManager.getDefaultSharedPreferences(getApplicationContext())
        .edit().putString(appWidgetId + "", recipeJSON).apply();

    // update the widget
    WidgetProvider.updateWidget(getApplicationContext(),
        AppWidgetManager.getInstance(getApplicationContext()), appWidgetId, recipe);

    // mark configuration as done
    Intent result = new Intent();
    result.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
    setResult(RESULT_OK, result);
    finish();
  }
}