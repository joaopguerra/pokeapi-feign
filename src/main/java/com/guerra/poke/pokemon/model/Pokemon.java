package com.guerra.poke.pokemon.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pokemon {
    private Long id;
    private String name;
    private Long base_experience;
    private Integer height;
    private boolean is_default;
    private Integer order;
    private Integer weight;
}
