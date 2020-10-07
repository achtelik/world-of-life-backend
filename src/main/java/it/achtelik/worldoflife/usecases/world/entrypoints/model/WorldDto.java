package it.achtelik.worldoflife.usecases.world.entrypoints.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WorldDto {
    private final List<WorldCellDto> worldCellDtos = new ArrayList<>();

    @JsonCreator
    public WorldDto(Collection<WorldCellDto> worldCellDtos) {
        this.worldCellDtos.addAll(worldCellDtos);
    }

    public List<WorldCellDto> getWorldCellDtos() {
        return worldCellDtos;
    }
}
