package it.achtelik.worldoflife.usecases.world.core;

import it.achtelik.worldoflife.usecases.world.core.iteration.WorldIteratorService;
import it.achtelik.worldoflife.usecases.world.core.model.World;
import it.achtelik.worldoflife.usecases.world.core.model.WorldPosition;
import it.achtelik.worldoflife.utils.JsonUtils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;
import java.util.stream.Collectors;

public class WorldService {

    private World world = new World();

    private final PropertyChangeSupport changes;
    private final JsonUtils jsonUtils;
    private final WorldIteratorService worldIteratorService;

    public WorldService(JsonUtils jsonUtils, WorldIteratorService worldIteratorService) {
        this.changes = new PropertyChangeSupport(this);
        this.jsonUtils = jsonUtils;
        this.worldIteratorService = worldIteratorService;
    }

    public Boolean setCell(WorldPosition worldPosition) {
        Boolean result = world.setCell(worldPosition);
        if (result) {
            changes.firePropertyChange("world", null, this.world);
        }
        return result;
    }

    public List<WorldPosition> setCells(List<WorldPosition> worldPositions) {
        List<WorldPosition> notSetableWorldPositions = worldPositions.stream()
                .filter(worldPosition -> !world.setCell(worldPosition)).collect(Collectors.toList());
        if (notSetableWorldPositions.size() < worldPositions.size()) {
            changes.firePropertyChange("world", null, this.world);
        }
        return notSetableWorldPositions;
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        changes.addPropertyChangeListener(propertyChangeListener);
    }

    public World getWorld() {
        return world;
    }

    public boolean calculateNewIteration() {
        World oldWord = this.world;
        this.world = worldIteratorService.calculateNewIteration(this.world);
        changes.firePropertyChange("world", oldWord, this.world);
        return true;
    }
}
