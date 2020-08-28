package it.achtelik.worldoflife.world.config;

import it.achtelik.worldoflife.world.core.WorldService;
import it.achtelik.worldoflife.world.entrypoints.mapper.WorldCellDtoMapper;
import it.achtelik.worldoflife.world.entrypoints.mapper.WorldDtoMapper;
import it.achtelik.worldoflife.world.entrypoints.mapper.WorldPositionDtoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorldBeanConfig {

    @Bean
    public WorldPositionDtoMapper getWorldPositionDtoMapper() {
        return new WorldPositionDtoMapper();
    }

    @Bean
    public WorldCellDtoMapper getWorldCellDtoMapper(WorldPositionDtoMapper worldPositionDtoMapper) {
        return new WorldCellDtoMapper(worldPositionDtoMapper);
    }

    @Bean
    public WorldDtoMapper getWorldDtoMapper(WorldCellDtoMapper worldCellDtoMapper) {
        return new WorldDtoMapper(worldCellDtoMapper);
    }

    @Bean
    public WorldService getWorldService() {
        return new WorldService();
    }
}
