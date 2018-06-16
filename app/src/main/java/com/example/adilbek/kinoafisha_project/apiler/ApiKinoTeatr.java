package com.example.adilbek.kinoafisha_project.apiler;

import com.example.adilbek.kinoafisha_project.modelder.kinoteatr_model.KinoTeatr;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiKinoTeatr {
    String BASE_URL = "https://kinoafisha.ua/ajax/";
    @GET("kinoteatrs_load/")
    Call<KinoTeatr> getKinoTeatrs();
}
