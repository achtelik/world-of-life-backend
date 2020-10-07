package it.achtelik.worldoflife.usecases.world.entrypoints.rest;

import it.achtelik.worldoflife.usecases.world.config.WorldProperties;
import it.achtelik.worldoflife.usecases.world.core.WorldService;
import it.achtelik.worldoflife.usecases.world.entrypoints.mapper.WorldDtoMapper;
import it.achtelik.worldoflife.usecases.world.entrypoints.mapper.WorldPositionDtoMapper;
import it.achtelik.worldoflife.usecases.world.entrypoints.model.WorldDto;
import it.achtelik.worldoflife.usecases.world.entrypoints.model.WorldPositionDto;
import it.achtelik.worldoflife.utils.JsonUtils;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.*;

import java.util.List;

@RestController
public class WorldController {

    private final WorldDtoMapper worldDtoMapper;
    private final WorldPositionDtoMapper worldPositionDtoMapper;
    private final WorldService worldService;
    private final WorldProperties worldProperties;
    private final JsonUtils jsonUtils;
    private final FluxProcessor<WorldDto, WorldDto> fluxProcessor;
    final FluxSink<WorldDto> fluxSink;

    public WorldController(WorldDtoMapper worldDtoMapper, WorldPositionDtoMapper worldPositionDtoMapper,
                           WorldService worldService, WorldProperties worldProperties, JsonUtils jsonUtils) {
        this.worldDtoMapper = worldDtoMapper;
        this.worldPositionDtoMapper = worldPositionDtoMapper;
        this.worldProperties = worldProperties;
        this.jsonUtils = jsonUtils;

        DirectProcessor<WorldDto> directProcessor = DirectProcessor.create();
        this.fluxProcessor = directProcessor.serialize();
        this.fluxSink = this.fluxProcessor.sink(FluxSink.OverflowStrategy.LATEST);

        this.worldService = worldService;
        this.worldService.addPropertyChangeListener(
                new WorldControllerWorldListener(this.worldDtoMapper, this.fluxSink));
    }

    @GetMapping(value = "/world", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<WorldDto>> getTest() {
        return fluxProcessor.map(event -> ServerSentEvent.builder(event).build());
    }

    @PutMapping("/world")
    public Mono<List<WorldPositionDto>> putCell(@RequestBody List<WorldPositionDto> worldPositionDtos) {
        return Mono.justOrEmpty(worldPositionDtoMapper.mapList(
                worldService.setCells(worldPositionDtoMapper.mapListDto(worldPositionDtos))));
    }
}
