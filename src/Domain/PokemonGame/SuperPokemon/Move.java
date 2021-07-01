package Domain.PokemonGame.SuperPokemon;

import Domain.PokemonGame.Types.Type;

public class Move {
    private String naam;
    private double damage;
    private Type type;

    public Move(String naam, double damage, Type type) {
        this.naam = naam;
        this.damage = damage;
        this.type = type;
    }

    public double getDamageMultiplier(Pokemon enemy)
    {
        double multiplier = 1;
        if (this.getType().isSuperEffectiveAgainst(enemy.getType())) multiplier *= 2;
        if (this.getType().isWeakAgainst(enemy.getType())) multiplier /= 2;
        return multiplier;
    }

    public String getNaam() {
        return naam;
    }

    public double getDamage() {
        return damage;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.naam + ", Damage: " + this.damage + ", Type: " + this.type.getNaam();
    }
}
