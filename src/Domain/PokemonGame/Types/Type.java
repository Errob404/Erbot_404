package Domain.PokemonGame.Types;

public abstract class Type {
    protected String naam;
    protected String[] weaknesses;
    protected String[] strength;

    public boolean isSuperEffectiveAgainst(Type otherType) {
        for (String type : this.getStrength()){
            if (type.equalsIgnoreCase(otherType.getNaam())) return true;
        }
        return false;
    }

    public boolean isWeakAgainst(Type otherType) {
        for (String type : this.getWeaknesses()){
            if (type.equalsIgnoreCase(otherType.getNaam())) return true;
        }
        return false;
    }

    public boolean isNeutralAgainst(Type otherType) {
        return !this.isSuperEffectiveAgainst(otherType) && !this.isWeakAgainst(otherType);
    }

    public String getNaam() {
        return naam;
    }

    public String[] getWeaknesses() {
        return weaknesses;
    }

    public String[] getStrength() {
        return strength;
    }
}
