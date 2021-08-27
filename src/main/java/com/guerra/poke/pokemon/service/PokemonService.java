package com.guerra.poke.pokemon.service;

import com.guerra.poke.pokemon.client.PokemonClient;
import com.guerra.poke.pokemon.model.PageResult;
import com.guerra.poke.pokemon.model.Pokemon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PokemonService {

    private final PokemonClient pokemonClient;

    public PokemonService(PokemonClient pokemonClient) {
        this.pokemonClient = pokemonClient;
    }

    public Optional<Pokemon> findOne(Long id) {
        return pokemonClient.findOne(id);
    }

    public PageResult findAll() {
        PageResult all = pokemonClient.findAll();

        all.getResults().stream().forEach(c -> {
            String url = c.getUrl();
            String[] substring = url.split("pokemon/");
            String[] split = substring[1].split("/");
            Long id = Long.valueOf(split[0]);

            Optional<Pokemon> one = findOne(id);
            c.setPokemon(one.get());
        });

        return all;
    }

}
