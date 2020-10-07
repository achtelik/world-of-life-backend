package it.achtelik.worldoflife.usecases.player.entrypoints.mapper;

import it.achtelik.worldoflife.usecases.player.core.model.Player;
import it.achtelik.worldoflife.usecases.player.entrypoints.model.PlayerPublicDto;

import java.util.Set;
import java.util.stream.Collectors;

public class PlayerPublicDtoMapper {

    public PlayerPublicDto map(Player player) {
        return new PlayerPublicDto(player.getId(),
                player.getName(),
                player.getHexColor());
    }

    public Set<PlayerPublicDto> map(Set<Player> players) {
        return players.stream().map(player -> map(player)).collect(Collectors.toSet());
    }
}
