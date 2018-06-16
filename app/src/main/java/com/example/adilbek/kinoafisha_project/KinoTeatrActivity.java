package com.example.adilbek.kinoafisha_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.adilbek.kinoafisha_project.R;

public class KinoTeatrActivity extends AppCompatActivity {
      Intent intent;
      ImageView imageView;
      TextView name ,adress ,url ,phone ,count_vote;
      String image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kino_teatr);
        intent=getIntent();
        imageView=findViewById(R.id.image_f);
        name=findViewById(R.id.first);
        adress=findViewById(R.id.second);
        phone=findViewById(R.id.third);
        count_vote=findViewById(R.id.forth);
       // ...=findViewById(R.id.fifth);
        name.setText(intent.getStringExtra("nameKinoTeatr"));
        adress.setText(intent.getStringExtra("adressKinoTeatr"));
        phone.setText(intent.getStringExtra("phonesKinoTeatr"));
        count_vote.setText(intent.getStringExtra("count_voteKinoTeatr"));
        url.setText(intent.getStringExtra("urlKinoTeatr"));

        image=(intent.getStringExtra("imagesKinoTeatr"));
        Glide.with(this).load(image).into(imageView);

    }
}
