package it.achtelik.worldoflife.usecases.player.core.model;

public class Player {
    private final String id;
    private final String password;
    private final String name;
    private final String hexColor;

    public Player(String id, String password, String name, String hexColor) {
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
