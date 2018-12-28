package View;

import Controller.Controller;
import Model.Animals.*;
import Model.WorkShop.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Controller.Level;

public class View {

    public static void main(String[] args) {
        ArrayList<Level> levels = new ArrayList<>();
        String[] types = new String[3];
        int[] need = new int[3];
        types[0] = "money" ;
        need[0] = 1000;
        types[1] = "egg" ;
        need[1] = 10;
        types[2] = "hen" ;
        need[2] = 5;
        levels.add(new Level(1, types, need, 2000));
        Controller controller = new Controller(levels);
        Random random = new Random();
        Scanner read = new Scanner(System.in);
        String command = "" ;
        while (!command.equals("end")) {
            command = read.nextLine();
            String[] subStrings = command.split(" ");
            switch (subStrings[0]) {
                case "buy":
                    Animal animal = null;
                    boolean flag = false;
                    switch (subStrings[1]) {
                        case "hen":
                            animal = new Hen(random.nextInt(600) + 1, random.nextInt(600) + 1, "");
                            break;
                        case "sheep":
                            animal = new Sheep(random.nextInt(600) + 1, random.nextInt(600) + 1, "");
                            break;
                        case "cow":
                            animal = new Cow(random.nextInt(600) + 1, random.nextInt(600) + 1, "");
                            break;
                        case "cat":
                            animal = new Cat(random.nextInt(600) + 1, random.nextInt(600) + 1, "");
                            break;
                        case "dog":
                            animal = new Dog(random.nextInt(600) + 1, random.nextInt(600) + 1, "");
                            break;
                        default:
                            System.out.println("not such animal!");
                            flag = true;
                            break;
                    }
                    if (!flag)
                        controller.addAnimal(animal);
                    break;
                case "pick":
                    controller.pickUp(Integer.valueOf(subStrings[1]), Integer.valueOf(subStrings[2]));
                    break;
                case "cage":
                    controller.cage(Integer.valueOf(subStrings[1]), Integer.valueOf(subStrings[2]));
                    break;
                case "plant":
                    controller.plant(Integer.valueOf(subStrings[1]), Integer.valueOf(subStrings[2]));
                    break;
                case "well":
                    controller.fillWell();
                    break;
                case "start":
                    WorkShop workShop = null;
                    flag = false;
                    switch (subStrings[1]) {
                        case "CakeBakery":
                            workShop = new CakeBakery();
                            break;
                        case "CookieBakery":
                            workShop = new CookieBakery();
                            break;
                        case "EggPowderPlant":
                            workShop = new EggPowderPlant();
                            break;
                        case "SewingFactory":
                            workShop = new SewingFactory();
                            break;
                        case "Spinnery":
                            workShop = new Spinnery();
                            break;
                        case "WevingFactory":
                            workShop = new WevingFactory();
                        default:
                            System.out.println("not such work shop!");
                            flag = true;
                            break;
                    }
                    if (!flag)
                        controller.startWorkShop(workShop);
                    break;
                case "upgrade":
                    switch (subStrings[1]) {
                        case "CakeBakery":
                            workShop = new CakeBakery();
                            controller.upgradeWorkShop(workShop);
                            break;
                        case "CookieBakery":
                            workShop = new CookieBakery();
                            controller.upgradeWorkShop(workShop);
                            break;
                        case "EggPowderPlant":
                            workShop = new EggPowderPlant();
                            controller.upgradeWorkShop(workShop);
                            break;
                        case "SewingFactory":
                            workShop = new SewingFactory();
                            controller.upgradeWorkShop(workShop);
                            break;
                        case "Spinnery":
                            workShop = new Spinnery();
                            controller.upgradeWorkShop(workShop);
                            break;
                        case "WevingFactory":
                            workShop = new WevingFactory();
                            controller.upgradeWorkShop(workShop);
                            break;
                        case "cat":
                            controller.upgradeCat();
                            break;
                        case "well":
                            controller.upgradeWell();
                            break;
                        case "truck":
                            controller.upgradeTruck();
                            break;
                        case "helicopter":
                            controller.upgradeHelicopter();
                            break;
                        case "werehouse":
                            controller.upgradeWereHouse();
                            break;
                        default:
                            System.out.println("wrong input!");
                            break;
                    }
                    break;
                case "load":
                    switch (subStrings[1]) {
                        case "custom":
                            ///// to fill
                            break;
                        case "game":
                            ///  to fill
                            break;
                        default:
                            System.out.println("wrong input!");
                            break;
                    }
                    break;
                case "run":
                    /// to fill
                    break;
                case "save":
                    /// to fill
                    break;
                case "print":
                    switch (subStrings[1]) {
                        case "info":
                            System.out.println(controller.printInfo());
                            break;
                        case "map":
                            System.out.println(controller.printMap());
                            break;
                        case "levels":
                            System.out.println(controller.printLevels());
                            break;
                        case "werehouse":
                            System.out.println(controller.printWereHouse());
                            break;
                        case "CakeBakery":
                            workShop = new CakeBakery();
                            System.out.println(controller.printWorkShop(workShop));
                            break;
                        case "CookieBakery":
                            workShop = new CookieBakery();
                            System.out.println(controller.printWorkShop(workShop));
                            break;
                        case "EggPowderPlant":
                            workShop = new EggPowderPlant();
                            System.out.println(controller.printWorkShop(workShop));
                            break;
                        case "SewingFactory":
                            workShop = new SewingFactory();
                            System.out.println(controller.printWorkShop(workShop));
                            break;
                        case "Spinnery":
                            workShop = new Spinnery();
                            System.out.println(controller.printWorkShop(workShop));
                            break;
                        case "WevingFactory":
                            workShop = new WevingFactory();
                            System.out.println(controller.printWorkShop(workShop));
                            break;
                        case "well":
                            System.out.println(controller.printWell());
                            break;
                        case "truck":
                            System.out.println(controller.printTruck());
                            break;
                        case "helicopter":
                            System.out.println(controller.printHeliCopter());
                            break;
                        default:
                            System.out.println("wrong input!");
                            break;

                    }
                    break;
                case "turn":
                    for (int i = 0; i < Integer.valueOf(subStrings[1]); i++) {
                        controller.cyclePass();
                    }
                    break;
                case "truck":
                    switch (subStrings[1]) {
                        case "add":
                            controller.addItemToTruck(subStrings[2], Integer.valueOf(subStrings[3]));
                            break;
                        case "clear":
                            controller.clearTruck();
                            break;
                        case "go":
                            controller.truckGo();
                            break;
                        default:
                            System.out.println("wrong input!");
                            break;
                    }
                    break;
                case "helicopter":
                    switch (subStrings[1]) {
                        case "add":
                            controller.addItemToHelicopter(subStrings[2], Integer.valueOf(subStrings[3]));
                            break;
                        case "clear":
                            controller.clearHelicopter();
                            break;
                        case "go":
                            controller.helicopterGo();
                            break;
                        default:
                            System.out.println("wrong input!");
                            break;
                    }
//                case "x":
//                    controller.getGrounds().get(0).work();
//                    break;
                default:
                    System.out.println("wrong input!");
                    break;
            }
        }
    }

    public static void checkOutException(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
