package com.github.riyaz.bakingapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * POJO representing a recipe
 *
 * @author Riyaz
 */
public final class Recipe implements Parcelable {
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

  //================================================================================//
  //================================== PARCELABLE ==================================//
  //================================================================================//
  private Recipe(Parcel in){
    this.id = in.readInt();
    this.name = in.readString();
    this.servings = in.readInt();
    this.image = in.readString();
    this.ingredients = new ArrayList<>();
    in.readTypedList(this.ingredients, Ingredient.CREATOR);
    this.steps = new ArrayList<>();
    in.readTypedList(this.steps, Step.CREATOR);
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(id);
    dest.writeString(name);
    dest.writeInt(servings);
    dest.writeString(image);
    dest.writeTypedList(ingredients);
    dest.writeTypedList(steps);
  }

  public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
    @Override public Recipe createFromParcel(Parcel source) {
      return new Recipe(source);
    }

    @Override public Recipe[] newArray(int size) {
      return new Recipe[size];
    }
  };
}
