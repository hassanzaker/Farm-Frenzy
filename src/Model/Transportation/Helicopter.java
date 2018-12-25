package Model.Transportation;

import Model.Box;
import Model.Ground;
import Model.Items.*;

import java.util.ArrayList;
import java.util.Random;

public class Helicopter {


    private int level;
    private int maxLevel;
    private int timeToTransit;
    private int currentTime;
    private boolean isInWorking;
    private ArrayList<Box> boxes = new ArrayList<>();
    Ground ground;

    public Helicopter(Ground ground) {
        boxes.add(new Box());
        boxes.add(new Box());
        level = 1;
        maxLevel = 4;
        isInWorking = false;
        this.ground=ground;
    }
    public int getRandomRow(Ground ground){
        Random random = new Random();
        return random.nextInt(ground.getNumberOfRows());
    }
    public int  getRandomColumn(Ground ground){
        Random random = new Random();
        return random.nextInt(ground.getNumberOfColumns());
    }

    public void clearTruck() {
        for (int i = 0; i < boxes.size(); i++) {
            boxes.get(i).clearBox();
        }
    }

    public void addItem(String type) throws Exception {
        Boolean checkItemCanAddToBox = false;
        Item item = null;
        if (type.equals("Egg")) {
            item=new Egg( getRandomRow(ground), getRandomColumn(ground), "0", true);
        } else if (type.equals("EggPowder")) {
            item =new EggPowder(getRandomRow(ground), getRandomColumn(ground), "0", true);
        } else if (type.equals("Cake")) {
            item=new Cake(getRandomRow(ground), getRandomColumn(ground), "0", true);
        } else if (type.equals("Cookie")) {
            item=new Cookie(getRandomRow(ground), getRandomColumn(ground), "0", true);
        } else if (type.equals("Milk")) {
            item=new Milk(getRandomRow(ground), getRandomColumn(ground), "0", true);
        } else if (type.equals("FLour")) {
            item=new Flour(getRandomRow(ground), getRandomColumn(ground), "0", true);
        } else if (type.equals("Wool")) {
            item = new Wool(getRandomRow(ground), getRandomColumn(ground), "0", true);
        } else if (type.equals("Sewing")) {
            item = new Sewing(getRandomRow(ground), getRandomColumn(ground), "0", true);
        } else if (type.equals("Fabric")) {
            item = new Fabric(getRandomRow(ground), getRandomColumn(ground), "0", true);
        } else if (type.equals("ColoredPlume")) {
            item = new ColoredPlume(getRandomRow(ground), getRandomColumn(ground), "0", true);
        } else if (type.equals("CarnivalDress")) {
            item = new CarnivalDress(getRandomRow(ground), getRandomColumn(ground), "0", true);
        }
        for(int j=0 ; j < boxes.size() ; j++){
            if(boxes.get(j).checkFull() == false ){
                if (boxes.get(j).typeOfBox().equals(type) || boxes.get(j).typeOfBox().equals("none")){
                    checkItemCanAddToBox=true;
                    boxes.get(j).addItem(item);
                    break;
                }
            }
        }
        if(checkItemCanAddToBox == false){
            throw new Exception(" item can not add to box");
        }
    }
    public void putItemOnGround(Ground ground){
        for (int i =0 ; i< boxes.size() ; i++) {
            for (int j =0 ; j< boxes.get(i).getItems().size() ; j++) {
                ground.addItem(boxes.get(i).getItems().get(j));
            }

        }
    }

    public void buy(Ground ground) throws Exception{
        if(ground.getMoney() < computeBuyCost()){
            throw new Exception("not enough money!");
        }
        else {
            isInWorking = true;
            ground.setMoney(ground.getMoney() - computeBuyCost());
        }
        putItemOnGround(ground);
        for (int i = 0; i < boxes.size(); i++) {
            boxes.get(i).clearBox();
        }

    }

    public int computeBuyCost(){
        int sum=0;
        for (Box boxes1: this.boxes) {
            sum += boxes1.getBuyPrice();
        }
        return sum;
    }

    public void checkTime(Ground ground){
        if (isInWorking){
            this.currentTime++;
            if (this.currentTime == this.timeToTransit){
                this.currentTime =0 ;
                this.isInWorking = false;
                clearTruck(); ////   ??????????????????????????????????????????????????
            }
        }
    }


    public void upgrade() throws Exception {
        if (level == maxLevel) {
            throw new Exception("max level exceeded");
        } else {
            level++;
            boxes.add(new Box());
            boxes.add(new Box());
        }
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
