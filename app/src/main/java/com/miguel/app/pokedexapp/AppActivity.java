package com.miguel.app.pokedexapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.miguel.app.pokedexapp.view.MainActivity;

public class AppActivity extends AppCompatActivity {

    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        ctx = this;
        Button btnPokemon = findViewById(R.id.btnPokemon);

        btnPokemon.setOnClickListener(v ->startActivity(new Intent(ctx, MainActivity.class)) );

    }
}