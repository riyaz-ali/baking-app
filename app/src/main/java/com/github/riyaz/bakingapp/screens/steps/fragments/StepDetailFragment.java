package com.github.riyaz.bakingapp.screens.steps.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.riyaz.bakingapp.R;
import com.github.riyaz.bakingapp.model.Step;
import com.github.riyaz.bakingapp.screens.steps.StepsViewModel;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.squareup.picasso.Picasso;
import dagger.android.support.DaggerFragment;
import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class StepDetailFragment extends DaggerFragment {

  private static final String KEY_PLAY_WHEN_READY = "play_when_ready";
  private static final String KEY_WINDOW = "window";
  private static final String KEY_POSITION = "position";

  public StepDetailFragment() {
  }

  // injected
  @Inject StepsViewModel vm;

  @BindView(R.id.recipe_detail_video) PlayerView videoPlayerView;
  @BindView(R.id.recipe_step) TextView stepDescription;

  public static StepDetailFragment show(@NonNull Step step){
    StepDetailFragment fragment = new StepDetailFragment();
    Bundle args = new Bundle();
    args.putParcelable("STEP", step);
    fragment.setArguments(args);
    return fragment;
  }

  // player
  private SimpleExoPlayer player;

  // player state
  private boolean playWhenReady;
  private int currentWindow;
  private long playbackPosition;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if(savedInstanceState == null){
      // new instance
      playWhenReady = true;
      currentWindow = 0;
      playbackPosition = 0;
    } else {
      playWhenReady = savedInstanceState.getBoolean(KEY_PLAY_WHEN_READY);
      currentWindow = savedInstanceState.getInt(KEY_WINDOW);
      playbackPosition = savedInstanceState.getLong(KEY_POSITION);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_step_detail, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onStart() {
    super.onStart();
    if(Util.SDK_INT > 23){
      display(getStep());
    }
  }

  @Override public void onResume() {
    super.onResume();
    if(Util.SDK_INT <= 23 || player == null){
      display(getStep());
    }
  }

  @Override public void onPause() {
    super.onPause();
    if(Util.SDK_INT <= 23){
      release();
    }
  }

  @Override public void onStop() {
    super.onStop();
    if(Util.SDK_INT > 23){
      release();
    }
  }

  @Override public void onSaveInstanceState(@NonNull Bundle outState) {
    // save player state
    playbackPosition = player.getCurrentPosition();
    currentWindow = player.getCurrentWindowIndex();
    playWhenReady = player.getPlayWhenReady();

    outState.putBoolean(KEY_PLAY_WHEN_READY, playWhenReady);
    outState.putInt(KEY_WINDOW, currentWindow);
    outState.putLong(KEY_POSITION, playbackPosition);

    super.onSaveInstanceState(outState);
  }

  private void display(@NonNull Step step){
    // set description
    stepDescription.setText(step.getDescription());
    // return early if no video is present
    if(TextUtils.isEmpty(step.getVideo())) {
      getView().findViewById(R.id.recipe_detail_video_container).setVisibility(View.GONE);

      if(TextUtils.isEmpty(step.getThumbnail())) {
        // no image! hide the container
        getView().findViewById(R.id.recipe_detail_media_container).setVisibility(View.GONE);
      }
    }

    // load the image
    if(!TextUtils.isEmpty(step.getThumbnail())) {
      Picasso.with(getContext())
          .load(step.getThumbnail())
          .error(R.drawable.broken)
          .into((ImageView) getView().findViewById(R.id.recipe_detail_image));
    }

    // create the player
    player = ExoPlayerFactory.newSimpleInstance(getContext(), new DefaultTrackSelector());

    player.setPlayWhenReady(playWhenReady);
    videoPlayerView.requestFocus();
    videoPlayerView.setPlayer(player);

    // create a data source
    DataSource.Factory dataSourceFactory = new DefaultHttpDataSourceFactory(
        Util.getUserAgent(getContext(), getString(R.string.app_name))
    );

    MediaSource videoSource = new ExtractorMediaSource.Factory(dataSourceFactory)
        .createMediaSource(Uri.parse(step.getVideo()));

    boolean haveStartPosition = currentWindow != C.INDEX_UNSET;
    if (haveStartPosition) {
      player.seekTo(currentWindow, playbackPosition);
    }

    // add source to player
    player.prepare(videoSource, !haveStartPosition, false);
  }

  private void release(){
    if (player != null) {
      playbackPosition = player.getCurrentPosition();
      currentWindow = player.getCurrentWindowIndex();
      playWhenReady = player.getPlayWhenReady();
      player.release();
      player = null;
    }
  }

  @NonNull private Step getStep(){
    return getArguments().getParcelable("STEP");
  }
}
