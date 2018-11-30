package Model.Animals;

import Model.Animals.Animal;
import Model.Cell;

public abstract class WildAnimal extends Animal {
    protected int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public abstract void eat(Cell[][] cells);
}
