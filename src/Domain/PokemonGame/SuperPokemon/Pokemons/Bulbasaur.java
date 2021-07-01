package Domain.PokemonGame.SuperPokemon.Pokemons;

import Domain.PokemonGame.SuperPokemon.Move;
import Domain.PokemonGame.SuperPokemon.Pokemon;
import Domain.PokemonGame.Types.Fire;
import Domain.PokemonGame.Types.Grass;
import Domain.PokemonGame.Types.Normal;

public class Bulbasaur extends Pokemon {

    public Bulbasaur() {
        Grass grass = new Grass();
        setNaam("Bulbasaur");
        setHp(50);
        setType(grass);
        Move[] moves = new Move[4];
        moves[0] = new Move("Tackle", 5.00, new Normal());
        moves[1] = new Move("Vinewhip", 4.00, grass);
        moves[2] = new Move("Take down", 7.00, new Normal());
        moves[3] = new Move("Razor leaf", 7, grass);
        setMoves(moves);
    }
}
