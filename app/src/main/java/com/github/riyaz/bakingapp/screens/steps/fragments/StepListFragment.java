package com.github.riyaz.bakingapp.screens.steps.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.riyaz.bakingapp.R;
import com.github.riyaz.bakingapp.adapter.StepsAdapter;
import com.github.riyaz.bakingapp.model.Recipe;
import com.github.riyaz.bakingapp.model.Step;
import com.github.riyaz.bakingapp.screens.steps.StepsViewModel;
import dagger.android.support.DaggerFragment;
import javax.inject.Inject;

/**
 * {@link Fragment} to display list of steps
 */
public class StepListFragment extends DaggerFragment implements StepsAdapter.OnClickListener {

  // Injected
  @Inject Recipe recipe;
  @Inject StepsViewModel vm;

  // UI Components
  @BindView(R.id.recipe_steps) RecyclerView steps;

  public StepListFragment() {
  }

  @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_step_list, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onResume() {
    super.onResume();

    steps.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    steps.setAdapter(new StepsAdapter(getContext(), this, recipe.getSteps()));
  }

  @Override public void onClick(@NonNull Step step) {
    vm.steps.setValue(step);
  }
}
