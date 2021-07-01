package Test;

import Domain.PokemonGame.Types.Fire;
import Domain.PokemonGame.Types.Water;

public class Main {
    public static void main(String[] args) {
        Water water = new Water();
        Fire fire = new Fire();

        System.out.println(water.isSuperEffectiveAgainst(fire));
        System.out.println(water.isNeutralAgainst(fire));
        System.out.println(water.isWeakAgainst(fire));
    }
}
