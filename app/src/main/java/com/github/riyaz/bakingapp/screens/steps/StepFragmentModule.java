package com.github.riyaz.bakingapp.screens.steps;

import com.github.riyaz.bakingapp.screens.steps.fragments.StepDetailFragment;
import com.github.riyaz.bakingapp.screens.steps.fragments.StepListFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Dagger Module to provide injection support in Fragments in the steps view
 *
 * @author Riyaz
 */
@Module public abstract class StepFragmentModule {

  @ContributesAndroidInjector
  abstract StepListFragment bindStepListFragment();

  @ContributesAndroidInjector
  abstract StepDetailFragment bindStepDetailFragment();
}
