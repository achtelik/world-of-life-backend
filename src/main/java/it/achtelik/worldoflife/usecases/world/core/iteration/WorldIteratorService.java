package it.achtelik.worldoflife.usecases.world.core.iteration;

import it.achtelik.worldoflife.usecases.world.core.model.World;
import it.achtelik.worldoflife.usecases.world.core.model.WorldPosition;

import java.util.HashSet;
import java.util.Set;

public class WorldIteratorService {
    private final WorldPositionService worldPositionService;

    public WorldIteratorService(WorldPositionService worldPositionService) {
        this.worldPositionService = worldPositionService;
    }

    public World calculateNewIteration(World world) {
        World newWorld = new World();
        Set<WorldPosition> worldPositionsCurrentAlive = world.getWorldCells().keySet();
        Set<WorldPosition> worldPositionsCurrentDead = determineWorldPositionsToCalculate(world);
        Set<WorldPosition> worldPositionsAll = new HashSet<>(worldPositionsCurrentAlive);
        worldPositionsAll.addAll(worldPositionsCurrentDead);

        Set<WorldPosition> newWorldPositions = new HashSet<>();
        newWorldPositions.addAll(determineNewWorldPosition(true, worldPositionsCurrentAlive,
                worldPositionsCurrentAlive));
        newWorldPositions.addAll(determineNewWorldPosition(false, worldPositionsCurrentDead,
                worldPositionsCurrentAlive));

        for (WorldPosition worldPosition : newWorldPositions) {
            newWorld.setCell(worldPosition);
        }

        return newWorld;
    }

    private Set<WorldPosition> determineWorldPositionsToCalculate(World world) {
        Set<WorldPosition> worldPositions = new HashSet<>();
        for (WorldPosition worldPosition : world.getWorldCells().keySet()) {
            worldPositions.addAll(worldPositionService.determineNeighbourhoodPositions(worldPosition));
        }
        return worldPositions;
    }


    private int determineLivingNeighbours(WorldPosition worldPosition, Set<WorldPosition> worldPositions) {
        Set<WorldPosition> neighbours = worldPositionService.determineNeighbourhoodPositions(worldPosition);
        neighbours.retainAll(worldPositions);
        return neighbours.size();
    }

    private boolean isAliveInNewIteration(boolean currentAlive, int livingNeighbhours) {
        if (currentAlive) {
            return (2 == livingNeighbhours || 3 == livingNeighbhours);
        } else {
            return (3 == livingNeighbhours);
        }
    }

    private Set<WorldPosition> determineNewWorldPosition(boolean currrentAlive,
                                                         Set<WorldPosition> worldPositionsToCalculate,
                                                         Set<WorldPosition> worldPositionsCurrentAlive) {
        Set<WorldPosition> worldPositions = new HashSet<>();
        for (WorldPosition worldPosition : worldPositionsToCalculate) {
            int livingNeighbhoursCount = determineLivingNeighbours(worldPosition, worldPositionsCurrentAlive);
            if (isAliveInNewIteration(currrentAlive, livingNeighbhoursCount)) {
                worldPositions.add(worldPosition);
            }
        }
        return worldPositions;
    }


}
