package it.achtelik.worldoflife.usecases.world.config;

import it.achtelik.worldoflife.usecases.world.core.WorldService;
import it.achtelik.worldoflife.usecases.world.core.iteration.WorldIteratorService;
import it.achtelik.worldoflife.usecases.world.core.iteration.WorldPositionService;
import it.achtelik.worldoflife.usecases.world.entrypoints.mapper.WorldCellDtoMapper;
import it.achtelik.worldoflife.usecases.world.entrypoints.mapper.WorldDtoMapper;
import it.achtelik.worldoflife.usecases.world.entrypoints.mapper.WorldPositionDtoMapper;
import it.achtelik.worldoflife.utils.JsonUtils;
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
    public WorldPositionService getWorldPositionService() {
        return new WorldPositionService();
    }

    @Bean
    public WorldIteratorService getWorldIteratorService(WorldPositionService worldPositionService) {
        return new WorldIteratorService(worldPositionService);
    }

    @Bean
    public WorldService getWorldService(JsonUtils jsonUtils, WorldIteratorService worldIteratorService) {
        return new WorldService(jsonUtils, worldIteratorService);
    }
}
