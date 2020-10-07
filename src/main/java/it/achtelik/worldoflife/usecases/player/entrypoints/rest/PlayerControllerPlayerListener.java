package it.achtelik.worldoflife.usecases.player.entrypoints.rest;

import it.achtelik.worldoflife.usecases.player.core.model.Player;
import it.achtelik.worldoflife.usecases.player.entrypoints.mapper.PlayerPublicDtoMapper;
import it.achtelik.worldoflife.usecases.player.entrypoints.model.PlayerPublicDto;
import reactor.core.publisher.FluxSink;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;

public class PlayerControllerPlayerListener implements PropertyChangeListener {

    private final PlayerPublicDtoMapper playerPublicDtoMapper;
    private final FluxSink<Set<PlayerPublicDto>> fluxSink;

    public PlayerControllerPlayerListener(PlayerPublicDtoMapper playerPublicDtoMapper, FluxSink<Set<PlayerPublicDto>> fluxSink) {
        this.playerPublicDtoMapper = playerPublicDtoMapper;
        this.fluxSink = fluxSink;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        fluxSink.next(playerPublicDtoMapper.map((Set<Player>) propertyChangeEvent.getNewValue()));
    }
}
