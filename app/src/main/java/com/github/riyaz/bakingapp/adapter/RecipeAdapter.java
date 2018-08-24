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
import com.github.riyaz.bakingapp.model.Recipe;
import com.pascalwelsch.arrayadapter.ArrayAdapter;

/**
 * {@link RecyclerView.Adapter} for displaying {@link Recipe} listing
 *
 * @author Riyaz
 */
public final class RecipeAdapter extends ArrayAdapter<Recipe, RecipeAdapter.ViewHolder> {

  // click listener interface
  public interface OnClickListener {
    // called when a recipe is clicked
    void onRecipeClicked(@NonNull Recipe recipe);
  }

  // ViewHolder implementation
  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(android.R.id.text1)
      TextView title;
    @BindView(android.R.id.text2)
      TextView servings;

    ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      itemView.setOnClickListener(this);
    }

    // bind the recipe object to the view
    void bind(@NonNull Recipe recipe){
      title.setText(recipe.getName());
      servings.setText(getContext().getString(R.string.servings_count, recipe.getServings()));
    }

    @Override public void onClick(View v) {
      //noinspection ConstantConditions
      onClickListener.onRecipeClicked(getItem(getAdapterPosition()));
    }
  }

  // context
  private Context context;
  // layout inflater
  private LayoutInflater inflater;
  // click listener
  private OnClickListener onClickListener;

  public RecipeAdapter(@NonNull Context context, @NonNull OnClickListener clickListener){
    this.context = context;
    this.inflater = LayoutInflater.from(context);
    this.onClickListener = clickListener;
  }

  @Override public Object getItemId(@NonNull Recipe item) {
    return item.getId();
  }

  @NonNull @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ViewHolder(inflater.inflate(R.layout.adapter_recipe, parent, false));
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    //noinspection ConstantConditions
    holder.bind(getItem(position));
  }

  private Context getContext(){
    return context;
  }
}
