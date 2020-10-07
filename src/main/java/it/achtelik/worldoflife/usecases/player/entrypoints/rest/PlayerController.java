package it.achtelik.worldoflife.usecases.player.entrypoints.rest;

import it.achtelik.worldoflife.usecases.player.core.PlayerService;
import it.achtelik.worldoflife.usecases.player.entrypoints.mapper.PlayerLoginDtoMapper;
import it.achtelik.worldoflife.usecases.player.entrypoints.mapper.PlayerPrivateDtoMapper;
import it.achtelik.worldoflife.usecases.player.entrypoints.mapper.PlayerPublicDtoMapper;
import it.achtelik.worldoflife.usecases.player.entrypoints.model.PlayerLoginDto;
import it.achtelik.worldoflife.usecases.player.entrypoints.model.PlayerPrivateDto;
import it.achtelik.worldoflife.usecases.player.entrypoints.model.PlayerPublicDto;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.*;

import java.util.Set;

@RestController
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerPublicDtoMapper playerPublicDtoMapper;
    private final PlayerPrivateDtoMapper playerPrivateDtoMapper;
    private final PlayerLoginDtoMapper playerLoginDtoMapper;
    private final FluxProcessor<Set<PlayerPublicDto>, Set<PlayerPublicDto>> fluxProcessor;
    final FluxSink<Set<PlayerPublicDto>> fluxSink;

    public PlayerController(PlayerService playerService,
                            PlayerPublicDtoMapper playerPublicDtoMapper,
                            PlayerPrivateDtoMapper playerPrivateDtoMapper,
                            PlayerLoginDtoMapper playerLoginDtoMapper) {
        this.playerPublicDtoMapper = playerPublicDtoMapper;
        this.playerPrivateDtoMapper = playerPrivateDtoMapper;
        this.playerLoginDtoMapper = playerLoginDtoMapper;

        DirectProcessor<Set<PlayerPublicDto>> directProcessor = DirectProcessor.create();
        this.fluxProcessor = directProcessor.serialize();
        this.fluxSink = this.fluxProcessor.sink(FluxSink.OverflowStrategy.LATEST);

        this.playerService = playerService;
        this.playerService.addPropertyChangeListener(
                new PlayerControllerPlayerListener(this.playerPublicDtoMapper, this.fluxSink));
    }

    @GetMapping(value = "/players", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Set<PlayerPublicDto>>> list() {
        return fluxProcessor.map(event -> ServerSentEvent.builder(event).build());
    }

    @PostMapping(value = "/players")
    public Mono<PlayerPrivateDto> login(@RequestBody PlayerLoginDto playerLoginDto) {
        return Mono.justOrEmpty(playerPrivateDtoMapper.map(
                playerService.login(playerLoginDtoMapper.map(playerLoginDto))));
    }
}
