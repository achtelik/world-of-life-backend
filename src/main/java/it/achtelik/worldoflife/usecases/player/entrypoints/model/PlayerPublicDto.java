package it.achtelik.worldoflife.usecases.player.entrypoints.model;

public class PlayerPublicDto {

    private final String id;
    private final String name;
    private final String hexColor;

    public PlayerPublicDto(String id, String name, String hexColor) {
        this.id = id;
        this.name = name;
        this.hexColor = hexColor;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHexColor() {
        return hexColor;
    }
}
