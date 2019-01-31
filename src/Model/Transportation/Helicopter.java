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
import java.util.Random;

public class Helicopter {
    Group mainRoot;
    private Image Helicopter1;
    ImageView helicopterView1;
    {
        try {
            Helicopter1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Helicopter\\01.png"));
             helicopterView1 = new ImageView(Helicopter1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image Helicopter2;
    ImageView helicopterView2;
    {
        try {
            Helicopter2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Helicopter\\02.png"));
             helicopterView2 = new ImageView(Helicopter2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image Helicopter3;
    ImageView helicopterView3;
    {
        try {
            Helicopter3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Helicopter\\03.png"));
             helicopterView3 = new ImageView(Helicopter3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image Helicopter4;
    ImageView helicopterView4;
    {
        try {
            Helicopter4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Service\\Helicopter\\04.png"));
             helicopterView4 = new ImageView(Helicopter4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int level;
    private int maxLevel;
    private int timeToTransit;
    private int currentTime;
    private boolean isInWorking;
    private ArrayList<Box> boxes = new ArrayList<>();
    Ground ground;

    public Helicopter(Ground ground , Group mainRoot) {
        boxes.add(new Box());
        boxes.add(new Box());
        level = 1;
        maxLevel = 4;
        isInWorking = false;
        this.ground = ground;
        this.timeToTransit = 10;
        this.mainRoot=mainRoot;
        this.show();
    }
    public void show(){
        if(this.level ==1) {
            helicopterView1.setX(600);
            helicopterView1.setY(470);
            this.mainRoot.getChildren().add(helicopterView1);
            helicopterView1.setOnMouseClicked(event -> {
                //           mainRoot.getChildren(scene);//TODO : bayad benvisam secne ra barayash
            });
        }else if(this.level == 2){
            helicopterView2.setX(600);
            helicopterView2.setY(470);
            this.mainRoot.getChildren().add(helicopterView2);
            helicopterView2.setOnMouseClicked(event -> {
                //           mainRoot.getChildren(scene);//TODO : bayad benvisam secne ra barayash
            });
        }else if(this.level == 3){
            helicopterView3.setX(600);
            helicopterView3.setY(470);
            this.mainRoot.getChildren().add(helicopterView3);
            helicopterView3.setOnMouseClicked(event -> {
                //           mainRoot.getChildren(scene);//TODO : bayad benvisam secne ra barayash
            });
        }else if(this.level == 4){
            helicopterView4.setX(600);
            helicopterView4.setY(470);
            this.mainRoot.getChildren().add(helicopterView4);
            helicopterView4.setOnMouseClicked(event -> {
                //           mainRoot.getChildren(scene);//TODO : bayad benvisam secne ra barayash
            });
        }

    }
    public void remove(){
        this.mainRoot.getChildren().remove(helicopterView1);
        this.mainRoot.getChildren().remove(helicopterView2);
        this.mainRoot.getChildren().remove(helicopterView3);
        this.mainRoot.getChildren().remove(helicopterView4);
    }
    public int getRandomRow(Ground ground) {
        Random random = new Random();
        return random.nextInt(ground.getNumberOfRows());
    }

    public int getRandomColumn(Ground ground) {
        Random random = new Random();
        return random.nextInt(ground.getNumberOfColumns());
    }

    public void clearHelicopter() {
        for (int i = 0; i < boxes.size(); i++) {
            boxes.get(i).clearBox();
        }
    }
    public void addItemByCount(String type , int count) throws Exception {
        ArrayList<Box> tempBox = boxes;
        Boolean completed= true;
        try{
            for(int i=0 ; i < count ; i++) {
                addItem(type);
            }
        }catch (Exception e){
            completed=false;
            throw e;
        }finally {
            if(completed == false){
                boxes=tempBox;
            }
        }
    }

    public void addItem(String type) throws Exception {
        Boolean checkItemCanAddToBox = false;
        Item item = null;
        if (type.equals("Egg")) {
            item = new Egg(getRandomRow(ground), getRandomColumn(ground), "0", true , mainRoot);
        } else if (type.equals("EggPowder")) {
            item = new EggPowder(getRandomRow(ground), getRandomColumn(ground), "0", true , mainRoot);
        } else if (type.equals("Cake")) {
            item = new Cake(getRandomRow(ground), getRandomColumn(ground), "0", true , mainRoot);
        } else if (type.equals("Cookie")) {
            item = new Cookie(getRandomRow(ground), getRandomColumn(ground), "0", true , mainRoot);
        } else if (type.equals("Milk")) {
            item = new Milk(getRandomRow(ground), getRandomColumn(ground), "0", true ,mainRoot);
        } else if (type.equals("FLour")) {
            item = new Flour(getRandomRow(ground), getRandomColumn(ground), "0", true, mainRoot);
        } else if (type.equals("Wool")) {
            item = new Wool(getRandomRow(ground), getRandomColumn(ground), "0", true , mainRoot);
        } else if (type.equals("Sewing")) {
            item = new Sewing(getRandomRow(ground), getRandomColumn(ground), "0", true , mainRoot);
        } else if (type.equals("Fabric")) {
            item = new Fabric(getRandomRow(ground), getRandomColumn(ground), "0", true , mainRoot);
        } else if (type.equals("ColoredPlume")) {
            item = new ColoredPlume(getRandomRow(ground), getRandomColumn(ground), "0", true , mainRoot);
        } else if (type.equals("CarnivalDress")) {
            item = new CarnivalDress(getRandomRow(ground), getRandomColumn(ground), "0", true , mainRoot);
        }
        for (int j = 0; j < boxes.size(); j++) {
            if (boxes.get(j).checkFull() == false) {
                if (boxes.get(j).typeOfBox().equals(type) || boxes.get(j).typeOfBox().equals("none")) {
                    checkItemCanAddToBox = true;
                    boxes.get(j).addItem(item);
                    break;
                }
            }
        }
        if (checkItemCanAddToBox == false) {
            throw new Exception(" item can not add to box");
        }
    }

    public void putItemOnGround(Ground ground) {
        for (int i = 0; i < boxes.size(); i++) {
            for (int j = 0; j < boxes.get(i).getItems().size(); j++) {
                ground.addItem(boxes.get(i).getItems().get(j));
            }

        }
    }

    public void buy(Ground ground) throws Exception {
        if (ground.getMoney() < computeBuyCost()) {
            throw new Exception("not enough money!");
        } else {
            isInWorking = true;
            ground.setMoney(ground.getMoney() - computeBuyCost());
        }
       /* putItemOnGround(ground);
        for (int i = 0; i < boxes.size(); i++) {
            boxes.get(i).clearBox();
        }*/

    }

    public int computeBuyCost() {
        int sum = 0;
        for (Box boxes1 : this.boxes) {
            sum += boxes1.getBuyPrice();
        }
        return sum;
    }

    public void checkTime(Ground ground) {
        if (isInWorking) {
            this.currentTime++;
            if (this.currentTime == this.timeToTransit) {
                this.currentTime = 0;
                this.isInWorking = false;
                putItemOnGround(ground);
                clearHelicopter();
            }
        }
    }


    public void upgrade(int money) throws Exception {
        if (level == maxLevel) {
            throw new Exception("max level exceeded");
        }
        if (money < computeUpgradeCost()){
            throw new Exception("not enough money!");
        }
        level++;
        boxes.add(new Box());
        boxes.add(new Box());
        this.remove();
        this.show();
    }

    @Override
    public String toString() {
        String string = "";
        for(int i=0 ; i < boxes.size() ; i++ ){
            string += "Item in Box " + String.valueOf(i+1) + " ";
            if(boxes.get(i).getItems().size() == 0){
                string += "none";
            }else{
                string += String.valueOf(boxes.get(i).getItems().size()) + boxes.get(i).typeOfBox();
            }
            string += "\n";
        }
        string += "buy cost : " + String.valueOf(computeBuyCost()) + "\n";
        string += "time need for buy : " + String.valueOf(timeToTransit)+ "\n";
        return string;
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

    public void setBoxes(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

}
