package Domain.PokemonGame.Types;

public class Water extends Type{

    public Water() {
        this.naam = "Water";

        this.weaknesses = new String[1];
        this.weaknesses[0] = "Grass";

        this.strength = new String[1];
        this.strength[0] = "Fire";
    }
}
