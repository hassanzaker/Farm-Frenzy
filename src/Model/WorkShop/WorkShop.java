package Model.WorkShop;

import Model.Items.*;
import Model.WereHouse;
import Model.Ground;

import java.util.ArrayList;

public abstract class WorkShop {
    protected int level;
    protected int timeToWork;
    protected int workedTime;
    protected int rowForOutPut;
    protected int columnForOutput;
    protected int maxLevel;
    protected ArrayList<String> inputs = new ArrayList<>();
    protected ArrayList<String> outputs = new ArrayList<>();

    protected WorkShop(int maxLevel) {
        this.maxLevel=maxLevel;
        level = 1;
    }
    public void upgrade() throws Exception{
     if(level == maxLevel){
         throw new Exception("max level exceeded");
     }
     level++;
    }
    public void workShopInput(Ground ground) throws Exception {
        int minumber = 0;
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
            if (numberOfThisInput[i] < minumber) {
                minumber = numberOfThisInput[i];
            }
        }
        minumber = Math.min(level, minumber);
        if (minumber != 0) {
            for (int i = 0; i < minumber; i++) {
                for (int j = 0; j < inputs.size(); j++) {
                    for (int k = 0; k < ground.getWereHouse().getItems().size(); k++) {
                        if (ground.getWereHouse().getItems().get(k).equals(inputs.get(j)))
                            ground.getWereHouse().deleteItem(ground.getWereHouse().getItems().get(k));
                    }
                }
            }
        }
    }

    public void workShopOutput(Ground ground) {
        int minumber = 0;
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
            if (numberOfThisInput[i] < minumber) {
                minumber = numberOfThisInput[i];
            }
        }
        minumber = Math.min(level, minumber);
        if (minumber != 0) {
            for (int i = 0; i < minumber; i++) {
                for (int j = 0; j < outputs.size(); j++) {
                    if (outputs.equals("Egg")) {
                        ground.addItem(new Egg(this.rowForOutPut + i, this.columnForOutput, "0",true));
                    } else if (outputs.equals("EggPowder")) {
                        ground.addItem(new EggPowder(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    } else if (outputs.equals("Cake")) {
                        ground.addItem(new Cake(this.rowForOutPut + i, this.columnForOutput, "0",true));
                    } else if (outputs.equals("Cookie")) {
                        ground.addItem(new Cookie(this.rowForOutPut + i, this.columnForOutput, "0",true));
                    } else if (outputs.equals("Milk")) {
                        ground.addItem(new Milk(this.rowForOutPut + i, this.columnForOutput, "0",true));
                    } else if (outputs.equals("FLour")) {
                        ground.addItem(new Flour(this.rowForOutPut + i, this.columnForOutput, "0",true));
                    } else if (outputs.equals("Wool")) {
                        ground.addItem(new Wool(this.rowForOutPut + i, this.columnForOutput, "0",true));
                    } else if (outputs.equals("Sewing")) {
                        ground.addItem(new Sewing(this.rowForOutPut + i, this.columnForOutput, "0",true));
                    } else if (outputs.equals("Fabric")) {
                        ground.addItem(new Fabric(this.rowForOutPut + i, this.columnForOutput, "0",true));
                    } else if (outputs.equals("ColoredPlume")) {
                        ground.addItem(new ColoredPlume(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    } else if (outputs.equals("CarnivalDress")) {
                        ground.addItem(new CarnivalDress(this.rowForOutPut + i, this.columnForOutput, "0", true));
                    }
                }
            }
        }
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
}
