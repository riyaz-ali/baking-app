package com.github.riyaz.bakingapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * POJO representing a single ingredient
 *
 * @author Riyaz
 */
public final class Ingredient implements Parcelable {
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
    @SerializedName("CUP") CUP,
    @SerializedName("TBLSP") TBSP,
    @SerializedName("TSP") TSP,
    @SerializedName("K") KG,
    @SerializedName("G") G,
    @SerializedName("OZ") OZ,
    UNIT
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

  //================================================================================//
  //================================== PARCELABLE ==================================//
  //================================================================================//

  // ctor to create object from parcel
  private Ingredient(Parcel in){
    this.quantity = in.readFloat();
    this.measure  = (Measure) in.readSerializable();
    this.name     = in.readString();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeFloat(quantity);
    dest.writeSerializable(measure);
    dest.writeString(name);
  }

  public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
    @Override public Ingredient createFromParcel(Parcel source) {
      return new Ingredient(source);
    }

    @Override public Ingredient[] newArray(int size) {
      return new Ingredient[size];
    }
  };
}
