package it.achtelik.worldoflife.usecases.world.entrypoints.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WorldDto {
    private final List<WorldCellDto> worldCellDtos = new ArrayList<>();

    public WorldDto(Collection<WorldCellDto> worldCellDtos) {
        this.worldCellDtos.addAll(worldCellDtos);
    }

    public List<WorldCellDto> getWorldCellDtos() {
        return worldCellDtos;
    }
}
