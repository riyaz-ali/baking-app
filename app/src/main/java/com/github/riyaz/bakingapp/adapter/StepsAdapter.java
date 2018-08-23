package com.github.riyaz.bakingapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.riyaz.bakingapp.R;
import com.github.riyaz.bakingapp.model.Step;
import com.pascalwelsch.arrayadapter.ArrayAdapter;
import java.util.List;

/**
 * Created on 22 Aug, 2018
 *
 * @author Riyaz
 */
public final class StepsAdapter extends ArrayAdapter<Step, StepsAdapter.ViewHolder> {

  // View holder impl
  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(android.R.id.text1)
    TextView title;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      itemView.setOnClickListener(this);
    }

    void bind(@NonNull Step step){
      title.setText(step.getShortDescription());
    }

    @Override public void onClick(View v) {
      clickListener.onClick(getItem(getAdapterPosition()));
    }
  }

  public interface OnClickListener {
    void onClick(@NonNull Step step);
  }

  // inflater
  private LayoutInflater inflater;
  // click listener
  private OnClickListener clickListener;

  public StepsAdapter(@NonNull Context context,
      @NonNull OnClickListener clickListener,
      @NonNull List<Step> data){
    super(data);
    this.inflater = LayoutInflater.from(context);
    this.clickListener = clickListener;
  }

  @Override public Object getItemId(@NonNull Step item) {
    return item.getId();
  }

  @NonNull @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ViewHolder(inflater.inflate(R.layout.adapter_step, parent, false));
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    //noinspection ConstantConditions
    holder.bind(getItem(position));
  }

}
