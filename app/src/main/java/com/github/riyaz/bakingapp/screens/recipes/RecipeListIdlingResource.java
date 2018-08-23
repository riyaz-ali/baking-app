package com.github.riyaz.bakingapp.screens.recipes;

import android.support.annotation.Nullable;
import android.support.test.espresso.IdlingResource;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created on 23 Aug, 2018
 *
 * @author Riyaz
 */
@Singleton
public class RecipeListIdlingResource implements IdlingResource {

  @Nullable
  private ResourceCallback callback;

  // state
  private AtomicBoolean idle = new AtomicBoolean(true);

  @Inject public RecipeListIdlingResource(){
  }

  @Override public String getName() {
    return RecipeListIdlingResource.class.getName();
  }

  @Override public boolean isIdleNow() {
    return idle.get();
  }

  @Override public void registerIdleTransitionCallback(ResourceCallback callback) {
    this.callback = callback;
  }

  public void setIdle(boolean state){
    idle.set(state);
    if(state && callback != null){
      callback.onTransitionToIdle();
    }
  }
}
