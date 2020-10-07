package it.achtelik.worldoflife.usecases.world.entrypoints.scheduler;

import it.achtelik.worldoflife.usecases.world.core.WorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WorldScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorldScheduler.class);

    private final WorldService worldService;

    public WorldScheduler(WorldService worldService) {
        this.worldService = worldService;
    }

    @Scheduled(fixedRate = 300)
    public void calculateNewIteration() {
        boolean iterationResult = worldService.calculateNewIteration();
        LOGGER.info(String.format("World iteration successfull=%s", iterationResult));
    }
}
