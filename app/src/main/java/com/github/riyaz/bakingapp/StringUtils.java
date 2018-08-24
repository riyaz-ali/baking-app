package com.github.riyaz.bakingapp;

import android.annotation.SuppressLint;
import android.content.Context;
import com.github.riyaz.bakingapp.model.Ingredient;
import java.util.Locale;

/**
 * see https://git.io/fAtPN
 */
public class StringUtils {
  @SuppressLint("StringFormatInvalid") public static String formatIngdedient(Context context, String name, float quantity, Ingredient.Measure measure) {
    String line = context.getResources().getString(R.string.recipe_details_ingredient_line);
    String quantityStr = String.format(Locale.US, "%s", quantity);
    if (quantity == (long) quantity) {
      quantityStr = String.format(Locale.US, "%d", (long) quantity);
    }
    return String.format(Locale.US, line, name, quantityStr, measure.name());
  }
}
