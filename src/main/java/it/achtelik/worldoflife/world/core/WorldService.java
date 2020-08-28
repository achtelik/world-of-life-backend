package it.achtelik.worldoflife.world.core;

import it.achtelik.worldoflife.world.core.model.World;
import it.achtelik.worldoflife.world.core.model.WorldPosition;

public class WorldService {

    private final World world = new World();

    public Boolean setCell(WorldPosition worldPosition) {
        return world.setCell(worldPosition);
    }

    public World getWorld() {
        return world;
    }

    public Boolean calculateNewIteration() {
        return true;
    }
}
