package Model;

import Controller.Level;
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
    private ArrayList<ProducerAnimal> producerAnimals = new ArrayList<>();
    private ArrayList<Dog> dogs = new ArrayList<>();
    private ArrayList<Cat> cats = new ArrayList<>();
    private ArrayList<WildAnimal> wildAnimals = new ArrayList<>();
    private Well well;
    private Truck truck;
    private Helicopter helicopter;
    private WereHouse wereHouse;
    private int numberOfRows;
    private int numberOfColumns;
    private int money;
    private int numberOfWorkShops;
    private Mission[] missions = new Mission[3];


    public Ground(Level level) {
        this.cells = new Cell[600][600];
        for (int i = 0; i < 600; i++) {
            for (int j = 0; j < 600; j++) {
                cells[i][j] = new Cell();
            }
        }
        this.workShops = new WorkShop[6];
        this.well = new Well();
        this.truck = new Truck();
        this.numberOfColumns = 600;
        this.numberOfRows = 600;
        this.helicopter = new Helicopter(this);
        this.wereHouse = new WereHouse();
        this.numberOfWorkShops = 0;
        for (int i = 0; i < 3; i++) {
            missions[i] = new Mission(level.getTypes()[i], level.getNeed()[i]);
        }
        this.money = level.getFirstMoney();

    }

    public void buyAnimal(Animal animal) throws Exception {
        if (this.money < animal.getCost()) {
            throw new Exception("not enough money!");
        }
        if (animal instanceof ProducerAnimal) {
            this.producerAnimals.add((ProducerAnimal) animal);
        } else if (animal instanceof Dog) {
            this.dogs.add((Dog) animal);
        } else if (animal instanceof Cat) {
            this.cats.add((Cat) animal);
        }
        this.money -= animal.getCost();
    }

    public void pickUp(int x, int y) throws Exception {
        if (cells[x - 1][y - 1].getItemAmount() == 0) {
            throw new Exception("there is no item!");
        } else {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).getRow() == x && items.get(i).getColumn() == y) {
                    wereHouse.addItem(items.get(i));
                    items.remove(i);
                }
            }
        }
    }


    public void addWorkShop(WorkShop workShop) throws Exception {
        if (this.numberOfWorkShops == 6) {
            throw new Exception("no place for new workshop!");
        }
        if (this.money < workShop.getBaseCost()) {
            throw new Exception("not enough money");
        }
        this.workShops[numberOfWorkShops] = workShop;
        numberOfWorkShops++;
    }

    public WorkShop searchWorkShop(WorkShop workShop) throws Exception {
        for (int i = 0; i < this.workShops.length; i++) {
            if (this.workShops[i] != null) {
                if (this.workShops[i].equals(workShop)) {
                    return this.workShops[i];
                }
            }
        }
        throw new Exception("no such workshop!");

    }

    public void work() {
        for (int i = 0; i < 6; i++) {
            if (workShops[i] == null)
                System.out.println("null");
            else
                System.out.println(workShops[i].getName());
        }
    }

    public void checkTime() throws Exception {
        for (int i = 0; i < missions.length; i++) {
            if (!missions[i].isDone()) {
                if (missions[i].getType().equals("money")) {
                    missions[i].setAmount(this.money);
                    missions[i].check();
                }
                for (int j = 0; j < producerAnimals.size(); j++) {
                    if (missions[i].getType().equals(producerAnimals.get(j).getName())) {
                        missions[i].addItem();
                        missions[i].check();
                    }
                }
                for (int j = 0; j < wereHouse.getItems().size(); j++) {
                    if (missions[i].getType().equals(wereHouse.getItems().get(j).getType())) {
                        missions[i].addItem();
                        missions[i].check();
                    }
                }

            }
        }
        this.well.cehckTime();
        for (int i = 0; i < workShops.length; i++) {
            if (this.workShops[i] != null)
                workShops[i].checkTime(this);
        }
        this.helicopter.checkTime(this);
        this.truck.checkTime(this);
        for (int i = 0; i < this.cats.size(); i++) {
            this.cats.get(i).checkTime(this);
        }
        for (int i = 0; i < this.cats.size(); i++) {
            this.cats.get(i).checkTime(this);
        }
        for (int i = 0; i < this.dogs.size(); i++) {
            this.dogs.get(i).checkTime(this);
        }
        for (int i = 0; i < this.producerAnimals.size(); i++) {
            this.producerAnimals.get(i).checkTime(this);
        }
        for (int i = 0; i < this.wildAnimals.size(); i++) {
            this.wildAnimals.get(i).checkTime(this);
        }
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


    public ArrayList<WildAnimal> getWildAnimals() {
        return wildAnimals;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addAnimal(Animal animal) {
        if (animal instanceof ProducerAnimal) {
            producerAnimals.add((ProducerAnimal) animal);
        } else if (animal instanceof WildAnimal) {
            wildAnimals.add((WildAnimal) animal);
        } else if (animal instanceof Cat) {
            cats.add((Cat) animal);
        } else if (animal instanceof Dog) {
            dogs.add((Dog) animal);
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

    public ArrayList<ProducerAnimal> getProducerAnimals() {
        return producerAnimals;
    }

    public void setProducerAnimals(ArrayList<ProducerAnimal> producerAnimals) {
        this.producerAnimals = producerAnimals;
    }

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(ArrayList<Dog> dogs) {
        this.dogs = dogs;
    }

    public ArrayList<Cat> getCats() {
        return cats;
    }

    public void setCats(ArrayList<Cat> cats) {
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

    public void setWildAnimals(ArrayList<WildAnimal> wildAnimals) {
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

    public int getNumberOfWorkShops() {
        return numberOfWorkShops;
    }

    public void setNumberOfWorkShops(int numberOfWorkShops) {
        this.numberOfWorkShops = numberOfWorkShops;
    }

    public Mission[] getMissions() {
        return missions;
    }

    public void setMissions(Mission[] missions) {
        this.missions = missions;
    }
}