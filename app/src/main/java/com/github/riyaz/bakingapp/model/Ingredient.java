package com.github.riyaz.bakingapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * POJO representing a single ingredient
 *
 * @author Riyaz
 */
public final class Ingredient {
  /**
   * Quantity of the ingredient measured in {@code measure}
   */
  @SerializedName("quantity")
    private float quantity;

  /**
   * Unit of measurement for the ingredient
   */
  @SerializedName("measure")
    private Measure measure;

  /**
   * Name of the ingredient
   */
  @SerializedName("ingredient")
    private String name;

  // enumeration of different measuring units
  public enum Measure {
    @SerializedName("CUP")
      CUP,
    @SerializedName("TBLSP")
      TABLESPOON,
    @SerializedName("TSP")
      TEASPOON,
    @SerializedName("K")
      KILOGRAM,
    @SerializedName("G")
      GRAM,
    @SerializedName("OZ")
      OUNCE
  }


  //================================================================================//
  //================================ AUTO GENERATED ================================//
  //================================================================================//
  public float getQuantity() { return quantity; }
  public Measure getMeasure() { return measure; }
  public String getName() { return name; }

  @Override public String toString() {
    return "Ingredient{" +
        "quantity=" + quantity +
        ", measure=" + measure +
        ", name='" + name + '\'' +
        '}';
  }
}
