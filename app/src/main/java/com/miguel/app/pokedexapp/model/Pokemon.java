package com.miguel.app.pokedexapp.model;

import java.util.List;

public class Pokemon {

    private String name;
    private List<String> images;
    private String likes = "0 ";

    public Pokemon(String name, List<String> images) {
        this.name = name;
        this.images = images;
        this.likes += "mi piace";
    }

    public String getName() {
        return name;
    }

    public String getImages() {
        return images.get(1);
    }

    public String getLikes() {
        return likes;
    }
}
