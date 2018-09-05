package com.example.android.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PojoList {


    @SerializedName("data")
    private ArrayList<PojoJson> data;

    public ArrayList<PojoJson> getPojo() {
        return data;
    }

    public void setPojoDemons(ArrayList<PojoJson> data) {
        this.data = data;
    }


}

