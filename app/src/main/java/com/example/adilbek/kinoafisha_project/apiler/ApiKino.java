package com.example.adilbek.kinoafisha_project.apiler;

import com.example.adilbek.kinoafisha_project.modelder.kino_modelder.Kino;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiKino {

        public  String BASE_URL = "https://kinoafisha.ua/ajax/";

    @GET("kinoafisha_load/")
    public Call<Kino> getKino();

}
