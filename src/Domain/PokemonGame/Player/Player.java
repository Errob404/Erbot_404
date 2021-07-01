package Domain.PokemonGame.Player;

import Domain.PokemonGame.SuperPokemon.Pokemon;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private String naam;
    private ArrayList<Pokemon> team;

    public Player(String naam) {
        this.naam = naam;
        this.team = new ArrayList<>(6);
    }

    public void addPokemonToTeam(Pokemon pokemon){
        if (pokemon == null) throw new IllegalArgumentException();
        if (this.team.size() > 6) throw new IllegalArgumentException();
        team.add(pokemon);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(naam, player.naam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam);
    }

    public String getNaam() {
        return naam;
    }

    public ArrayList<Pokemon> getTeam() {
        return team;
    }

    public MessageEmbed getPlayerInfo(){
        EmbedBuilder info = new EmbedBuilder();
        info.setTitle("Info over het team van " + this.naam);
        info.setColor(Color.red);
        for (int i = 0; i != this.team.size(); i++){
            info.addField("Pokemon " + (i+1), team.get(i).toString(), false);
        }
        return  info.build();
    }
}
