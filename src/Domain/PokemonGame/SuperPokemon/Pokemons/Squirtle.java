package Domain.PokemonGame.SuperPokemon.Pokemons;

import Domain.PokemonGame.SuperPokemon.Move;
import Domain.PokemonGame.SuperPokemon.Pokemon;
import Domain.PokemonGame.Types.Fire;
import Domain.PokemonGame.Types.Normal;
import Domain.PokemonGame.Types.Water;

public class Squirtle extends Pokemon {

    public Squirtle() {
        setNaam("Squirtle");
        setHp(50);
        Water water = new Water();
        setType(water);
        Move[] moves = new Move[4];
        moves[0] = new Move("Tackle", 5.00, new Normal());
        moves[1] = new Move("Water gun", 4.00, water);
        moves[2] = new Move("Rapid spin", 7.00, new Normal());
        moves[3] = new Move("Water pulse", 7, water);
        setMoves(moves);
    }
}
