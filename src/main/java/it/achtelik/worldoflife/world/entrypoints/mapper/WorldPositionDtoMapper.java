package it.achtelik.worldoflife.world.entrypoints.mapper;

import it.achtelik.worldoflife.world.core.model.WorldPosition;
import it.achtelik.worldoflife.world.entrypoints.model.WorldPositionDto;

public class WorldPositionDtoMapper {

    public WorldPositionDto map(WorldPosition worldPosition) {
        return new WorldPositionDto(worldPosition.getX(), worldPosition.getY());
    }

    public WorldPosition map(WorldPositionDto worldPositionDto) {
        return new WorldPosition(worldPositionDto.getX(), worldPositionDto.getY());
    }
}
