package it.achtelik.worldoflife.usecases.player.core.model;

public class PlayerLogin {

    private final String name;

    public PlayerLogin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
