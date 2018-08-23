package com.github.riyaz.bakingapp.screens.steps;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.github.riyaz.bakingapp.R;
import com.github.riyaz.bakingapp.model.Recipe;
import com.github.riyaz.bakingapp.model.Step;
import com.github.riyaz.bakingapp.screens.steps.fragments.StepDetailFragment;
import com.github.riyaz.bakingapp.screens.steps.fragments.StepListFragment;
import dagger.android.support.DaggerAppCompatActivity;
import javax.inject.Inject;

public class StepsActivity extends DaggerAppCompatActivity {
  private static final String TAG = StepsActivity.class.getSimpleName();

  // arguments constant
  public static final String ARG_RECIPE = "arg-recipe";

  // keys
  private static final String FRAGMENT_STEP_LIST   = "fragment.list";
  private static final String FRAGMENT_STEP_DETAIL = "fragment.detail";

  // Injected recipe which we want to display
  @Inject Recipe recipe;
  @Inject StepsViewModel vm;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_steps);

    // running in tablet layout?
    boolean isTablet = getResources().getBoolean(R.bool.recipe_steps_is_tablet);

    if(!isTablet) {
      // not running in tablet mode
      // manage fragment transactions!
      vm.steps.observe(this, new Observer<Step>() {
        @Override public void onChanged(@Nullable Step step) {
          getSupportFragmentManager().beginTransaction()
              .replace(R.id.recipe_steps_container, StepDetailFragment.show(step))
              .addToBackStack(null)
              .commit();
        }
      });

      if (null == savedInstanceState) {
        // load steps container
        getSupportFragmentManager().beginTransaction()
            .add(R.id.recipe_steps_container, new StepListFragment())
            .commit();
      }
      // else The fragments will manage the clicks by themselves using the viewmodel
    }
  }
}
