package Model;

import Model.Items.Egg;
import Model.Items.Item;

import java.util.ArrayList;

public class WereHouse {
    private int capacity;
    private int level;
    private int currentCapacity;
    private ArrayList<Item> items = new ArrayList<>();

    public WereHouse() {
        currentCapacity = 0;
        this.capacity = 50;
        this.level = 1;
        items.add(new Egg(-11, -11, "", false));
        items.add(new Egg(-11, -11, "", false));
        items.add(new Egg(-11, -11, "", false));
    }

    public void addItem(Item item) throws Exception {
        if (item.getVolume() + currentCapacity > capacity) {
            throw new Exception("no free space exists");
        } else {
            items.add(item);
            currentCapacity += item.getVolume();
        }
    }

    public void deleteItem(Item item) {
        items.remove(item);
        currentCapacity -= item.getVolume();
    }

    public void upgrade(int money) throws Exception {
        if (computeUpgradeCost() > money) {
            throw new Exception("not enough money!");
        }
        if (this.level == 4) {
            throw new Exception("wereHouse is max level!");
        }
        this.level++;
        this.capacity = this.capacity * 2;
    }

    public int computeUpgradeCost() {
        return this.level * 200;
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

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        String s = "wereHouse level : " + String.valueOf(this.level) + "\n" +
                "capacity : " + String.valueOf(this.capacity) + "\n" +
                "current amount : " + String.valueOf(this.currentCapacity) + "\n" +
                "empty : " + String.valueOf(this.capacity - this.currentCapacity) + "\n" ;
        return s;
    }
}
