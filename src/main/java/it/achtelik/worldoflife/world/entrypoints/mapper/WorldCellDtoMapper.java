package it.achtelik.worldoflife.world.entrypoints.mapper;

import it.achtelik.worldoflife.world.core.model.WorldCell;
import it.achtelik.worldoflife.world.entrypoints.model.WorldCellDto;

import java.util.Collection;
import java.util.stream.Collectors;

public class WorldCellDtoMapper {

    private final WorldPositionDtoMapper worldPositionDtoMapper;

    public WorldCellDtoMapper(WorldPositionDtoMapper worldPositionDtoMapper) {
        this.worldPositionDtoMapper = worldPositionDtoMapper;
    }

    public WorldCellDto map(WorldCell worldCell) {
        return new WorldCellDto(worldPositionDtoMapper.map(worldCell.getWorldPosition()));
    }

    public Collection<WorldCellDto> map(Collection<WorldCell> values) {
        return values.stream().map(this::map).collect(Collectors.toSet());
    }
}
