package com.example.adilbek.kinoafisha_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.adilbek.kinoafisha_project.adapterler.Adapter_Kino;
import com.example.adilbek.kinoafisha_project.apiler.ApiKino;
import com.example.adilbek.kinoafisha_project.modelder.kino_modelder.Kino;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_SHORT;

public class KinoActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_kino);
            recyclerView = findViewById(R.id.recyclerView2);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            //retrofit
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(ApiKino.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiKino apiKino=retrofit.create(ApiKino.class);
            Call<Kino> call = apiKino.getKino();
            call.enqueue(new Callback<Kino>() {
                // private Call<KinoTeatr> call;
                Intent intent=getIntent();
                String  idOfCinema = intent.getStringExtra("idOfCinema");
                // private Response<KinoTeatr> response;
                @Override
                public void onResponse(Call<Kino> call, Response<Kino> response) {
                    Kino kinolor1;//kinolor2 =new Kino();
                    kinolor1 = response.body();

                    recyclerView.setAdapter(new Adapter_Kino(KinoActivity.this, kinolor1));
                }
                @Override
                public void onFailure(Call<Kino> call, Throwable t) {
                    //  Toast.makeText(MainActivity.class,"Error",Toast.LENGTH_LONG);
                }
            });


        }catch (Exception e){
            Toast.makeText(this,"Oshibka :"+e.getMessage(), LENGTH_SHORT).show();
        }

    }
}
