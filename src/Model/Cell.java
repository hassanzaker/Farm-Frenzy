package Model;

public class Cell {
    private boolean hasGrass;
    private boolean hasWildAnimal;
    private boolean hasDomesticAnimal;
    private boolean hasItem;

    public boolean isHasGrass() {
        return hasGrass;
    }

    public void setHasGrass(boolean hasGrass) {
        this.hasGrass = hasGrass;
    }

    public boolean isHasWildAnimal() {
        return hasWildAnimal;
    }

    public void setHasWildAnimal(boolean hasWildAnimal) {
        this.hasWildAnimal = hasWildAnimal;
    }

    public boolean isHasDomesticAnimal() {
        return hasDomesticAnimal;
    }

    public void setHasDomesticAnimal(boolean hasDomesticAnimal) {
        this.hasDomesticAnimal = hasDomesticAnimal;
    }

    public boolean isHasItem() {
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }
}
