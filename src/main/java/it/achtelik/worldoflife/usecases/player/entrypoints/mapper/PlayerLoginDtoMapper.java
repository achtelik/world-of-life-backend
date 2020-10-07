package it.achtelik.worldoflife.usecases.player.entrypoints.mapper;

import it.achtelik.worldoflife.usecases.player.core.model.PlayerLogin;
import it.achtelik.worldoflife.usecases.player.entrypoints.model.PlayerLoginDto;

public class PlayerLoginDtoMapper {

    public PlayerLogin map(PlayerLoginDto playerLoginDto) {
        return new PlayerLogin(playerLoginDto.getName());
    }
}
