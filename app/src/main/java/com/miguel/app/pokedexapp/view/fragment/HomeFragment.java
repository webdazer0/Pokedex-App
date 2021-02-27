package com.miguel.app.pokedexapp.view.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.miguel.app.pokedexapp.R;
import com.miguel.app.pokedexapp.model.Pokemon;
import com.miguel.app.pokedexapp.view.adapter.PokeAdapterRV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView pokeList = view.findViewById(R.id.pokeList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pokeList.setLayoutManager(linearLayoutManager);

        PokeAdapterRV adapter = new PokeAdapterRV(getActivity(), builPokemons(), R.layout.pokecardview_item );
        pokeList.setAdapter(adapter);


        return view;

    }



    public List<Pokemon> builPokemons() {
        List<Pokemon> pokemons = new ArrayList<Pokemon>();
        pokemons.add(new Pokemon("Pecachu", Arrays.asList("https://media.pokemoncentral.it/wiki/thumb/0/0d/Logo_Pok%C3%A9mon_HOME.png/800px-Logo_Pok%C3%A9mon_HOME.png")));
        pokemons.add(new Pokemon("xqcachu", Arrays.asList("https://media.pokemoncentral.it/wiki/thumb/0/0d/Logo_Pok%C3%A9mon_HOME.png/800px-Logo_Pok%C3%A9mon_HOME.png")));
        pokemons.add(new Pokemon("Aewcachu", Arrays.asList("https://media.pokemoncentral.it/wiki/thumb/0/0d/Logo_Pok%C3%A9mon_HOME.png/800px-Logo_Pok%C3%A9mon_HOME.png")));
        pokemons.add(new Pokemon("QQcachxu", Arrays.asList("https://media.pokemoncentral.it/wiki/thumb/0/0d/Logo_Pok%C3%A9mon_HOME.png/800px-Logo_Pok%C3%A9mon_HOME.png")));
        return pokemons;

    }
}