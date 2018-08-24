package com.github.riyaz.bakingapp.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.RemoteViews;
import com.github.riyaz.bakingapp.R;
import com.github.riyaz.bakingapp.StringUtils;
import com.github.riyaz.bakingapp.model.Ingredient;
import com.github.riyaz.bakingapp.model.Recipe;

/**
 * Created on 24 Aug, 2018
 *
 * @author Riyaz
 */
public class WidgetProvider extends AppWidgetProvider {

  @Override
  public void onUpdate(Context context, AppWidgetManager manager, int[] ids) {
    super.onUpdate(context, manager, ids);

    // honestly, I don't think we need anything here...
    // since the widget is never actually updated
    // maybe I'm wrong ¯\_(ツ)_/¯
  }

  // helper to update the widget
  // from receiver as well as configuration activity
  // package-local
  static void updateWidget(Context context, AppWidgetManager manager, int widget, @NonNull Recipe recipe){
    // inflate layout
    RemoteViews layout = new RemoteViews(context.getPackageName(), R.layout.widget_list);
    layout.setTextViewText(R.id.widget_recipe_name, recipe.getName());
    layout.removeAllViews(R.id.widget_recipe_ingredients);

    // for each ingredient, create a new view
    for(Ingredient ingredient : recipe.getIngredients()){
      RemoteViews view = new RemoteViews(context.getPackageName(), R.layout.widget_list_item);
      String line = StringUtils.formatIngdedient(context, ingredient.getName(), ingredient.getQuantity(), ingredient.getMeasure());
      view.setTextViewText(android.R.id.text1, line);
      layout.addView(R.id.widget_recipe_ingredients, view);
    }

    manager.updateAppWidget(widget, layout);
  }
}
