package com.guerra.poke.pokemon.client;

import com.guerra.poke.pokemon.model.PageResult;
import com.guerra.poke.pokemon.model.Pokemon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Component
@FeignClient(
        name = "PokemonClient",
        url = "https://pokeapi.co/api/v2",
        fallback = PokemonClientFallback.class
)
public interface PokemonClient {

    @GetMapping("/pokemon/{id}")
    Optional<Pokemon> findOne(@PathVariable Long id);

    @GetMapping("/pokemon")
    PageResult findAll();
}
