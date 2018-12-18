package Model;

import Model.Items.Item;

import java.util.ArrayList;

public class WereHouse {
    private int capacity;
    private int level;
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item){
          items.add(item);
    }

    public void deleteItem(Item item){
        items.remove(item);
    }

    public void upgrade(){
        this.level++;
        this.capacity = this.capacity * 2;
    }

    public int computeUpgradeCost(){
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
}
