package com.example.android.retrofitdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.android.retrofitdemo.GetJson.DataService;
import com.example.android.retrofitdemo.GetJson.RetrofitInstance;
import com.example.android.retrofitdemo.R;
import com.example.android.retrofitdemo.adapter.AdapterPojo;
import com.example.android.retrofitdemo.model.PojoJson;
import com.example.android.retrofitdemo.model.PojoList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AdapterPojo adapterPojo;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DataService service = RetrofitInstance.getRetrofitInstance().create(DataService.class);


        Call<PojoList> call = service.getData();

        Log.wtf("URL chamado", call.request().url() + "");

        call.enqueue(new Callback<PojoList>() {
            @Override
            public void onResponse(Call<PojoList> call, Response<PojoList> response) {
                generateDataList(response.body().getPojo());
            }

            @Override
            public void onFailure(Call<PojoList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Algo deu errado ... Por favor, tente mais tarde!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    /* Método para gerar lista (RecyclerView) */
    private void generateDataList(ArrayList<PojoJson> dataList) {

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        adapterPojo = new AdapterPojo(dataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapterPojo);
    }
}
