package Domain.PokemonGame.PlayerDB;

import Domain.PokemonGame.Player.Player;

import java.util.ArrayList;

public class DB {
    ArrayList<Player> players;

    public DB() {
        players = new ArrayList<>();
    }

    public void registerPlayer(String naam){
        Player player = new Player(naam);
        players.add(player);
    }

    public Player getPlayer(String naam){
        for (Player p: players){
            if (p.getNaam().equalsIgnoreCase(naam)){
                return p;
            }
        }
        return null;
    }
}
