package com.example.android.retrofitdemo.GetJson;

import com.example.android.retrofitdemo.model.PojoList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("data.json")
    Call<PojoList> getData();

}
