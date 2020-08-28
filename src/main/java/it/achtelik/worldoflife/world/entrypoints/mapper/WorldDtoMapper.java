package it.achtelik.worldoflife.world.entrypoints.mapper;

import it.achtelik.worldoflife.world.core.model.World;
import it.achtelik.worldoflife.world.entrypoints.model.WorldDto;

public class WorldDtoMapper {

    private final WorldCellDtoMapper worldCellDtoMapper;

    public WorldDtoMapper(WorldCellDtoMapper worldCellDtoMapper) {
        this.worldCellDtoMapper = worldCellDtoMapper;
    }

    public WorldDto map(World world) {
        return new WorldDto(worldCellDtoMapper.map(world.getWorldCells().values()));
    }
}
