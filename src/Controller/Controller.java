package Controller;

import Model.Animals.Animal;
import Model.Animals.Cat;
import Model.Cage;
import Model.Ground;
import Model.Time;
import Model.WorkShop.WorkShop;
import View.View;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Ground> grounds = new ArrayList<>();
    private int level;
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

    public void save() {

    }
}
