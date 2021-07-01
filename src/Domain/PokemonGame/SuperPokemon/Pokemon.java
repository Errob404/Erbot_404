package Domain.PokemonGame.SuperPokemon;

import Domain.PokemonGame.Types.Type;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;
import java.util.Arrays;

public class Pokemon
{
    private String naam;
    private double hp;
    private Type type;
    private Move[] moves;

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setMoves(Move[] moves) {
        this.moves = moves;
    }

    public void setNickname(String nickname){
        this.naam = nickname;
    }

    public String getNaam() {
        return naam;
    }

    public Type getType() {
        return type;
    }

    public Move[] getMoves() {
        return moves;
    }

    public double getHp() {
        return hp;
    }

    public MessageEmbed giveInfo() {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setColor(Color.red);
        builder.setTitle("Pokemon");
        builder.addField("Naam:", this.getNaam(), false);
        builder.addField("HP:", "" + this.getHp(), false);
        builder.addField("Type", this.getType().getNaam(), false);
        for (int i = 0; i < 4; i++) {
            builder.addField("Move " + (i + 1), moves[i].getNaam(), true);
        }
        return builder.build();
    }

    @Override
    public String toString() {
        String result = this.getNaam();
        result += "\nHP: " + getHp();
        result += "\nType: " + getType().getNaam();
        result += "\nMove 1: " + moves[0] + "\nMove 2: " + moves[1];
        result += "\nMove 3: " + moves[2] + "\nMove 4: " + moves[3];
        return result;
    }
}
