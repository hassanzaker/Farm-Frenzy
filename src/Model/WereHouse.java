package Model;

import Model.Items.*;

import java.util.ArrayList;

public class WereHouse {
    private int capacity;
    private int current;
    private int level;
    private ArrayList<Item> eggs = new ArrayList<>();
    private ArrayList<Item> milks = new ArrayList<>();
    private ArrayList<Item> wools = new ArrayList<>();
    private ArrayList<Item> eggPowders = new ArrayList<>();
    private ArrayList<Item> cookies = new ArrayList<>();
    private ArrayList<Item> cakes = new ArrayList<>();

    public void addItem(Item item) throws Exception{
        if (item.getVolume() > (this.capacity - this.current))
            throw new Exception("can't be added");
        else if (this.capacity == this.current)
            throw new Exception("it is full");
        if (item instanceof Egg) {
            eggs.add(item);
        } else if (item instanceof EggPowder) {
            eggPowders.add(item);
        } else if (item instanceof Cake) {
            cakes.add(item);
        } else if (item instanceof Wool) {
            wools.add(item);
        } else if (item instanceof Cookie) {
            cookies.add(item);
        } else if (item instanceof Milk) {
            milks.add(item);
        }
        current += item.getVolume();
    }



    public void deleteItem(Item item){
        if (item instanceof Egg) {
            eggs.remove(item);
        } else if (item instanceof EggPowder) {
            eggPowders.remove(item);
        } else if (item instanceof Cake) {
            cakes.remove(item);
        } else if (item instanceof Wool) {
            wools.remove(item);
        } else if (item instanceof Cookie) {
            cookies.remove(item);
        } else if (item instanceof Milk) {
            milks.remove(item);
        }
        this.current -= item.getVolume();
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

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public ArrayList<Item> getEggs() {
        return eggs;
    }

    public void setEggs(ArrayList<Item> eggs) {
        this.eggs = eggs;
    }

    public ArrayList<Item> getMilks() {
        return milks;
    }

    public void setMilks(ArrayList<Item> milks) {
        this.milks = milks;
    }

    public ArrayList<Item> getWools() {
        return wools;
    }

    public void setWools(ArrayList<Item> wools) {
        this.wools = wools;
    }

    public ArrayList<Item> getEggPowders() {
        return eggPowders;
    }

    public void setEggPowders(ArrayList<Item> eggPowders) {
        this.eggPowders = eggPowders;
    }

    public ArrayList<Item> getCookies() {
        return cookies;
    }

    public void setCookies(ArrayList<Item> cookies) {
        this.cookies = cookies;
    }

    public ArrayList<Item> getCakes() {
        return cakes;
    }

    public void setCakes(ArrayList<Item> cakes) {
        this.cakes = cakes;
    }
}
