package it.achtelik.worldoflife.usecases.player.core;

import it.achtelik.worldoflife.usecases.player.core.model.Player;
import it.achtelik.worldoflife.usecases.player.core.model.PlayerLogin;
import it.achtelik.worldoflife.utils.HexColorUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.Set;

public class PlayerService {

    private final Set<Player> players = new HashSet<>();

    private final PropertyChangeSupport changes;
    private final HexColorUtils hexColorUtils;

    public PlayerService(HexColorUtils hexColorUtils) {
        this.changes = new PropertyChangeSupport(this);
        this.hexColorUtils = hexColorUtils;
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        changes.addPropertyChangeListener(propertyChangeListener);
    }

    public Player login(PlayerLogin playerLogin) {
        Player player = new Player(RandomStringUtils.random(100, true, true),
                RandomStringUtils.random(100, true, true),
                playerLogin.getName(), hexColorUtils.randomHexColor());
        players.add(player);
        changes.firePropertyChange("players", null, this.players);
        return player;
    }
}
