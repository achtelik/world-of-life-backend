package it.achtelik.worldoflife.usecases.world.entrypoints.mapper;

import it.achtelik.worldoflife.usecases.world.core.model.WorldPosition;
import it.achtelik.worldoflife.usecases.world.entrypoints.model.WorldPositionDto;

public class WorldPositionDtoMapper {

    public WorldPositionDto map(WorldPosition worldPosition) {
        return new WorldPositionDto(worldPosition.getX(), worldPosition.getY());
    }

    public WorldPosition map(WorldPositionDto worldPositionDto) {
        return new WorldPosition(worldPositionDto.getX(), worldPositionDto.getY());
    }
}
