package Model.WorkShop;

import Model.Ground;
import Model.Items.*;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public abstract class WorkShop {
    protected Group mainRoot;
    protected int level;
    protected int baseCost;
    protected int timeToWork;
    protected int workedTime;
    protected int rowForOutPut;
    protected int columnForOutput;
    protected int maxLevel;
    protected int currentTime;
    protected int constNumber;
    protected boolean isWorking;
    protected ArrayList<String> inputs = new ArrayList<>();
    protected ArrayList<String> outputs = new ArrayList<>();
    protected Button button;
    protected String name;
    protected  Ground ground;
    protected WorkShop(int constNumber , Group mainRoot , Ground ground) {
        this.mainRoot=mainRoot;
        this.maxLevel = 5;
        level = 1;
        this.constNumber = constNumber;
        this.timeToWork = 8;
        this.maxLevel = 5;
        this.isWorking = false;
        this.baseCost = 50 * this.constNumber;
        this.columnForOutput=10;
        this.rowForOutPut=10;
        this.ground=ground;
      //  this.show();
    }

    public abstract void show();

    public abstract void remove();

    public abstract void setWorkShop(ImageView imageView , int width , int height , double x , double y);

    public void upgrade(int money) throws Exception {
        if(isWorking == true){
            throw new Exception("on working cant upgrade");
        }
        if (level == maxLevel) {
            throw new Exception("max level exceeded");
        }
        if (computeUpgradeCost() > money){
            throw new Exception("not enough money!");
        } else {
            this.level++;
            this.timeToWork -= 1;
            this.isWorking = false;
            this.currentTime = 0;
        }
        this.remove();
        this.show();
    }

    public int computeUpgradeCost() {
        return this.level * this.level * 100 * this.constNumber;
    }

    public void checkTime(Ground ground) {
        if (this.isWorking) {
            this.currentTime++;
            if (this.currentTime == this.timeToWork) {
                workShopOutput();
                this.currentTime = 0;
            }
        }
    }

    public void workShopInput() throws Exception {
        int minNumber = 0;
        int[] numberOfThisInput = new int[inputs.size()];
        for (int i = 0; i < numberOfThisInput.length; i++) {
            numberOfThisInput[i] = 0;
        }
//        System.out.println(inputs.size());
  //      System.out.println(ground.getWereHouse().getItems().size());
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < this.ground.getWereHouse().getItems().size(); j++) {
//                System.out.println("come");
                if (inputs.get(i).equals(this.ground.getWereHouse().getItems().get(j).getType())) {
                    numberOfThisInput[i]++;
                }
            }
        }
        minNumber = numberOfThisInput[0];
        for (int i = 0; i < numberOfThisInput.length; i++) {
            if (numberOfThisInput[i] == 0) {
                throw new Exception("not enough items");
            }
            if (numberOfThisInput[i] < minNumber) {
                minNumber = numberOfThisInput[i];
            }
        }
        minNumber = Math.min(level, minNumber);
   //     System.out.println(minNumber);
        if (minNumber != 0) {
            a:
            for (int i = 0; i < minNumber; i++) {
                b:
                for (int j = 0; j < inputs.size(); j++) {
                    c:
                    for (int k = 0; k < this.ground.getWereHouse().getItems().size(); k++) {
                        if (this.ground.getWereHouse().getItems().get(k).getType().equals(inputs.get(j))) {
                            this.ground.getWereHouse().deleteItem(this.ground.getWereHouse().getItems().get(k));
                            continue b;
                         //   System.out.println("now");
                        }
                    }
                }
            }
        }
        this.isWorking = true;
    }

    public void workShopOutput() {
        int minNumber = 0;
        int[] numberOfThisInput = new int[inputs.size()];
        for (int i = 0; i < numberOfThisInput.length; i++) {
            numberOfThisInput[i] = 0;
        }
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < this.ground.getWereHouse().getItems().size(); j++) {
               // System.out.println("a");
                if (inputs.get(i).equals(this.ground.getWereHouse().getItems().get(j).getType())) {
                    numberOfThisInput[i]++;
                }
            }
        }
    //    for (int i = 0; i < numberOfThisInput.length ; i++) {
    //        System.out.println(numberOfThisInput[i]);
  //      }
        minNumber=numberOfThisInput[0];
        for (int i = 0; i < numberOfThisInput.length; i++) {
            if (numberOfThisInput[i] == 0) {
                break;
            }
            if (numberOfThisInput[i] < minNumber) {
                minNumber = numberOfThisInput[i];
            }
        }
        //System.out.println(outputs.get(0));
        minNumber = Math.min(level, minNumber);
        System.out.println(minNumber);
        if (minNumber != 0) {
            for (int i = 0; i < minNumber; i++) {
             //   System.out.println("come");
                for (int j = 0; j < outputs.size(); j++) {
                    if (outputs.get(j).equals("Egg")) {
                        this.ground.addItem(new Egg(this.rowForOutPut + i, this.columnForOutput, "0", true , mainRoot));
                    } else if (outputs.get(j).equals("EggPowder")) {
                        this.ground.addItem(new EggPowder(this.rowForOutPut + i, this.columnForOutput, "0", true , mainRoot));
                    } else if (outputs.get(j).equals("Cake")) {
                        this.ground.addItem(new Cake(this.rowForOutPut + i, this.columnForOutput, "0", true , mainRoot));
                    } else if (outputs.get(j).equals("Cookie")) {
                        this.ground.addItem(new Cookie(this.rowForOutPut + i, this.columnForOutput, "0", true , mainRoot));
                    } else if (outputs.get(j).equals("Milk")) {
                        this.ground.addItem(new Milk(this.rowForOutPut + i, this.columnForOutput, "0", true , mainRoot));
                    } else if (outputs.get(j).equals("FLour")) {
                        this.ground.addItem(new Flour(this.rowForOutPut + i, this.columnForOutput, "0", true , mainRoot));
                    } else if (outputs.get(j).equals("Wool")) {
                        this.ground.addItem(new Wool(this.rowForOutPut + i, this.columnForOutput, "0", true , mainRoot));
                    } else if (outputs.get(j).equals("Sewing")) {
                        this.ground.addItem(new Sewing(this.rowForOutPut + i, this.columnForOutput, "0", true, mainRoot));
                    } else if (outputs.get(j).equals("Fabric")) {
                        this.ground.addItem(new Fabric(this.rowForOutPut + i, this.columnForOutput, "0", true , mainRoot));
                    } else if (outputs.get(j).equals("ColoredPlume")) {
                        this.ground.addItem(new ColoredPlume(this.rowForOutPut + i, this.columnForOutput, "0", true , mainRoot));
                    } else if (outputs.get(j).equals("CarnivalDress")) {
                        this.ground.addItem(new CarnivalDress(this.rowForOutPut + i, this.columnForOutput, "0", true , mainRoot));
                    }
                }
            }
        }
        this.isWorking = false;
    }

    public boolean equals(WorkShop obj) {
        return this.name.equals(obj.getName());
    }

    @Override
    public String toString() {
        String string= this.name + " :\n";
        string += "level : "+String.valueOf(level) + "\n";
        string += "workshop making price : " + String.valueOf(baseCost) + "\n";
        string += "workshop upgrade price : " + String.valueOf(computeUpgradeCost()) + "\n";
        string += "work shop inputs : ";
        for(int i=0 ; i < inputs.size() ; i++ ){
            string += inputs.get(i) + " ";
        }
        string += "work shop output : ";
        for(int i=0 ; i< outputs.size() ; i++){
            string += outputs.get(i) + " ";
        }
        return string;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTimeToWork() {
        return timeToWork;
    }

    public void setTimeToWork(int timeToWork) {
        this.timeToWork = timeToWork;
    }

    public int getRowForOutPut() {
        return rowForOutPut;
    }

    public void setRowForOutPut(int rowForOutPut) {
        this.rowForOutPut = rowForOutPut;
    }

    public int getColumnForOutput() {
        return columnForOutput;
    }

    public void setColumnForOutput(int columnForOutput) {
        this.columnForOutput = columnForOutput;
    }

    public int getWorkedTime() {
        return workedTime;
    }

    public void setWorkedTime(int workedTime) {
        this.workedTime = workedTime;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public ArrayList<String> getInputs() {
        return inputs;
    }

    public void setInputs(ArrayList<String> inputs) {
        this.inputs = inputs;
    }

    public ArrayList<String> getOutputs() {
        return outputs;
    }

    public void setOutputs(ArrayList<String> outputs) {
        this.outputs = outputs;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    public int getConstNumber() {
        return constNumber;
    }

    public void setConstNumber(int constNumber) {
        this.constNumber = constNumber;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public int getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(int baseCost) {
        this.baseCost = baseCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getMainRoot() {
        return mainRoot;
    }

    public void setMainRoot(Group mainRoot) {
        this.mainRoot = mainRoot;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

}
