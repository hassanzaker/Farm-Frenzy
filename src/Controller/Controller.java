package Controller;

import Model.Animals.Animal;
import Model.Animals.Bear;
import Model.Animals.Lion;
import Model.Cage;
import Model.Cell;
import Model.Ground;
import Model.Time;
import Model.WorkShop.WorkShop;
import View.View;

import java.util.ArrayList;
import java.util.Random;

//import com.gilecode.yagson.*;
//

public class Controller {
    private ArrayList<Ground> grounds = new ArrayList<>();
    private int level;
    private ArrayList<Level> levels = new ArrayList<>();
    private Time time = new Time();
    Random random = new Random();
    private boolean flag = false;

    public Controller(ArrayList<Level> levels) {
        for (int i = 0; i < levels.size(); i++) {
            grounds.add(new Ground(levels.get(i)));
        }
        level = 1;

    }


    public void cyclePass() {
        this.time.next();
        if (time.getCurrentTime() % 60 == 10) {
            if (flag) {
                grounds.get(level - 1).addAnimal(new Bear(random.nextInt(600), random.nextInt(600), ""));
                grounds.get(level - 1).addAnimal(new Bear(random.nextInt(600), random.nextInt(600), ""));
                flag = false;
            } else {
                grounds.get(level - 1).addAnimal(new Lion(random.nextInt(600), random.nextInt(600), ""));
                grounds.get(level - 1).addAnimal(new Lion(random.nextInt(600), random.nextInt(600), ""));
                flag = true;
            }
        }
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

    public void startWorking(String type) {
        try {
            grounds.get(level - 1).searchWorkShop(type).workShopInput(grounds.get(level - 1));
        } catch (Exception e) {
            View.checkOutException(e);
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
            grounds.get(level - 1).setMoney(grounds.get(level - 1).getMoney() - workShop.getBaseCost());
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
                s += grounds.get(level - 1).getMissions()[i].getType() + " Done!\n" ;
            } else {
                s += grounds.get(level - 1).getMissions()[i].toString() + "\n" ;
            }
        }
        return s;
    }

    public String printMap() {
        String s = "" ;
        Cell[][] cells = grounds.get(level - 1).getCells();
//        for (int i = 0; i < cells.length; i++) {
//            for (int j = 0; j < cells[i].length; j++) {
//                s += cells[i][j].toString();
//            }
//            s += "\n" ;
//        }
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
                "\n mission 3 : " + levels.get(level - 1).getTypes()[2] + "--> " + String.valueOf(levels.get(level - 1).getNeed()[2]);
        return s;
    }

    public String printWereHouse() {
        return grounds.get(level - 1).getWereHouse().toString();
    }

    public String printWell() {
        return grounds.get(level - 1).getWell().toString();
    }

    public String printTruck() {
        return grounds.get(level - 1).getTruck().toString();
    }

    public String printHeliCopter() {
        return grounds.get(level - 1).getHelicopter().toString();
    }

    public String printWorkShop(WorkShop workShop) {
        try {
            return grounds.get(level - 1).searchWorkShop(workShop).toString();
        } catch (Exception e) {
            View.checkOutException(e);
        }
        return null;
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

    public ArrayList<Ground> getGrounds() {

        return grounds;
    }

    public void setGrounds(ArrayList<Ground> grounds) {
        this.grounds = grounds;
    }

    public int getLevel() {

        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }

    public void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }


//        public void save(String path) {
//            YaGson yaGson = new YaGson();
//            String objToString = yaGson.toJson(grounds.get(level-1));
//
//            //  parseSTRING.ourFarm
//            BufferedWriter writer = null;
//            try {
//                writer = new BufferedWriter(new FileWriter(path));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                writer.write(objToString);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                writer.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//    public Ground load(String path){
//        File f = new File(path);
//        InputStream stream = null;
//        try {
//            stream = new FileInputStream(f);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        StringBuilder json = new StringBuilder();
//        int byteCode = 0;
//        try {
//            byteCode = stream.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        while (byteCode != -1) {
//            json.append((char) byteCode);
//            try {
//                byteCode = stream.read();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            stream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return new YaGson().fromJson(json.toString(), Ground.class);
//    }


}
