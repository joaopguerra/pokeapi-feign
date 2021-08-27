package com.guerra.poke.pokemon.client;

import com.guerra.poke.exception.NotFoundException;
import com.guerra.poke.pokemon.model.PageResult;
import com.guerra.poke.pokemon.model.Pokemon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Slf4j
@Component
public class PokemonClientFallback implements PokemonClient {

    @Override
    public Optional<Pokemon> findOne(@PathVariable Long id) {
        return Optional.empty();
    }

    @Override
    public PageResult findAll() {
        throw new NotFoundException("No pokemons here");
    }
}
