package com.github.riyaz.bakingapp.screens.ingredients;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.github.riyaz.bakingapp.R;
import com.github.riyaz.bakingapp.adapter.IngredientAdapter;
import com.github.riyaz.bakingapp.model.Recipe;
import dagger.android.support.DaggerAppCompatActivity;
import javax.inject.Inject;

public class IngredientListActivity extends DaggerAppCompatActivity {

  // Key constants for passing down arguments
  public static final String ARG_RECIPE = IngredientListActivity.class.getSimpleName() + ".RECIPE";

  // Recipe for which we need to display the ingredients
  @Inject Recipe recipe;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ingredient_list);

    ButterKnife.bind(this);

    // prepare recyclerview
    RecyclerView ingredients = findViewById(R.id.ingredients);

    // create adapter
    IngredientAdapter adapter = new IngredientAdapter(recipe.getIngredients());
    ingredients.setAdapter(adapter);

    // create layout manager
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    ingredients.setLayoutManager(linearLayoutManager);
  }

  @OnClick(R.id.start_recipe) public void onStartRecipe(Button ignored){
    Toast.makeText(this, "TODO", Toast.LENGTH_SHORT).show();
  }
}
