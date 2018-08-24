package com.github.riyaz.bakingapp.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.riyaz.bakingapp.model.Ingredient;
import com.pascalwelsch.arrayadapter.ArrayAdapter;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} for displaying {@link Ingredient}
 *
 * @author Riyaz
 */
public class IngredientAdapter extends ArrayAdapter<Ingredient, IngredientAdapter.ViewHolder> {

  // ViewHolder impl
  class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(android.R.id.text1)
      TextView title;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }

    @SuppressLint("DefaultLocale") void bind(@NonNull Ingredient ingredient){
      title.setText(String.format("- %s (%.1f %s)", ingredient.getName(), ingredient.getQuantity(), ingredient.getMeasure()));
    }
  }

  public IngredientAdapter(@NonNull List<Ingredient> data){
    super(data);
  }

  @Nullable @Override public Object getItemId(@NonNull Ingredient item) {
    return item;
  }

  @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(android.R.layout.simple_list_item_1, parent, false));
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    //noinspection ConstantConditions
    holder.bind(getItem(position));
  }
}
