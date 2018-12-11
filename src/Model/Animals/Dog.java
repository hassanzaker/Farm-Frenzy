package Model.Animals;

import Model.Cell;

public class Dog extends Animal {
    private int level;
    private int speed;

    public Dog(int level, int speed, int x, int y) {
        super(x, y);
        this.level = level;
        this.speed = speed;
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


    public int getLevel() {
        return level;
    }

    public void upgrade(){
        this.level++;
    }

    public void makeChangesOnCell(Cell cell, int a) {
        cell.setNumberOfDogs(cell.getNumberOfDogs()+ a);
    }

    @Override
    public void crash() {

    }
}
