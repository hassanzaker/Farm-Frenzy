package Model.Animals;

import Model.Animals.Animal;
import Model.Cell;

public abstract class ProducerAnimal extends Animal {

    public abstract void eat();

    public abstract void produce(Cell[][] cells);

}
