package it.achtelik.worldoflife.usecases.player.entrypoints.model;

public class PlayerPrivateDto {

    private final String id;
    private final String password;
    private final String name;
    private final String hexColor;

    public PlayerPrivateDto(String id, String password, String name, String hexColor) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.hexColor = hexColor;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getHexColor() {
        return hexColor;
    }
}
