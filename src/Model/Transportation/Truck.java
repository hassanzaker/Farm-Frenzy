package Model.Transportation;

import Model.Box;
import Model.Ground;
import Model.Items.*;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Truck {
    private Group mainRoot;
    private int level;
    private int maxLevel;
    private int timeToTransit;
    private int currentTime;
    private boolean isInWorking;
    private ArrayList<Box> boxes = new ArrayList<>();
    private Image Truck1;
    ImageView truckView1;
    {
        try {
            Truck1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Truck\\01.png"));
            truckView1 = new ImageView(Truck1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Truck2;
    ImageView truckView2;
    {
        try {
            Truck2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Truck\\02.png"));
            truckView2 = new ImageView(Truck2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Truck3;
    ImageView truckView3;
    {
        try {
            Truck3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Truck\\03.png"));
             truckView3 = new ImageView(Truck3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Truck4;
    ImageView truckView4;
    {
        try {
            Truck4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Truck\\04.png"));
             truckView4 = new ImageView(Truck4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Truck(Group mainRoot) {
        boxes.add(new Box());
        boxes.add(new Box());
        level = 1;
        maxLevel = 4;
        isInWorking = false;
        this.timeToTransit = 10;
        this.mainRoot = mainRoot;
        this.show();
    }

    public void clearTruck() {
        for (int i = 0; i < boxes.size(); i++) {
            boxes.get(i).clearBox();
        }
    }

    public void addItemByCount(String type, int count, Ground ground) throws Exception {
        ArrayList<Box> tempBox = boxes;
        Boolean completed = true;
        try {
            for (int i = 0; i < count; i++) {
                addItem(type, ground);
            }
        } catch (Exception e) {
            completed = false;
            throw e;
        } finally {
            if (completed == false) {
                boxes = tempBox;
            }
        }
    }

    public void addItem(String type, Ground ground) throws Exception {
        Boolean checkItemInWereHouse = false;
        Boolean checkItemCanAddToBox = false;
        for (int i = 0; i < ground.getWereHouse().getItems().size(); i++) {
            if (ground.getWereHouse().getItems().get(i).getType().equals(type)) {
                checkItemInWereHouse = true;
                for (int j = 0; j < boxes.size(); j++) {
                    if (boxes.get(j).checkFull() == false) {
                        if (boxes.get(j).typeOfBox().equals(type) || boxes.get(j).typeOfBox().equals("none")) {
                            checkItemCanAddToBox = true;
                            boxes.get(j).addItem(ground.getWereHouse().getItems().get(i));
                            ground.getWereHouse().deleteItem(ground.getWereHouse().getItems().get(i));
                            break;
                        }
                    }
                }
                break;
            }
        }
        if (checkItemInWereHouse == false) {
            throw new Exception("item not found in the werehouse");
        }
        if (checkItemCanAddToBox == false) {
            throw new Exception(" item can not add to box");
        }
    }

    public void sell() {
        isInWorking = true;

    }

    public int computeSellPrice() {
        int sum = 0;
        for (Box boxes1 :
                this.boxes) {
            sum += boxes1.getSellPrice();
        }
        return sum;
    }
    public void show(){
        if(this.level ==1) {
            truckView1.setX(160);
            truckView1.setY(600);
            this.mainRoot.getChildren().add(truckView1);
            truckView1.setOnMouseClicked(event -> {
                //           mainRoot.getChildren(scene);//TODO : bayad benvisam secne ra barayash
            });
        }else if(this.level == 2){
            truckView2.setX(160);
            truckView2.setY(600);
            this.mainRoot.getChildren().add(truckView2);
            truckView2.setOnMouseClicked(event -> {
                //           mainRoot.getChildren(scene);//TODO : bayad benvisam secne ra barayash
            });
        }else if(this.level == 3){
            truckView3.setX(160);
            truckView3.setY(600);
            this.mainRoot.getChildren().add(truckView3);
            truckView3.setOnMouseClicked(event -> {
                //           mainRoot.getChildren(scene);//TODO : bayad benvisam secne ra barayash
            });
        }else if(this.level == 4){
            truckView4.setX(160);
            truckView4.setY(600);
            this.mainRoot.getChildren().add(truckView4);
            truckView4.setOnMouseClicked(event -> {
                //           mainRoot.getChildren(scene);//TODO : bayad benvisam secne ra barayash
            });
        }

    }
    public void remove(){
        this.mainRoot.getChildren().remove(truckView1);
        this.mainRoot.getChildren().remove(truckView2);
        this.mainRoot.getChildren().remove(truckView3);
        this.mainRoot.getChildren().remove(truckView4);
    }
    public void checkTime(Ground ground) {
        if (isInWorking) {
            this.currentTime++;
            if (this.currentTime == this.timeToTransit) {
                ground.setMoney(ground.getMoney() + computeSellPrice());
                this.currentTime = 0;
                this.isInWorking = false;
            }
        }
    }

    public String toString() {
        String string = "";
        for (int i = 0; i < boxes.size(); i++) {
            string += "Item in Box " + String.valueOf(i + 1) + " ";
            if (boxes.get(i).getItems().size() == 0) {
                string += "none";
            } else {
                string += String.valueOf(boxes.get(i).getItems().size()) + boxes.get(i).typeOfBox();
            }
            string += "\n";
        }
        string += "sell cost : " + String.valueOf(computeSellPrice()) + "\n";
        string += "time need for sell " + String.valueOf(timeToTransit) + "\n";
        return string;
    }

    public void upgrade(int money) throws Exception {
        if (level == maxLevel) {
            throw new Exception("max level exceeded");
        }
        if (money < computeUpgradeCost()) {
            throw new Exception("not enough money!");
        }
        level++;
        this.timeToTransit--;
        boxes.add(new Box());
        boxes.add(new Box());
        this.remove();
        this.show();

    }

    public int computeUpgradeCost() {
        return this.level * this.level * 100;
    }


    public int getTimeToTransit() {
        return timeToTransit;
    }

    public void setTimeToTransit(int timeToTransit) {
        this.timeToTransit = timeToTransit;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public boolean isInWorking() {
        return isInWorking;
    }

    public void setInWorking(boolean inWorking) {
        isInWorking = inWorking;
    }

    public ArrayList<Box> getBoxes() {
        return boxes;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public void setBoxes(ArrayList<Box> boxes) {

        this.boxes = boxes;
    }

}
