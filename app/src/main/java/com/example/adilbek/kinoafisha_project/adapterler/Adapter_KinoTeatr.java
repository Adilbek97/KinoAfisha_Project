package com.example.adilbek.kinoafisha_project.adapterler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.adilbek.kinoafisha_project.R;
import com.example.adilbek.kinoafisha_project.KinoTeatrActivity;
import com.example.adilbek.kinoafisha_project.modelder.kinoteatr_model.KinoTeatr;

public class Adapter_KinoTeatr extends RecyclerView.Adapter<Adapter_KinoTeatr.ViewHolder> {
    private Context context;
    private KinoTeatr kinoTeatrs;
    int mPosission;

    public Adapter_KinoTeatr(Context context, KinoTeatr kinoTeatrs) {
        this.context = context;
        this.kinoTeatrs = kinoTeatrs;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_kinoteatr, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        mPosission = position;
        holder.name.setText(kinoTeatrs.result.unmain.get(position).getName());
        holder.adress.setText(kinoTeatrs.result.unmain.get(position).getAddress());
        holder.count_vote.setText(kinoTeatrs.result.unmain.get(position).getCount_vote());
        holder.phone.setText(kinoTeatrs.result.unmain.get(position).getPhone());
        holder.url.setText("https://kinoafisha.ua/" + kinoTeatrs.result.unmain.get(position).getUrl());
        Glide.with(context).load("https://kinoafisha.ua/" + kinoTeatrs.result.unmain.
                get(position).getImage()).into(holder.imageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, KinoTeatrActivity.class);
                intent.putExtra("nameKinoTeatr", kinoTeatrs.result.unmain.get(position).getName());
                intent.putExtra("adressKinoTeatr", kinoTeatrs.result.unmain.get(position).getAddress());
                intent.putExtra("phonesKinoTeatr", kinoTeatrs.result.unmain.get(position).getPhone());
                intent.putExtra("urlKinoTeatr", kinoTeatrs.result.unmain.get(position).getUrl());
                intent.putExtra("imagesKinoTeatr", kinoTeatrs.result.unmain.get(position).getImage());
                intent.putExtra("count_voteKinoTeatr", kinoTeatrs.result.unmain.get(position).getCount_vote());
                context.startActivity(intent);
                Toast.makeText(context, "you clicked " + kinoTeatrs.result.unmain.get(position).getName(), Toast.LENGTH_SHORT);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kinoTeatrs.result.unmain.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView name, adress, phone, count_vote, url;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ic_kinoteatr);
            name = itemView.findViewById(R.id.teatr_name);
            adress = itemView.findViewById(R.id.teatr_adress);
            phone = itemView.findViewById(R.id.teatr_phone);
            count_vote = itemView.findViewById(R.id.teatr_vote);
            url = itemView.findViewById(R.id.teatr_url);
            linearLayout = itemView.findViewById(R.id.linearLayout2);
        }

    }
}
