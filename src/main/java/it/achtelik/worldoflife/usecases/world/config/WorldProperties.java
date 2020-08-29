package it.achtelik.worldoflife.usecases.world.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.time.Duration;

@ConstructorBinding
@ConfigurationProperties(prefix = "app")
public class WorldProperties {
    private final Duration updateIntervalDuration;

    public WorldProperties(Duration updateIntervalDuration) {
        this.updateIntervalDuration = updateIntervalDuration;
    }

    public Duration getUpdateIntervalDuration() {
        return updateIntervalDuration;
    }
}
