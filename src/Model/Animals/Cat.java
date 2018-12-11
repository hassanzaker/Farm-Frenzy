package Model.Animals;

import Model.Animals.Animal;
import Model.Cell;

public class Cat extends Animal {
    private int level;
    private int speed;

    public Cat(int level, int speed, int x, int y) {
        super(x, y);
        this.level = level;
        this.speed = speed;
    }


    public int getLevel() {

        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void makeChangesOnCell(Cell cell, int a) {
        cell.setNumberOfCats(cell.getNumberOfCats()+ a);
    }

    @Override
    public void crash() {

    }
}
