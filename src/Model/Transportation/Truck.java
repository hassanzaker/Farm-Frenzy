package Model.Transportation;

import Model.Box;
import Model.Ground;
import Model.Items.Item;

import java.util.ArrayList;

public class Truck {
    private int level;
    private int maxLevel;
    private int timeToTransit;
    private int currentTime;
    private boolean isInWorking;
    private ArrayList<Box> boxes = new ArrayList<>();

    public Truck() {
        boxes.add(new Box());
        boxes.add(new Box());
        level = 1;
        maxLevel = 4;
        isInWorking = false;
    }

    public void clearTruck() {
        for (int i = 0; i < boxes.size(); i++) {
            boxes.get(i).clearBox();
        }
    }

    public void addItem(Item item, Box box) throws Exception {
        box.addItem(item);
    }

    public void sell() {
        isInWorking = true;

    }

    public int computeSellPrice() {
        int sum = 0;
        for (Box boxes1 :
                this.boxes) {
            sum += boxes1.getSellPrice();
        }
        return sum;
    }

    public void checkTime(Ground ground) {
        if (isInWorking) {
            this.currentTime++;
            if (this.currentTime == this.timeToTransit) {
                ground.setMoney(ground.getMoney() + computeSellPrice());
                this.currentTime = 0;
                this.isInWorking = false;
            }
        }
    }


    public void upgrade() throws Exception {
        if (level == maxLevel) {
            throw new Exception("max level exceeded");
        } else {
            level++;
            boxes.add(new Box());
            boxes.add(new Box());
        }
    }

    public int computeUpgradeCost() {
        return this.level * this.level * 100;
    }


    public int getTimeToTransit() {
        return timeToTransit;
    }

    public void setTimeToTransit(int timeToTransit) {
        this.timeToTransit = timeToTransit;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public boolean isInWorking() {
        return isInWorking;
    }

    public void setInWorking(boolean inWorking) {
        isInWorking = inWorking;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }
}
