package Model;

import java.io.FileNotFoundException;

public class GameModel implements java.io.Serializable {
    private Player player;
    private MapReader gameMap = new MapReader();

    public GameModel() throws FileNotFoundException {
        player = new Player("Player", gameMap);
    }



    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public MapReader getGameMap() {
        return gameMap;
    }

    public void setGameMap(MapReader gameMap) {
        this.gameMap = gameMap;
    }
}
