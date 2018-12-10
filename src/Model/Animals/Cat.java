package Model.Animals;

import Model.Animals.Animal;
import Model.Cell;

public class Cat extends Animal {
    public void makeChangesOnCell(Cell cell, int a) {
        cell.setNumberOfCats(cell.getNumberOfCats()+ a);
    }

    @Override
    public void crash() {

    }
}
