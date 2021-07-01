package Domain.PokemonGame.SuperPokemon.Pokemons;

import Domain.PokemonGame.SuperPokemon.Move;
import Domain.PokemonGame.SuperPokemon.Pokemon;
import Domain.PokemonGame.Types.Fire;
import Domain.PokemonGame.Types.Normal;

public class Charmander extends Pokemon {

    public Charmander() {
        setNaam("Charmander");
        setHp(50);
        Fire fire = new Fire();
        setType(fire);
        Move[] moves = new Move[4];
        moves[0] = new Move("Scratch", 5.00, new Normal());
        moves[1] = new Move("Flamethrower", 4.00, fire);
        moves[2] = new Move("Slash", 7.00, new Normal());
        moves[3] = new Move("Fire fang", 7, fire);
        setMoves(moves);
    }
}
