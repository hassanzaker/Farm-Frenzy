package Controller;

import Model.Animals.Animal;
import Model.Animals.Cat;
import Model.Cage;
import Model.Ground;
import Model.WorkShop.WorkShop;
import View.View;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Ground> grounds = new ArrayList<>();
    private int level;

    public void cyclePass() {

    }

    public void addAnimal(Animal animal) {
        try {
            grounds.get(this.level - 1).buyAnimal(animal);
        } catch (Exception exception) {
            View.checkOutException(exception);
        }

    }

    public void pickUp(int x, int y) {
        try {
            grounds.get(level - 1).pickUp(x, y);
        } catch (Exception exception) {
            View.checkOutException(exception);
        }
    }

    public void cage(int x, int y) {
        try {
            Cage.action(grounds.get(level - 1), x, y);
        } catch (Exception exception) {
            View.checkOutException(exception);
        }
    }

    public void plant(int x, int y) {
        grounds.get(level - 1).getWell().plant(grounds.get(level - 1), x, y);
    }

    public void startWorkShop(WorkShop workShop) {
        try {
            grounds.get(level - 1).addWorkShop(workShop);
        } catch (Exception exception) {
            View.checkOutException(exception);
        }
    }

    public void upgrade(WorkShop workShop){
        try {
            grounds.get(level-1).searchWorkShop(workShop).upgrade(grounds.get(level-1).getMoney());
        }catch (Exception exception){
            View.checkOutException(exception);
        }
    }

    public void upgrade(Cat cat){
                                                /// upgrade is not completed
    }


    public void save() {

    }
}
