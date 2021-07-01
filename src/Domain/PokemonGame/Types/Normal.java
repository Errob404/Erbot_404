package Domain.PokemonGame.Types;

public class Normal extends Type {

    public Normal() {
        this.naam = "Normal";

        this.weaknesses = new String[2];
        this.weaknesses[0] = "Rock";
        this.weaknesses[1] = "Steel";

        this.strength = new String[0];
    }
}
