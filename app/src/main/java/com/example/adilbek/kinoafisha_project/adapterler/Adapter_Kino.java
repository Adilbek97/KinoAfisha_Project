package com.example.adilbek.kinoafisha_project.adapterler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.adilbek.kinoafisha_project.R;
import com.example.adilbek.kinoafisha_project.modelder.kino_modelder.Kino;

public class Adapter_Kino extends RecyclerView.Adapter<Adapter_Kino.ViewHolder> {
    private Context context;
    private Kino kinolor;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_kino, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(kinolor.result.get(position).getName());
        holder.h_name.setText(kinolor.result.get(position).sessions.get(position).getH_name());
        holder.sessions.setText(kinolor.result.get(position).sessions.get(position).getSessions());
        Glide.with(context).load("https://kinoafisha.ua/"+kinolor.result.get(position).getImage()).into(holder.imageView);
       //...
    }

    public Adapter_Kino(Context context, Kino kinolor) {
        this.context = context;
        this.kinolor = kinolor;
    }

    @Override
    public int getItemCount() {
        return kinolor.getResult().size();
    }


    //-------------------
    public class ViewHolder extends RecyclerView.ViewHolder {
     ImageView imageView;

     TextView name,sessions,h_name;
        public ViewHolder(View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.image_Kino);
            name=itemView.findViewById(R.id.kino_name);
            sessions=itemView.findViewById(R.id.kino_sessions);
            h_name=itemView.findViewById(R.id.kino_h_name);

        }
    }
}
