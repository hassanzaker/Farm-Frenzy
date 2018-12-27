package Model.WorkShop;

import Model.Items.*;
import Model.WereHouse;
import Model.Ground;

import java.util.ArrayList;

public abstract class WorkShop {
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

    protected WorkShop(int maxLevel, int constNumber) {
        this.maxLevel = maxLevel;
        level = 1;
        this.constNumber = constNumber;
        this.timeToWork = 8;
        this.maxLevel = 5;
        this.isWorking = false;
        this.baseCost = 50 * this.constNumber;
    }

    public void upgrade(int money) throws Exception {
        if (level == maxLevel) {
            throw new Exception("max level exceeded");
        }
        if (computeUpgradeCost() > money){
            throw new Exception("not enough money!");
        } else {
            level++;
            this.timeToWork -= 1;
            this.isWorking = false;
            this.currentTime = 0;
        }

    }

    public int computeUpgradeCost() {
        return this.level * this.level * 100 * this.constNumber;
    }

    public void checkTime(Ground ground) {
        if (this.isWorking) {
            this.currentTime++;
            if (this.currentTime == this.timeToWork) {
                workShopOutput(ground);
                this.currentTime = 0;
            }
        }
    }

    public void workShopInput(Ground ground) throws Exception {
        int minNumber = 0;
        int[] numberOfThisInput = new int[ground.getWereHouse().getItems().size()];
        for (int i = 0; i < numberOfThisInput.length; i++) {
            numberOfThisInput[i] = 0;
        }
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < ground.getWereHouse().getItems().size(); j++) {
                if (inputs.get(i).equals(ground.getWereHouse().getItems().get(j))) {
                    numberOfThisInput[i]++;
                }
            }
        }
        for (int i = 0; i < numberOfThisInput.length; i++) {
            if (numberOfThisInput[i] == 0) {
                throw new Exception("not enough items");
            }
            if (numberOfThisInput[i] < minNumber) {
                minNumber = numberOfThisInput[i];
            }
        }
        minNumber = Math.min(level, minNumber);
        if (minNumber != 0) {
            for (int i = 0; i < minNumber; i++) {
                for (int j = 0; j < inputs.size(); j++) {
                    for (int k = 0; k < ground.getWereHouse().getItems().size(); k++) {
                        if (ground.getWereHouse().getItems().get(k).equals(inputs.get(j)))
                            ground.getWereHouse().deleteItem(ground.getWereHouse().getItems().get(k));
                    }
                }
            }
        }
        this.isWorking = true;
    }

    public void workShopOutput(Ground ground) {
        int minNumber = 0;
        int[] numberOfThisInput = new int[ground.getWereHouse().getItems().size()];
        for (int i = 0; i < numberOfThisInput.length; i++) {
            numberOfThisInput[i] = 0;
        }
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < ground.getWereHouse().getItems().size(); j++) {
                if (inputs.get(i).equals(ground.getWereHouse().getItems().get(j))) {
                    numberOfThisInput[i]++;
                }
            }
        }
        for (int i = 0; i < numberOfThisInput.length; i++) {
            if (numberOfThisInput[i] == 0) {

                break;
            }
            if (numberOfThisInput[i] < minNumber) {
                minNumber = numberOfThisInput[i];
            }
        }
        minNumber = Math.min(level, minNumber);
        if (minNumber != 0) {
            for (int i = 0; i < minNumber; i++) {
                for (int j = 0; j < outputs.size(); j++) {
                    if (outputs.equals("Egg")) {
                        ground.addItem(new Egg(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    } else if (outputs.equals("EggPowder")) {
                        ground.addItem(new EggPowder(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    } else if (outputs.equals("Cake")) {
                        ground.addItem(new Cake(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    } else if (outputs.equals("Cookie")) {
                        ground.addItem(new Cookie(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    } else if (outputs.equals("Milk")) {
                        ground.addItem(new Milk(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    } else if (outputs.equals("FLour")) {
                        ground.addItem(new Flour(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    } else if (outputs.equals("Wool")) {
                        ground.addItem(new Wool(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    } else if (outputs.equals("Sewing")) {
                        ground.addItem(new Sewing(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    } else if (outputs.equals("Fabric")) {
                        ground.addItem(new Fabric(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    } else if (outputs.equals("ColoredPlume")) {
                        ground.addItem(new ColoredPlume(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    } else if (outputs.equals("CarnivalDress")) {
                        ground.addItem(new CarnivalDress(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    }
                }
            }
        }
        this.isWorking = false;
    }

    @Override
    public String toString() {
        String string= "";
        string += "level of work shop"+String.valueOf(level) + "\n";
        string += "workshop making price" + String.valueOf(baseCost) + "\n";
        string += "workshop upgrade price" + String.valueOf(computeUpgradeCost()) + "\n";
        string += "work shop inputs:";
        for(int i=0 ; i < inputs.size() ; i++ ){
            string += inputs.get(i) + " ";
        }
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
}
