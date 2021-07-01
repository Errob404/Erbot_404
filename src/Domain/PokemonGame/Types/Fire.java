package Domain.PokemonGame.Types;

public class Fire extends Type{

    public Fire() {
        this.naam = "Fire";

        this.weaknesses = new String[1];
        this.weaknesses[0] = "Water";

        this.strength = new String[1];
        this.strength[0] = "Grass";
    }
}
