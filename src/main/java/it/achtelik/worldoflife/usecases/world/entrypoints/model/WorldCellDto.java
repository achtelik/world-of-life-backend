package it.achtelik.worldoflife.usecases.world.entrypoints.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public class WorldCellDto {
    private final WorldPositionDto worldPositionDto;

    @JsonCreator
    public WorldCellDto(WorldPositionDto worldPositionDto) {
        this.worldPositionDto = worldPositionDto;
    }

    public WorldPositionDto getWorldPositionDto() {
        return worldPositionDto;
    }
}
