package it.achtelik.worldoflife.world.core.model;

import java.util.HashMap;

public class World {
    private final HashMap<WorldPosition, WorldCell> worldCells = new HashMap<>();

    public Boolean setCell(WorldPosition worldPosition) {
        if (worldCells.containsKey(worldPosition)) {
            return false;
        }
        worldCells.put(worldPosition, new WorldCell(worldPosition));
        return true;
    }

    public HashMap<WorldPosition, WorldCell> getWorldCells() {
        return worldCells;
    }
}
