package Model.Animals;

import Model.Animals.Animal;
import Model.Cell;
import Model.Ground;
import Model.Items.Item;

import java.util.Random;

public class Cat extends Animal {
    private int level;
    private int speed;

    public Cat(int x, int y, String ID) {
        super(x, y, ID);
        this.level = 1;
        this.speed = 10;
    }

    public int direction(Ground ground) {
        Random random = new Random();
        if (ground.getItems().size() == 0) {
            return random.nextInt(4) + 1;
        } else {
            int x = 0;
            int y = 0;
            if (this.level == 1) {
                int i = random.nextInt(ground.getItems().size());
                Item item = ground.getItems().get(i);
                x = item.getRow() - this.row;
                y = item.getColumn() - this.column;
            } else if (this.level == 2) {
                int[] distances = new int[ground.getItems().size()];
                int[] xs = new int[ground.getItems().size()];
                int[] ys = new int[ground.getItems().size()];
                for (int i = 0; i < ground.getItems().size(); i++) {
                    Item item = ground.getItems().get(i);
                    x = item.getRow() - this.row;
                    y = item.getColumn() - this.column;
                    xs[i] = x;
                    ys[i] = y;
                    distances[i] = x * x + y * y;
                }
                int min = distances[0];
                int lastIndexOfMin = 0;
                for (int i = 0; i < distances.length; i++) {
                    if (distances[i] < min) {
                        min = distances[i];
                        lastIndexOfMin = i;
                    }
                }
                x = xs[lastIndexOfMin];
                y = ys[lastIndexOfMin];
            }
            if (x > 0) {
                return 4;  //down
            } else if (x < 0) {
                return 2;  // up
            } else {
                if (y > 0) {
                    return 1; // right
                } else {
                    return 3;  // left
                }
            }

        }
    }

    public void upgrade(int money) throws Exception{
        if (money < computeUpgradeCost()){
            throw new Exception("not enough money!");
        }
        if (this.level == 2){
            throw new Exception("cat is max level!");
        }
        this.level++;
        this.speed += 5;
    }

    public int computeUpgradeCost() {
        return 2000;
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
        cell.setNumberOfCats(cell.getNumberOfCats() + a);
    }

}
