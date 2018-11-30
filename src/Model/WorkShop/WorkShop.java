package Model.WorkShop;

import Model.Items.Item;

import java.util.ArrayList;

public abstract class WorkShop {
    protected int level;
    protected int timeToWork;


    public ArrayList<Item> work(Item item){
        return new ArrayList<>(0);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTimeToWork() {
        return timeToWork;
    }

    public void setTimeToWork(int timeToWork) {
        this.timeToWork = timeToWork;
    }
}
