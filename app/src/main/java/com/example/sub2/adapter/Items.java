package com.example.sub2.adapter;

import android.os.Parcelable;

import android.os.Parcel;


public class Items implements Parcelable {

    private int Image_film;


    public int getImage_film() {
        return Image_film;
    }

    public void setImage_film(int image_film) {
        Image_film = image_film;
    }

    public String getDesc_film() {
        return Desc_film;
    }

    public void setDesc_film(String desc_film) {
        Desc_film = desc_film;
    }

    public String getTitle_film() {
        return Title_film;
    }

    public void setTitle_film(String title_film) {
        Title_film = title_film;
    }

    public String getInfo_film() {
        return Info_film;
    }

    public void setInfo_film(String info_film) {
        Info_film = info_film;
    }

    private String Desc_film;
    private String Title_film;
    private String Info_film;



    public Items() {
        this.Image_film = Image_film;
        this.Desc_film = Desc_film ;
        this.Title_film = Title_film;
        this.Info_film = Info_film;
    }


    public Items(Parcel in) {
        Image_film = in.readInt();
        Desc_film = in.readString();
        Title_film = in.readString();
        Info_film = in.readString();
    }

    public static final Creator<Items> CREATOR = new Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Image_film);
        dest.writeString(Desc_film);
        dest.writeString(Title_film);
        dest.writeString(Info_film);
    }




}


