package Model.Transportation;

import Model.Box;
import Model.Items.Item;

import java.util.ArrayList;

public class Helicopter {


    private int level;
    private int maxLevel;
    private int timeToTransit;
    private boolean isInWork;
    private int buyPrice;

    private ArrayList<Box> boxes = new ArrayList<>();

    public Helicopter() {
        boxes.add(new Box());
        boxes.add(new Box());
        level=1;
        maxLevel=4;
        isInWork=false;
    }
    public  void clearTruck()
    {
        for (int i = 0; i < boxes.size() ; i++) {
            boxes.get(i).clearBox();
        }
    }
    public void addItem(Item item , Box box) throws Exception {
        box.addItem(item);
    }
    public void buy() {
        isInWork=true;
        for (int i = 0; i < boxes.size(); i++) {
            buyPrice += boxes.get(i).getBuyPrice();
            boxes.get(i).clearBox();
        }

    }
    public void upgrade() throws Exception{
        if(level == maxLevel)
        {
            throw new Exception("max level exceeded");
        }
        else {
            level++;
            boxes.add(new Box());
            boxes.add(new Box());
        }
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

    public boolean isInWork() {
        return isInWork;
    }

    public void setInWork(boolean inWork) {
        isInWork = inWork;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

}
