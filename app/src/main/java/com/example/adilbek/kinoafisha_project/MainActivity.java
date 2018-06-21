package com.example.adilbek.kinoafisha_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;


import com.example.adilbek.kinoafisha_project.adapterler.Adapter_KinoTeatr;
import com.example.adilbek.kinoafisha_project.apiler.ApiKinoTeatr;
import com.example.adilbek.kinoafisha_project.modelder.kinoteatr_model.KinoTeatr;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recycler view show
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //retrofitt
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiKinoTeatr.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiKinoTeatr apiKinoTeatr = retrofit.create(ApiKinoTeatr.class);
        Call<KinoTeatr> call = apiKinoTeatr.getKinoTeatrs();
        call.enqueue(new Callback<KinoTeatr>() {
            private Call<KinoTeatr> call;
            private Response<KinoTeatr> response;
            @Override
            public void onResponse(Call<KinoTeatr> call, Response<KinoTeatr> response) {
                KinoTeatr kinoTeatrs = response.body();
                recyclerView.setAdapter(new Adapter_KinoTeatr(MainActivity.this, kinoTeatrs));
            }
            @Override
            public void onFailure(Call<KinoTeatr> call, Throwable t) {
                // mTextVeiew.setText("Kata Serverge jatken jok");
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mian_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_film :
                Intent intent=new Intent(this,KinoActivity.class);
                startActivity(intent);
                return true;
            case R.id.save_kinoteart:
                Intent intent1=new Intent(this,MainActivity.class);
                startActivity(intent1);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
