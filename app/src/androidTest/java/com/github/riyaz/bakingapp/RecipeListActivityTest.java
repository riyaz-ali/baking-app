package com.github.riyaz.bakingapp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.github.riyaz.bakingapp.screens.recipes.RecipeListActivity;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
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
public class RecipeListActivityTest {

  @Rule public ActivityTestRule<RecipeListActivity> activityTestRule
      = new ActivityTestRule<>(RecipeListActivity.class);

  private IdlingResource idlingResource;

  @Before public void registerIdlingResource(){
    idlingResource = activityTestRule.getActivity().getIdlingResource();
    Espresso.registerIdlingResources(idlingResource);
  }

  @Test public void onRecipeClick_openRecipeIngredientActivity(){
    // click an item in recyclerview
    onView(withId(R.id.recipes))
        .perform(RecyclerViewActions.actionOnItemAtPosition(0, ViewActions.click()));

    // check if ingredients activity is displayed or not
    onView(withId(R.id.start_recipe))
        .check(matches(isDisplayed()));
  }

  @After public void unregisterIdlingResource(){
    if(null != idlingResource)
      Espresso.unregisterIdlingResources(idlingResource);
  }
}