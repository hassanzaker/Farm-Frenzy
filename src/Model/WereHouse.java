package Model;

import Model.Items.Item;

import java.util.ArrayList;

public class WereHouse {
    private int capacity;
    private int level;
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item){

    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
