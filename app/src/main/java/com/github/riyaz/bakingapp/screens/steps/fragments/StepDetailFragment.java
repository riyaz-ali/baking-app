package com.github.riyaz.bakingapp.screens.steps.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.riyaz.bakingapp.R;
import com.github.riyaz.bakingapp.model.Step;
import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepDetailFragment extends DaggerFragment {

  public StepDetailFragment() {
  }

  public static StepDetailFragment show(@NonNull Step step){
    StepDetailFragment fragment = new StepDetailFragment();
    Bundle args = new Bundle();
    args.putParcelable("STEP", step);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_step_detail, container, false);
  }

  @Override public void onResume() {
    super.onResume();

    Step step = getArguments().getParcelable("STEP");
    Log.d("StepDetail", step.toString());
  }
}
