package com.github.riyaz.bakingapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * POJO representing a single step in the recipe
 *
 * @author Riyaz
 */
@SuppressWarnings("WeakerAccess")
public final class Step {

  /**
   * Id of the this step. This is also the order number for the steps
   */
  @SerializedName("id")
    private int id;

  /**
   * A short readable description of the recipe
   */
  @SerializedName("shortDescription")
    private String shortDescription;

  /**
   * A more detailed description of this step
   */
  @SerializedName("description")
    private String description;

  /**
   * URL to an associated video to this step, if any
   */
  @SerializedName("videoURL")
    private String video;

  /**
   * Url to the thumbnail of this step, if any
   */
  @SerializedName("thumbnailURL")
    private String thumbnail;

  //================================================================================//
  //================================ AUTO GENERATED ================================//
  //================================================================================//
  public int getId() { return id; }
  public String getShortDescription() { return shortDescription; }
  public String getDescription() { return description; }
  public String getVideo() { return video; }
  public String getThumbnail() { return thumbnail; }

  @Override public String toString() {
    return "Step{" +
        "id=" + id +
        ", shortDescription='" + shortDescription + '\'' +
        ", description='" + description + '\'' +
        ", video='" + video + '\'' +
        ", thumbnail='" + thumbnail + '\'' +
        '}';
  }
}
