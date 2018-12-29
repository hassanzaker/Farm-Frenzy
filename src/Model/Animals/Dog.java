package Model.Animals;

import Model.Cell;
import Model.Ground;

import java.util.Random;

public class Dog extends Animal {
    private int level;
    private int speed;

    public Dog(int x, int y, String ID) {
        super(x, y, ID);
        this.level = 1;
        this.speed = 10;
        this.name = "dog";
        this.cost = 3000;
    }

    @Override
    public void checkTime(Ground ground) throws Exception {
        super.checkTime(ground);
    }

    public int direction(Ground ground) {
        if (ground.getWildAnimals().size() == 0) {
            Random random = new Random();
            return random.nextInt(4) + 1;
        } else {
            WildAnimal wildAnimal = ground.getWildAnimals().get(0);
            int wildAnimalX = wildAnimal.getRow();
            int wildAnimalY = wildAnimal.getColumn();
            int x = wildAnimalX - this.row;
            int y = wildAnimalY - this.column;
            if (x > 0) {
                return 4;  //down
            }
            else if (x < 0){
                return 2;  // up
            }
            else {
                if (y>0){
                    return 1; // right
                }
                else{
                    return 3;  // left
                }
            }
        }
    }


    public void crash(Ground ground) throws Exception {
        for (int i=0 ; i<ground.getItems().size() ; i++){
            if (ground.getItems().get(i).getRow() == this.row && ground.getItems().get(i).getColumn() == this.column){
                ground.deleteItem(ground.getItems().get(i));
                ground.getWereHouse().addItem(ground.getItems().get(i));
                break;
            }
        }
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




    public void makeChangesOnCell(Cell cell, int a) {
        cell.setNumberOfDogs(cell.getNumberOfDogs() + a);
    }

}