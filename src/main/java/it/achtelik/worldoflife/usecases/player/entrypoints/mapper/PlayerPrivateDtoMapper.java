package it.achtelik.worldoflife.usecases.player.entrypoints.mapper;

import it.achtelik.worldoflife.usecases.player.core.model.Player;
import it.achtelik.worldoflife.usecases.player.entrypoints.model.PlayerPrivateDto;

import java.util.Set;
import java.util.stream.Collectors;

public class PlayerPrivateDtoMapper {

    public PlayerPrivateDto map(Player player) {
        return new PlayerPrivateDto(player.getId(),
                player.getPassword(),
                player.getName(),
                player.getHexColor());
    }

    public Set<PlayerPrivateDto> map(Set<Player> players) {
        return players.stream().map(player -> map(player)).collect(Collectors.toSet());
    }
}
