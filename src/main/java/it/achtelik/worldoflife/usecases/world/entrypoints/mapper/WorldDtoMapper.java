package it.achtelik.worldoflife.usecases.world.entrypoints.mapper;

import it.achtelik.worldoflife.usecases.world.core.model.World;
import it.achtelik.worldoflife.usecases.world.entrypoints.model.WorldDto;

public class WorldDtoMapper {

    private final WorldCellDtoMapper worldCellDtoMapper;

    public WorldDtoMapper(WorldCellDtoMapper worldCellDtoMapper) {
        this.worldCellDtoMapper = worldCellDtoMapper;
    }

    public WorldDto map(World world) {
        return new WorldDto(worldCellDtoMapper.map(world.getWorldCells().values()));
    }
}
