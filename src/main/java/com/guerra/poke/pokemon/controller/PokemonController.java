package com.guerra.poke.pokemon.controller;

import com.guerra.poke.exception.NotFoundException;
import com.guerra.poke.pokemon.model.PageResult;
import com.guerra.poke.pokemon.model.Pokemon;
import com.guerra.poke.pokemon.service.PokemonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/pokemon")
@Slf4j
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Pokemon> findOne(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonService.findOne(id);

        if (!pokemon.isPresent()) {
            throw new NotFoundException("No pokemon here");
        }

        return ResponseEntity.ok(pokemon.get());
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public PageResult findAll() {
        PageResult all = pokemonService.findAll();
        return all;
    }
}
