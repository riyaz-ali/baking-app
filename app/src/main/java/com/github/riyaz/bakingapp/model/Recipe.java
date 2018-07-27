package com.github.riyaz.bakingapp.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * POJO representing a recipe
 *
 * @author Riyaz
 */
public final class Recipe {
  /**
   * Id of the recipe
   */
  @SerializedName("id")
    private int id;

  /**
   * Name of the recipe
   */
  @SerializedName("name")
    private String name;

  /**
   * Number of servings for the recipe
   */
  @SerializedName("servings")
   private int servings;

  /**
   * URL to the image of the recipe
   */
  @SerializedName("image")
    private String image;

  /**
   * List of ingredient needed for the recipe
   */
  @SerializedName("ingredients")
    private List<Ingredient> ingredients;

  /**
   * List of steps for this recipe
   */
  @SerializedName("steps")
    private List<Step> steps;

  //================================================================================//
  //================================ AUTO GENERATED ================================//
  //================================================================================//
  public int getId() { return id; }
  public String getName() { return name; }
  public int getServings() { return servings; }
  public String getImage() { return image; }
  public List<Ingredient> getIngredients() { return ingredients; }
  public List<Step> getSteps() { return steps; }

  @Override public String toString() {
    return "Recipe{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", servings=" + servings +
        ", image='" + image + '\'' +
        ", ingredients=" + ingredients +
        ", steps=" + steps +
        '}';
  }
}
