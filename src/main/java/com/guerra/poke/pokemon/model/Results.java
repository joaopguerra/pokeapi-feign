package com.guerra.poke.pokemon.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Results {
    private String name;
    private String url;
    private Pokemon pokemon;
}
