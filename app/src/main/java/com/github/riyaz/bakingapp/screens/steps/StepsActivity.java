package com.github.riyaz.bakingapp.screens.steps;

import android.os.Bundle;
import com.github.riyaz.bakingapp.R;
import com.github.riyaz.bakingapp.model.Recipe;
import dagger.android.support.DaggerAppCompatActivity;
import javax.inject.Inject;

public class StepsActivity extends DaggerAppCompatActivity {
  private static final String TAG = StepsActivity.class.getSimpleName();

  // arguments constant
  public static final String ARG_RECIPE = "arg-recipe";

  // Injected recipe which we want to display
  @Inject Recipe recipe;

  @Inject StepsViewModel vm;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_steps);


  }
}
