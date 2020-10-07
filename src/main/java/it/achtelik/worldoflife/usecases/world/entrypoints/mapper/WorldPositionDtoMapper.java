package it.achtelik.worldoflife.usecases.world.entrypoints.mapper;

import it.achtelik.worldoflife.usecases.world.core.model.WorldPosition;
import it.achtelik.worldoflife.usecases.world.entrypoints.model.WorldPositionDto;

import java.util.List;
import java.util.stream.Collectors;

public class WorldPositionDtoMapper {

    public WorldPositionDto map(WorldPosition worldPosition) {
        return new WorldPositionDto(worldPosition.getX(), worldPosition.getY());
    }

    public List<WorldPositionDto> mapList(List<WorldPosition> worldPositions) {
        return worldPositions.stream()
                .map(worldPosition -> map(worldPosition))
                .collect(Collectors.toList());
    }

    public WorldPosition map(WorldPositionDto worldPositionDto) {
        return new WorldPosition(worldPositionDto.getX(), worldPositionDto.getY());
    }

    public List<WorldPosition> mapListDto(List<WorldPositionDto> worldPositionDtos) {
        return worldPositionDtos.stream()
                .map(worldPositionDto -> map(worldPositionDto))
                .collect(Collectors.toList());
    }
}
