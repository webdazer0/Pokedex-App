package com.miguel.app.pokedexapp.service;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import androidx.recyclerview.widget.RecyclerView;

import com.miguel.app.pokedexapp.R;
import com.miguel.app.pokedexapp.model.Pokemon;
import com.miguel.app.pokedexapp.view.adapter.PokeAdapterRV;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class SincronizzaDati extends AsyncTask<String, String, List<String>> {

    List<Pokemon> pokemons;
    PokeAdapterRV adapter;
    RecyclerView pokeList;
    Activity activity;
    Context context;
    ProgressDialog dialog;

    private static int counter;

    public SincronizzaDati(List<Pokemon> p, PokeAdapterRV pa, RecyclerView e, Context context, Activity activity) {
        pokemons = p;
        adapter = pa;
        pokeList = e;
        this.context = context;
        this.activity = activity;
        this.counter = 1;
        dialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute() {
        dialog.setMessage("Caricamento...");
        dialog.show();
    }

    @Override
    protected List<String> doInBackground(String... indirizzi) {

        List<String> dati = new ArrayList<String>();

        String tmp = "";

        int k = 0;
        int tot = indirizzi.length;

        try {

            for (String url : indirizzi) {

                tmp = HTTPManager.get(url);
                publishProgress(url, String.valueOf(Math.round(100 * (++k) / tot)) + "%");
                dati.add(tmp);

            }

        } catch (Exception e) {
            for(StackTraceElement ste : e.getStackTrace()) {
                Log.e("MITO_DEBUG", "Errore SincronizzaDati: " + ste.toString());
            }
        }

        return dati;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        //super.onProgressUpdate(values);
        Log.i("MITO_DEBUG","Stato sync: " + values[0]);
        dialog.setMessage("Caricamento " + values[1]);
    }

    @Override
    protected void onPostExecute(List<String> dati) {
        //super.onPostExecute(s);
        for( String dato : dati ) {
            Log.i("MITO_DEBUG", "JSON da Sincronizza: " + dato);

            try {
                JSONObject objDato = new JSONObject(dato);

                String next = objDato.getString("next");
                Log.i("MITO_DEBUG", "next: " + next);

                JSONArray result = objDato.getJSONArray("results");

                for (int i = 0; i < result.length(); i++) {
                    JSONObject obj = result.getJSONObject(i);
                    Log.i("MITO_DEBUG", "nome: " + obj.getString("name") + " | " + counter);
                    String name = obj.getString("name");
                    name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase(); // Per fare maiuscola la prima parola:   "Parola"

                    pokemons.add(new Pokemon(name, Arrays.asList("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + counter + ".png", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + counter + ".png")));
                    counter++;
//                    https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png
                }

            } catch (Exception e) {
                Log.e("MITO_DEBUG", "JSON errore: " + e.getMessage());
            }

        }

        adapter = new PokeAdapterRV(activity, pokemons, R.layout.pokecardview_item);

        pokeList.setAdapter(adapter);

        if(dialog.isShowing()) {
            dialog.dismiss();
        }

    }
}
