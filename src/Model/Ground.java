package Model;

import Model.Animals.Cat;
import Model.Animals.Dog;
import Model.Animals.ProducerAnimal;
import Model.Animals.*;
import Model.Items.Item;
import Model.Transportation.Helicopter;
import Model.Transportation.Truck;
import Model.WorkShop.WorkShop;
import Model.Items.*;

import java.util.ArrayList;

public class Ground {
    private Cell[][] cells;
    private WorkShop[] workShops;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Animal> producerAnimals = new ArrayList<>();
    private ArrayList<Animal> dogs = new ArrayList<>();
    private ArrayList<Animal> cats = new ArrayList<>();
    private ArrayList<Animal> wildAnimals = new ArrayList<>();
    private Well well;
    private Truck truck;
    private Helicopter helicopter;
    private WereHouse wereHouse;
    private int numberOfRows;
    private int numberOfColumns;
    private int money;

    public Ground() {
        this.cells = new Cell[600][600];
        this.workShops = new WorkShop[6];
        this.well = new Well();
        this.truck = new Truck();
        this.helicopter = new Helicopter();
        this.wereHouse = new WereHouse();
    }


    public Well getWell() {
        return well;
    }

    public void setWell(Well well) {
        this.well = well;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public Helicopter getHelicopter() {
        return helicopter;
    }

    public void setHelicopter(Helicopter helicopter) {
        this.helicopter = helicopter;
    }

    public WereHouse getWereHouse() {
        return wereHouse;
    }

    public void setWereHouse(WereHouse wereHouse) {
        this.wereHouse = wereHouse;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }


    public ArrayList<Animal> getWildAnimals() {
        return wildAnimals;
    }

    public void addItem(Item item) {
       items.add(item);
    }

    public void addAnimal(Animal animal) {
        if (animal instanceof ProducerAnimal) {
            producerAnimals.add(animal);
        } else if (animal instanceof WildAnimal) {
            wildAnimals.add(animal);
        } else if (animal instanceof Cat) {
            cats.add(animal);
        } else if (animal instanceof Dog) {
            dogs.add(animal);
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public WorkShop[] getWorkShops() {
        return workShops;
    }

    public void setWorkShops(WorkShop[] workShops) {
        this.workShops = workShops;
    }

    public ArrayList<Animal> getProducerAnimals() {
        return producerAnimals;
    }

    public void setProducerAnimals(ArrayList<Animal> producerAnimals) {
        this.producerAnimals = producerAnimals;
    }

    public ArrayList<Animal> getDogs() {
        return dogs;
    }

    public void setDogs(ArrayList<Animal> dogs) {
        this.dogs = dogs;
    }

    public ArrayList<Animal> getCats() {
        return cats;
    }

    public void setCats(ArrayList<Animal> cats) {
        this.cats = cats;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setWildAnimals(ArrayList<Animal> wildAnimals) {
        this.wildAnimals = wildAnimals;
    }

    public void deleteAnimal(Animal animal) {
        if (animal instanceof ProducerAnimal) {
            producerAnimals.remove(animal);
        } else if (animal instanceof WildAnimal) {
            wildAnimals.remove(animal);
        } else if (animal instanceof Cat) {
            cats.remove(animal);
        } else if (animal instanceof Dog) {
            dogs.remove(animal);
        }
    }

    public void deleteItem(Item item) {
     items.remove(item);
    }
}