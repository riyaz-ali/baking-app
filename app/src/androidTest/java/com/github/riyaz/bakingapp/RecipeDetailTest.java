package com.github.riyaz.bakingapp;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.github.riyaz.bakingapp.model.Recipe;
import com.github.riyaz.bakingapp.screens.steps.StepsActivity;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created on 23 Aug, 2018
 *
 * @author Riyaz
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecipeDetailTest {

  @Rule public ActivityTestRule<StepsActivity> activityTestRule =
      new InjectRecipeActivityTestRule<>(StepsActivity.class).provide(StepsActivity.ARG_RECIPE, createRecipe());

  public Recipe createRecipe() {
    try {
      return new GsonBuilder().create()
          .getAdapter(Recipe.class)
          .fromJson(new InputStreamReader(InstrumentationRegistry.getInstrumentation().getContext().getResources().openRawResource(
              com.github.riyaz.bakingapp.test.R.raw.recipe)));
    } catch (IOException ioe) {
      return null;
    }
  }

  @Test public void onStepClick_displayStepDetail(){
    // click a step
    onView(withId(R.id.recipe_steps))
        .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

    // check if details view is opened or not
    onView(withId(R.id.recipe_detail_video))
        .check(matches(isDisplayed()));
  }
}
