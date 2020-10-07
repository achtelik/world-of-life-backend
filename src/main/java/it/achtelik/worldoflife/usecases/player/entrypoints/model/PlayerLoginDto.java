package it.achtelik.worldoflife.usecases.player.entrypoints.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class PlayerLoginDto {
    private final String name;

    @JsonCreator
    public PlayerLoginDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
