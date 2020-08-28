package it.achtelik.worldoflife.world.entrypoints.rest;

import it.achtelik.worldoflife.world.core.WorldService;
import it.achtelik.worldoflife.world.entrypoints.mapper.WorldDtoMapper;
import it.achtelik.worldoflife.world.entrypoints.mapper.WorldPositionDtoMapper;
import it.achtelik.worldoflife.world.entrypoints.model.WorldDto;
import it.achtelik.worldoflife.world.entrypoints.model.WorldPositionDto;
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

    public WorldController(WorldDtoMapper worldDtoMapper, WorldPositionDtoMapper worldPositionDtoMapper,
                           WorldService worldService) {
        this.worldDtoMapper = worldDtoMapper;
        this.worldPositionDtoMapper = worldPositionDtoMapper;
        this.worldService = worldService;
    }

    @GetMapping("/test")
    Flux<String> test() {
        return Flux.interval(Duration.ofSeconds(1)).take(3)
                .map(aLong -> String.format("event%d", aLong));
    }

    @GetMapping("/world")
    Mono<WorldDto> getWorld() {
        return Mono.justOrEmpty(worldDtoMapper.map(worldService.getWorld()));
    }

    @PutMapping("/world")
    Mono<Boolean> putCell(@RequestBody WorldPositionDto worldPosition) {
        return Mono.justOrEmpty(worldService.setCell(worldPositionDtoMapper.map(worldPosition)));
    }
}
