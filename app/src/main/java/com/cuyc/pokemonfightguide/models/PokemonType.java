package com.cuyc.pokemonfightguide.models;

import java.util.ArrayList;

/**
 * Created by ccaygoz on 26.12.2016.
 */

public class PokemonType {
    private String type = "";
    private ArrayList<String> ListStrongVS = new ArrayList<>();
    private ArrayList<String> ListWeakVS = new ArrayList<>();
    private ArrayList<String> ListNotEffectedVS = new ArrayList<>();

    public PokemonType(String type) {
        this.type = type;
    }

    public void setStrongVS(String strongVS) {
        ListStrongVS.add(strongVS);
    }

    public void setListWeakVS(String weakVS) {
        ListWeakVS.add(weakVS);
    }

    public void setListNotEffectedVS(String notEffectedVS) {
        ListNotEffectedVS.add(notEffectedVS);
    }
}
