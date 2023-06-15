package com.section27.movieproinfo.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.library.baseAdapters.BR;
//import androidx.databinding.library.baseAdapters.BR;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//import androidx.databinding.library.baseAdapters.BR;


import java.util.List;

import javax.annotation.Generated;

//When you implement the Parcelable interface in Java for Android, it allows you to serialize and
// deserialize an object for the purpose of passing it between components, such as between activities
// or fragments. The Parcelable interface provides a way to efficiently serialize objects by writing
// their properties into a Parcel, which is then used to recreate the object on the receiving end.
//
//By implementing Parcelable, you define how your custom object can be flattened into a Parcel and
// reconstructed from it. This is useful when you want to pass complex data objects between different
// components, like passing an object from one activity to another using an Intent.
@Generated("jsonschema2pojo")
public class Movie extends BaseObservable implements Parcelable {


    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;

    //initialization parsel
    public final static Parcelable.Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };



    //binding adapter
    @BindingAdapter({"posterPath"})
    public static void loadImage(ImageView imageView , String imageURL){
        //BASE url for img :  https://image.tmdb.org/t/p/w500
        String imagePath = "https://image.tmdb.org/t/p/w500"+imageURL;
        Glide.with(imageView.getContext())
                .load(imagePath)
                .into(imageView);
    }

    @Bindable
    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
        notifyPropertyChanged(BR.adult);
    }
    @Bindable
    public String getBackdropPath() {
        return backdropPath;
    }
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
        notifyPropertyChanged(BR.backdropPath);

    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }


    @Bindable
    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
     notifyPropertyChanged(BR.genreIds);

    }
    @Bindable
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        notifyPropertyChanged(BR.id);

    }
    @Bindable
    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    notifyPropertyChanged(BR.mediaType);

    }
    @Bindable
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    notifyPropertyChanged(BR.originalLanguage);

    }
    @Bindable
    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    notifyPropertyChanged(BR.originalTitle);

    }
    @Bindable
    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    notifyPropertyChanged(BR.overview);

    }
    @Bindable
    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
     //   notifyPropertyChanged(BR.posterPath);

    }
    @Bindable
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        notifyPropertyChanged(BR.releaseDate);

    }
    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    notifyPropertyChanged(BR.title);

    }
    @Bindable
    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    notifyPropertyChanged(BR.video);

    }
    @Bindable
    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
        notifyPropertyChanged(BR.voteAverage);

    }
    @Bindable
    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    notifyPropertyChanged(BR.voteCount);

    }

    //implement  method for Parcelable Interface
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {
        parcel.writeValue(adult);
        parcel.writeValue(backdropPath);
//        parcel.writeList(genreIds); //is list
        parcel.writeValue(id);
        parcel.writeValue(mediaType);
        parcel.writeValue(originalLanguage);
        parcel.writeValue(originalTitle);
        parcel.writeValue(overview);
        parcel.writeValue(posterPath);
        parcel.writeValue(releaseDate);
        parcel.writeValue(title);
        parcel.writeValue(video);
        parcel.writeValue(voteAverage);
        parcel.writeValue(voteCount);
        parcel.writeValue(name);
    }

    public Movie() {
    }

    public Movie(Parcel in) {
        this.adult = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.backdropPath = (String) in.readValue(String.class.getClassLoader());
//        in.readList(this.genreIds , Integer.class.getClassLoader()); //here list of integer
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());;
        this.mediaType = (String) in.readValue(String.class.getClassLoader());
        this.originalLanguage = (String) in.readValue(String.class.getClassLoader());
        this.originalTitle = (String) in.readValue(String.class.getClassLoader());
        this.overview = (String) in.readValue(String.class.getClassLoader());
        this.posterPath = (String) in.readValue(String.class.getClassLoader());
        this.releaseDate = (String) in.readValue(String.class.getClassLoader());
        this.title = (String) in.readValue(String.class.getClassLoader());
        this.video = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.voteAverage = (Double) in.readValue(Double.class.getClassLoader());
        this.voteCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = (String) in.readValue(String.class.getClassLoader());
    }


}


