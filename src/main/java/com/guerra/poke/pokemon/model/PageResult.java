package com.guerra.poke.pokemon.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageResult {
    private Long count;
    private String next;
    private Long previous;
    private List<Results> results;
}
