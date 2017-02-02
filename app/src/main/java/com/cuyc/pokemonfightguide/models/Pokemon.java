package com.cuyc.pokemonfightguide.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccaygoz on 14.12.2016.
 */


public class Pokemon {
    private String Id = "";
    private String Name = "";
    private ArrayList<PokemonType> Types;
    private Pokemon PForm = new Pokemon();
    private Pokemon AForm = new Pokemon();
    private String IconLink = "";

    public Pokemon() {

    }
    public Pokemon(String json) {

    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public ArrayList<PokemonType> getType() {
        return Types;
    }

    public Pokemon getPForm() {
        return PForm;
    }

    public Pokemon getAForm() {
        return AForm;
    }

    public String getIconLink() {
        return IconLink;
    }

    public void setId(String value) {
        Id = value;
        setIconLink();
    }

    public void setName(String value) {
        Name = value;
    }

    public void setType(PokemonType value) {
        if (Types == null)
            Types = new ArrayList<>();

        Types.add(value);
    }

    public void setPForm(Pokemon value) {
        PForm = value;
    }

    public void setAForm(Pokemon value) {
        AForm = value;
    }

    private void setIconLink() {
        String link = "http://pokeunlock.com/wp-content/uploads/2015/01/%s-80x80.png";
        IconLink = String.format(link, Id);
    }
}
