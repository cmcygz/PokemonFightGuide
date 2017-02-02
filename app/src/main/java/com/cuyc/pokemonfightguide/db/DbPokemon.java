package com.cuyc.pokemonfightguide.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import com.cuyc.pokemonfightguide.models.Pokemon;
import com.cuyc.pokemonfightguide.models.PokemonType;

import java.util.ArrayList;

public class DbPokemon extends DbProcess {

    public DbPokemon(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
//        Context mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Pokemons( Id TEXT(100), Name TEXT(100), Type TEXT(100), PForm TEXT(100), AForm TEXT(100))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        db.execSQL("DROP TABLE Pokemons;");
        onCreate(db);
    }

    public long DeleteAllData() {
        return Delete("Pokemons", "");
    }

    public long InsertPokemon(Pokemon pokemon) {
        ContentValues v2 = new ContentValues();
        v2.put("Id", pokemon.getId());
        v2.put("Name", pokemon.getName());
        v2.put("Type", pokemon.getType());
        v2.put("PForm", pokemon.getPForm()); 
        v2.put("AForm", pokemon.getAForm());
        return Insert("Pokemons", v2);
    }

    public int GetPokemonCount() {

        int snc = 0;
        Cursor sonuc = SelectQuery("SELECT COUNT(*) AS adet FROM Pokemons", null);
        if (sonuc.moveToFirst()) {
            snc = sonuc.getInt(sonuc.getColumnIndex("adet"));
        }
        sonuc.close();
        return snc;
    }

    public ArrayList<Pokemon> GetPokemons() {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        Cursor sonuc = SelectQuery("SELECT * FROM Pokemons", null);
        if (sonuc.moveToFirst()) {
            do {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(sonuc.getString(sonuc.getColumnIndex("Id")));
                pokemon.setName(sonuc.getString(sonuc.getColumnIndex("Name")));
                pokemon.setType(sonuc.getString(sonuc.getColumnIndex("Type")));
                pokemon.setPForm(sonuc.getString(sonuc.getColumnIndex("Pform")));
                pokemon.setAForm(sonuc.getString(sonuc.getColumnIndex("Aform")));
                pokemons.add(pokemon);
            } while (sonuc.moveToNext());
        }
        return pokemons;
    }

    private ArrayList<PokemonType> GetTypes(String types) {
        ArrayList<PokemonType> pokemonTypes = new ArrayList<>();
    }
}
