package it.achtelik.worldoflife.usecases.world.core.iteration;

import it.achtelik.worldoflife.usecases.world.core.model.WorldPosition;

import java.util.HashSet;
import java.util.Set;

public class WorldPositionService {

    public Set<WorldPosition> determineNeighbourhoodPositions(WorldPosition worldPosition) {
        Set<WorldPosition> neighbourhoodPositions = new HashSet<>();
        for (int xPosOffset = -1; xPosOffset <= 1; xPosOffset++) {
            for (int yPosOffset = -1; yPosOffset <= 1; yPosOffset++) {
                if (xPosOffset != 0 || yPosOffset != 0) {
                    neighbourhoodPositions.add(
                            new WorldPosition(worldPosition.getX() + xPosOffset, worldPosition.getY() + yPosOffset));
                }
            }
        }
        return neighbourhoodPositions;
    }
}
