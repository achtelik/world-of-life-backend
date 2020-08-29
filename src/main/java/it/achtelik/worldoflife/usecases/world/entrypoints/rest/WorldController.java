package it.achtelik.worldoflife.usecases.world.entrypoints.rest;

import it.achtelik.worldoflife.usecases.world.config.WorldProperties;
import it.achtelik.worldoflife.usecases.world.core.WorldService;
import it.achtelik.worldoflife.usecases.world.entrypoints.mapper.WorldDtoMapper;
import it.achtelik.worldoflife.usecases.world.entrypoints.mapper.WorldPositionDtoMapper;
import it.achtelik.worldoflife.usecases.world.entrypoints.model.WorldPositionDto;
import it.achtelik.worldoflife.utils.JsonUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class WorldController {

    private final WorldDtoMapper worldDtoMapper;
    private final WorldPositionDtoMapper worldPositionDtoMapper;
    private final WorldService worldService;
    private final WorldProperties worldProperties;
    private final JsonUtils jsonUtils;

    public WorldController(WorldDtoMapper worldDtoMapper, WorldPositionDtoMapper worldPositionDtoMapper,
                           WorldService worldService, WorldProperties worldProperties, JsonUtils jsonUtils) {
        this.worldDtoMapper = worldDtoMapper;
        this.worldPositionDtoMapper = worldPositionDtoMapper;
        this.worldService = worldService;
        this.worldProperties = worldProperties;
        this.jsonUtils = jsonUtils;
    }

    @GetMapping("/test")
    Flux<String> test() {
        return Flux.interval(Duration.ofSeconds(1)).take(3)
                .map(aLong -> String.format("event%d", aLong));
    }

    @GetMapping("/world")
    Flux<String> getWorld() {
        return Flux.interval(Duration.ZERO, worldProperties.getUpdateIntervalDuration())
                .flatMap(aLong -> Flux.just(jsonUtils.toJson(worldDtoMapper.map(worldService.getWorld()))));
    }

    @PutMapping("/world")
    Mono<Boolean> putCell(@RequestBody WorldPositionDto worldPosition) {
        return Mono.justOrEmpty(worldService.setCell(worldPositionDtoMapper.map(worldPosition)));
    }
}
