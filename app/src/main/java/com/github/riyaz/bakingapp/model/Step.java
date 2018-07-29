package com.github.riyaz.bakingapp.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * POJO representing a single step in the recipe
 *
 * @author Riyaz
 */
@SuppressWarnings("WeakerAccess")
public final class Step implements Parcelable {

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

  //================================================================================//
  //================================== PARCELABLE ==================================//
  //================================================================================//
  private Step(Parcel in){
    this.id = in.readInt();
    this.shortDescription = in.readString();
    this.description = in.readString();
    this.video = in.readString();
    this.thumbnail = in.readString();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(id);
    dest.writeString(shortDescription);
    dest.writeString(description);
    dest.writeString(video);
    dest.writeString(thumbnail);
  }

  public static final Creator<Step> CREATOR = new Creator<Step>() {
    @Override public Step createFromParcel(Parcel source) {
      return new Step(source);
    }

    @Override public Step[] newArray(int size) {
      return new Step[size];
    }
  };
}
