package Domain.PokemonGame.Types;

public class Grass extends Type {

    public Grass() {
        this.naam = "Grass";

        this.weaknesses = new String[1];
        this.weaknesses[0] = "Fire";

        this.strength = new String[1];
        this.strength[0] = "Water";
    }
}
