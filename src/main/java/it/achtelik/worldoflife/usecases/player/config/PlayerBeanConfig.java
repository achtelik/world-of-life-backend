package it.achtelik.worldoflife.usecases.player.config;

import it.achtelik.worldoflife.usecases.player.core.PlayerService;
import it.achtelik.worldoflife.usecases.player.entrypoints.mapper.PlayerLoginDtoMapper;
import it.achtelik.worldoflife.usecases.player.entrypoints.mapper.PlayerPrivateDtoMapper;
import it.achtelik.worldoflife.usecases.player.entrypoints.mapper.PlayerPublicDtoMapper;
import it.achtelik.worldoflife.utils.HexColorUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerBeanConfig {

    @Bean
    public PlayerService getPlayerService(HexColorUtils hexColorUtils) {
        return new PlayerService(hexColorUtils);
    }

    @Bean
    public PlayerLoginDtoMapper getPlayerLoginDtoMapper() {
        return new PlayerLoginDtoMapper();
    }

    @Bean
    public PlayerPublicDtoMapper getPlayerPublicDtoMapper() {
        return new PlayerPublicDtoMapper();
    }

    @Bean
    public PlayerPrivateDtoMapper getPlayerPrivateDtoMapper() {
        return new PlayerPrivateDtoMapper();
    }


}
