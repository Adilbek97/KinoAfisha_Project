package com.example.adilbek.kinoafisha_project.adapterler;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.adilbek.kinoafisha_project.KinoSecondActivity;
import com.example.adilbek.kinoafisha_project.R;
import com.example.adilbek.kinoafisha_project.modelder.kino_modelder.Kino;
import com.example.adilbek.kinoafisha_project.modelder.kino_modelder.Result;
import com.google.gson.Gson;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class Adapter_Kino extends RecyclerView.Adapter<Adapter_Kino.ViewHolder> {
    RecyclerView recyclerView;
    private Context context;
    private List<Result> mKino;
    ImageView mImageView;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_kino, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(mKino.get(position).getName());
        Glide.with(context).load("https://kinoafisha.ua/"+mKino.get(position).getImage()).into(mImageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,mKino.get(position).getName().toString()+" kino clicked", LENGTH_SHORT).show();
                Intent intent=new Intent(context,KinoSecondActivity.class);
              /* intent.putExtra("name",mKino.get(position).getName());
               intent.putExtra("image","https://kinoafisha.ua/"+mKino.get(position).getImage());
               intent.putExtra("actors",mKino.get(position).getActors());
               intent.putExtra("rejisser",mKino.get(position).getRejisser());
               intent.putExtra("premier_ua",mKino.get(position).getPremier_ua());
               intent.putExtra("countries",mKino.get(position).getCountries());
                intent.putExtra("vote",mKino.get(position).getVote());*/
                intent.putExtra("Kino",new Gson().toJson(mKino.get(position)));
                context.startActivity(intent);

            }
        });
        //...

    }
    public Adapter_Kino(Context context, List<Result> kino) {
        this.context = context;
        this.mKino=kino;
    }

    @Override
    public int getItemCount() {
        return mKino.size();
    }
    //-------------------
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.recyclerView2);
            mImageView=itemView.findViewById(R.id.image_Kino);
            name=itemView.findViewById(R.id.kino_name);
            linearLayout=itemView.findViewById(R.id.linearLayout3);

        }
    }
}
