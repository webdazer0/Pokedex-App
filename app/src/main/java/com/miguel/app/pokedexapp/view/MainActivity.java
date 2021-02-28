package com.miguel.app.pokedexapp.view;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.miguel.app.pokedexapp.R;
import com.miguel.app.pokedexapp.view.fragment.HomeFragment;
import com.miguel.app.pokedexapp.view.fragment.ProfileFragment;
import com.miguel.app.pokedexapp.view.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private SearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();
        searchFragment = new SearchFragment();

        if(savedInstanceState == null) addFragment(homeFragment);

        BottomNavigationView menu = findViewById(R.id.my_custom_bottombar);
        menu.setOnNavigationItemSelectedListener(changeMenuEvent);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener changeMenuEvent = item -> {

        switch (item.getItemId()) {
            case R.id.menu_home:
                addFragment(homeFragment);
                break;
            case R.id.menu_profile:
                addFragment(profileFragment);
                break;
            case R.id.menu_search:
                addFragment(searchFragment);
                break;
        }

        return false;
    };

    private void addFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .addToBackStack(null).commit();
        }
    }
}