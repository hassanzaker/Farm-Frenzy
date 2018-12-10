package Model.Animals;

import Model.Cell;

public class Dog extends Animal {

    public void makeChangesOnCell(Cell cell, int a) {
        cell.setNumberOfDogs(cell.getNumberOfDogs()+ a);
    }

    @Override
    public void crash() {

    }
}
