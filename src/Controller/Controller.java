package Controller;

import Model.Animals.Animal;
import Model.Animals.Cat;
import Model.Cage;
import Model.Cell;
import Model.Ground;
import Model.Time;
import Model.WorkShop.WorkShop;
import View.View;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Ground> grounds = new ArrayList<>();
    private int level;
    private ArrayList<Level> levels = new ArrayList<>();
    private Time time = new Time();

    public void cyclePass() {
        this.time.next(grounds.get(level - 1));
        try {
            grounds.get(level - 1).checkTime();
        } catch (Exception e) {
            View.checkOutException(e);
        }
    }

    public void addAnimal(Animal animal) {
        try {
            grounds.get(this.level - 1).buyAnimal(animal);
        } catch (Exception exception) {
            View.checkOutException(exception);
        }

    }

    public void fillWell() {
        try {
            grounds.get(level - 1).getWell().fill(grounds.get(level - 1).getMoney());
            grounds.get(level - 1).setMoney(grounds.get(level - 1).getMoney() - grounds.get(level - 1).getWell().getCost());
        } catch (Exception e) {
            View.checkOutException(e);
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
        try {
            grounds.get(level - 1).getWell().plant(grounds.get(level - 1), x, y);   // has a problem for around
        } catch (Exception e) {
            View.checkOutException(e);
        }
    }

    public void startWorkShop(WorkShop workShop) {
        try {
            grounds.get(level - 1).addWorkShop(workShop);
        } catch (Exception exception) {
            View.checkOutException(exception);
        }
    }

    public void upgradeWorkShop(WorkShop workShop) {
        try {
            grounds.get(level - 1).searchWorkShop(workShop).upgrade(grounds.get(level - 1).getMoney());
            grounds.get(level - 1).setMoney(grounds.get(level - 1).getMoney() - grounds.get(level - 1).searchWorkShop(workShop).computeUpgradeCost());
        } catch (Exception exception) {
            View.checkOutException(exception);
        }
    }

    public void upgradeCat() {
        try {
            if (grounds.get(level - 1).getCats().size() > 0) {
                for (int i = 0; i < grounds.get(level - 1).getCats().size(); i++) {
                    grounds.get(level - 1).getCats().get(i).upgrade(grounds.get(level - 1).getMoney());
                }
                grounds.get(level - 1).setMoney(grounds.get(level - 1).getMoney() - grounds.get(level - 1).getCats().get(0).computeUpgradeCost());
            }

        } catch (Exception e) {
            View.checkOutException(e);
        }
    }

    public void upgradeWereHouse() {
        try {
            grounds.get(level - 1).getWereHouse().upgrade(grounds.get(level - 100).getMoney());
            grounds.get(level - 1).setMoney(grounds.get(level - 1).getMoney() - grounds.get(level - 1).getWereHouse().computeUpgradeCost());
        } catch (Exception e) {
            View.checkOutException(e);
        }
    }

    public void upgradeWell() {
        try {
            grounds.get(level - 1).getWell().upgrade(grounds.get(level - 1).getMoney());
            grounds.get(level - 1).setMoney(grounds.get(level - 1).getMoney() - grounds.get(level - 1).getWell().computeUpgradeCost());
        } catch (Exception e) {
            View.checkOutException(e);
        }
    }

    public void upgradeTruck() {
        try {
            grounds.get(level - 1).getTruck().upgrade(grounds.get(level - 1).getMoney());
            grounds.get(level - 1).setMoney(grounds.get(level - 1).getMoney() - grounds.get(level - 1).getTruck().computeUpgradeCost());
        } catch (Exception e) {
            View.checkOutException(e);
        }
    }

    public void upgradeHelicopter() {
        try {
            grounds.get(level - 1).getHelicopter().upgrade(grounds.get(level - 1).getMoney());
            grounds.get(level - 1).setMoney(grounds.get(level - 1).getMoney() - grounds.get(level - 1).getHelicopter().computeUpgradeCost());
        } catch (Exception e) {
            View.checkOutException(e);
        }
    }

    public String printInfo() {
        String s = "money : " + String.valueOf(grounds.get(level - 1).getMoney()) + "\n" +
                "Time : " + time.toString() + "\n" ;
        for (int i = 0; i < 3; i++) {
            if (grounds.get(level - 1).getMissions()[i].isDone()) {
                s += grounds.get(level - 1).getMissions()[i].getType() + "Done!\n" ;
            } else {
                s += grounds.get(level - 1).getMissions()[i].toString() + "\n" ;
            }
        }
        return s;
    }

    public String printMap() {
        String s = "" ;
        Cell[][] cells = grounds.get(level - 1).getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                s += cells[i][j].toString();
            }
            s += "\n" ;
        }
        for (int i = 0; i < grounds.get(level - 1).getItems().size(); i++) {
            s += grounds.get(level - 1).getItems().get(i).getType() + " x = " +
                    grounds.get(level - 1).getItems().get(i).getRow() + " , y = " +
                    grounds.get(level - 1).getItems().get(i).getColumn() + "\n" ;
        }
        for (int i = 0; i < grounds.get(level - 1).getProducerAnimals().size(); i++) {
            s += grounds.get(level - 1).getProducerAnimals().get(i).getName() + " x = " +
                    grounds.get(level - 1).getProducerAnimals().get(i).getRow() + " , y = " +
                    grounds.get(level - 1).getProducerAnimals().get(i).getColumn() + "\n" ;
        }
        for (int i = 0; i < grounds.get(level - 1).getCats().size(); i++) {
            s += grounds.get(level - 1).getCats().get(i).getName() + " x = " +
                    grounds.get(level - 1).getCats().get(i).getRow() + " , y = " +
                    grounds.get(level - 1).getCats().get(i).getColumn() + "\n" ;
        }
        for (int i = 0; i < grounds.get(level - 1).getDogs().size(); i++) {
            s += grounds.get(level - 1).getDogs().get(i).getName() + " x = " +
                    grounds.get(level - 1).getDogs().get(i).getRow() + " , y = " +
                    grounds.get(level - 1).getDogs().get(i).getColumn() + "\n" ;
        }
        for (int i = 0; i < grounds.get(level - 1).getWildAnimals().size(); i++) {
            s += grounds.get(level - 1).getWildAnimals().get(i).getName() + " x = " +
                    grounds.get(level - 1).getWildAnimals().get(i).getRow() + " , y = " +
                    grounds.get(level - 1).getWildAnimals().get(i).getColumn() + "\n" ;
        }
        return s;
    }

    public String printLevels() {
        String s = "" ;
        s += "Level : " + level +
                "\n mission 1 : " + levels.get(level - 1).getTypes()[0] + "--> " + String.valueOf(levels.get(level - 1).getNeed()[0]) +
                "\n mission 2 : " + levels.get(level - 1).getTypes()[1] + "--> " + String.valueOf(levels.get(level - 1).getNeed()[1]) +
                "\n mission 3 : " + levels.get(level-1).getTypes()[2] + "--> " + String.valueOf(levels.get(level-1).getNeed()[2]);
        return s;
    }


    public void addItemToHelicopter(String type, int count) {
        try {
            grounds.get(level - 1).getHelicopter().addItemByCount(type, count);
        } catch (Exception e) {
            View.checkOutException(e);
        }
    }

    public void addItemToTruck(String type, int count) {
        try {
            grounds.get(level - 1).getTruck().addItemByCount(type, count, grounds.get(level - 1));
        } catch (Exception e) {
            View.checkOutException(e);
        }
    }

    public void clearTruck() {
        grounds.get(level - 1).getTruck().clearTruck();
    }

    public void clearHelicopter() {
        grounds.get(level - 1).getHelicopter().clearHelicopter();
    }

    public void helicopterGo() {
        try {
            grounds.get(level - 1).getHelicopter().buy(grounds.get(level - 1));
        } catch (Exception e) {
            View.checkOutException(e);
        }
    }

    public void truckGo() {
        try {
            grounds.get(level - 1).getTruck().sell();
        } catch (Exception e) {
            View.checkOutException(e);
        }
    }

    public void save() {

    }
}
