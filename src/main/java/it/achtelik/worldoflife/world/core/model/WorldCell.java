package it.achtelik.worldoflife.world.core.model;

public class WorldCell {
    private final WorldPosition worldPosition;

    public WorldCell(WorldPosition worldPosition) {
        this.worldPosition = worldPosition;
    }

    public WorldPosition getWorldPosition() {
        return worldPosition;
    }
}
