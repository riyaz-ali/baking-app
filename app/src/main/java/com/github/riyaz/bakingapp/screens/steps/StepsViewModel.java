package com.github.riyaz.bakingapp.screens.steps;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.github.riyaz.bakingapp.model.Step;
import javax.inject.Inject;

/**
 * {@link ViewModel} for Steps
 *
 * @author Riyaz
 */
public class StepsViewModel extends ViewModel {

  public final MutableLiveData<Step> steps = new MutableLiveData<>();

  @Inject public StepsViewModel(){
  }
}
