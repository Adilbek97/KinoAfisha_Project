package com.example.adilbek.kinoafisha_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.adilbek.kinoafisha_project.modelder.kino_modelder.Result;
import com.google.gson.Gson;

public class KinoSecondActivity extends AppCompatActivity {
    ImageView mImageView;
    TextView name, actors, rejisser, premier_ua, countries, vote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kino_second);
        name = findViewById(R.id.first);
        actors = findViewById(R.id.second);
        rejisser = findViewById(R.id.third);
        premier_ua = findViewById(R.id.forth);
        countries = findViewById(R.id.fifth);
        vote = findViewById(R.id.sixth);
        mImageView = findViewById(R.id.image_f);
        // textlink=findViewById(R.id.textLink);
        //retrofit
        Bundle arguments = getIntent().getExtras();
        final Result kino;
        // String image;
        if (arguments != null) {
            String json = arguments.getString("Kino");
            kino = new Gson().fromJson(json, Result.class);
            //  kino = arguments.getParcelable(Result.class.getSimpleName());
            name.setText(kino.getName());
            // image=arguments.getString("image");
            actors.setText(android.text.Html.fromHtml(kino.getActors()));
            rejisser.setText(android.text.Html.fromHtml(kino.getRejisser()));
            premier_ua.setText(kino.getPremier_ua());
            countries.setText(kino.getCountries());
            countries.setText(kino.getCountries());
            vote.setText(kino.getVote());
            Glide.with(this).load("https://kinoafisha.ua/" + kino.getImage()).into(mImageView);
            // textlink.setMovementMethod(LinkMovementMethod.getInstance());
            actors.setMovementMethod(LinkMovementMethod.getInstance());
            rejisser.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
