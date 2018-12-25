package Model.Transportation;

import Model.Box;
import Model.Ground;
import Model.Items.*;

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

    public void addItem(String type, Ground ground) throws Exception {
        Boolean checkItemInWereHouse = false;
        Boolean checkItemCanAddToBox = false;
        for (int i = 0; i < ground.getWereHouse().getItems().size(); i++) {
            if (ground.getWereHouse().getItems().get(i).getType().equals(type)) {
                checkItemInWereHouse = true;
                for (int j = 0; j < boxes.size(); j++) {
                    if (boxes.get(j).checkFull() == false) {
                        if (boxes.get(j).typeOfBox().equals(type) || boxes.get(j).typeOfBox().equals("none")) {
                            checkItemCanAddToBox = true;
                            boxes.get(j).addItem(ground.getWereHouse().getItems().get(i));
                            ground.getWereHouse().deleteItem(ground.getWereHouse().getItems().get(i));
                            break;
                        }
                    }
                }
                break;
            }
        }
        if (checkItemInWereHouse == false) {
            throw new Exception("item not found in the werehouse");
        }
        if (checkItemCanAddToBox == false) {
            throw new Exception(" item can not add to box");
        }
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


    public void upgrade(int money) throws Exception {
        if (level == maxLevel) {
            throw new Exception("max level exceeded");
        }
        if (money < computeUpgradeCost()){
            throw new Exception("not enough money!");
        }
        level++;
        boxes.add(new Box());
        boxes.add(new Box());

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

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public void setBoxes(ArrayList<Box> boxes) {

        this.boxes = boxes;
    }
}
