package it.achtelik.worldoflife.usecases.world.entrypoints.rest;

import it.achtelik.worldoflife.usecases.world.core.model.World;
import it.achtelik.worldoflife.usecases.world.entrypoints.mapper.WorldDtoMapper;
import it.achtelik.worldoflife.usecases.world.entrypoints.model.WorldDto;
import reactor.core.publisher.FluxSink;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WorldControllerWorldListener implements PropertyChangeListener {

    private final WorldDtoMapper worldDtoMapper;
    private final FluxSink<WorldDto> fluxSink;

    public WorldControllerWorldListener(WorldDtoMapper worldDtoMapper, FluxSink<WorldDto> fluxSink) {
        this.worldDtoMapper = worldDtoMapper;
        this.fluxSink = fluxSink;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        fluxSink.next(worldDtoMapper.map((World) propertyChangeEvent.getNewValue()));
    }
}
