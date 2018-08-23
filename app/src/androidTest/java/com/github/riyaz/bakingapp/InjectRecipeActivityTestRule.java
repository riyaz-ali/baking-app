package com.github.riyaz.bakingapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import com.github.riyaz.bakingapp.model.Recipe;

/**
 * Created on 23 Aug, 2018
 *
 * @author Riyaz
 */
public class InjectRecipeActivityTestRule<T extends Activity> extends ActivityTestRule<T> {

  private Class<T> activityClass;
  private String extrasToUse;
  private Recipe recipeToProvide;

  public InjectRecipeActivityTestRule(Class<T> activityClass) {
    super(activityClass);
    this.activityClass = activityClass;
  }

  public InjectRecipeActivityTestRule<T> provide(@NonNull String extra, @NonNull Recipe recipe){
    this.extrasToUse = extra;
    this.recipeToProvide = recipe;
    return this;
  }

  @Override protected Intent getActivityIntent() {
    // get the context
    Context target = InstrumentationRegistry.getInstrumentation().getTargetContext();
    // create new Intent
    return new Intent(target, activityClass)
        .putExtra(extrasToUse, recipeToProvide);
  }
}
