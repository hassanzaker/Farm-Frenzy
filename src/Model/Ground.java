package Model;

import Model.Animals.Cat;
import Model.Animals.Dog;
import Model.Animals.ProducerAnimal;
import Model.Animals.WildAnimal;
import Model.Items.Item;
import Model.Transportation.Helicopter;
import Model.Transportation.Truck;
import Model.WorkShop.WorkShop;

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

    public Ground() {
        this.cells = new Cell[600][600];
        this.workShops = new WorkShop[6];
        this.well = new Well();
        this.truck = new Truck();
        this.helicopter = new Helicopter();
        this.wereHouse = new WereHouse();
    }


    public ArrayList<WildAnimal> getWildAnimals() {
        return wildAnimals;
    }

    public void setWildAnimals(ArrayList<WildAnimal> wildAnimals) {
        this.wildAnimals = wildAnimals;
    }

    public void addItem(Item item){

    }

    public void addProducerAnimal(ProducerAnimal producerAnimal){

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

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
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


}
