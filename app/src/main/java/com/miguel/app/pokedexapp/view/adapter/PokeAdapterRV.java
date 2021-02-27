package com.miguel.app.pokedexapp.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.miguel.app.pokedexapp.R;
import com.miguel.app.pokedexapp.model.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PokeAdapterRV extends RecyclerView.Adapter<PokeAdapterRV.CardViewHolder> {

    Activity activity;
    List<Pokemon> pokemons;
    int resource;

    public PokeAdapterRV(Activity activity, List<Pokemon> pokemons, int resource) {
        this.activity = activity;
        this.pokemons = pokemons;
        this.resource = resource;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        Pokemon pokemon = pokemons.get(position);
        holder.name.setText(pokemon.getName());

        Picasso.get().load(pokemon.getImages()).into(holder.image);

//        holder.image.setOnClickListener(v -> {
//            Intent intent = new Intent(activity, PhotoDetailsActivity.class);
//            activity.startActivity(intent);
//        });

    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }


    public class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.cv_image);
            name = (TextView) itemView.findViewById(R.id.cv_name);
//            likeNumberCard = (TextView) itemView.findViewById(R.id.crd_likes);

        }
    }
}
