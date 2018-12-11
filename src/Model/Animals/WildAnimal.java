package Model.Animals;

import Model.Animals.Animal;
import Model.Cell;

public abstract class WildAnimal extends Animal {
    protected int volume;

    public WildAnimal(int x, int y) {
        super(x, y);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void makeChangesOnCell(Cell cell, int a) {
        cell.setWildAnimalAmount(cell.getWildAnimalAmount()+ a);
    }

    public abstract void eat();
}
