package Model.Animals;

import Model.Animals.Animal;
import Model.Cell;

public abstract class ProducerAnimal extends Animal {

    public abstract void eat();

    public void makeChangesOnCell(Cell cell, int a) {
        cell.setDomesticAnimalAmount(cell.getDomesticAnimalAmount()+ a);
    }

    public abstract void produce(Cell[][] cells);

}
