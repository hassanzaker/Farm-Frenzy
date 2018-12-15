package Model.WorkShop;

import Model.Items.Item;

import java.util.ArrayList;

public abstract class WorkShop {
    protected int level;
    protected int timeToWork;
    protected int rowForOutPut;
    protected int columnForOutput;
    protected ArrayList<String> inputs = new ArrayList<>();
    protected ArrayList<String> outputs = new ArrayList<>();
    protected WorkShop(){
        level=1;
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
}
