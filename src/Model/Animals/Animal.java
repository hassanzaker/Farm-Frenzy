package Model.Animals;

import Model.Cell;
import Model.Ground;

import java.util.Random;

import static Model.Direction.none;

public abstract class Animal {
    protected int row;
    protected int column;
    protected int cost;
    protected String ID;

    public Animal(int x, int y, String ID) {
        Random r = new Random();
        this.row = r.nextInt(y);
        this.column = r.nextInt(x);
        this.ID = ID;
    }

    public int direction() {
        return 0;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public void move(int  direction, Ground ground) throws Exception {
        switch (direction) {
            case 1:   // 1 ---->>  right
                if (this.row > ground.getNumberOfRows() || this.column >= ground.getNumberOfColumns() || this.row < 0 || this.column < 0) {
                    throw new Exception("out of map");
                }
                this.makeChangesOnCell(ground.getCells()[this.row - 1][this.column - 1], -1);
                this.column++;
                this.makeChangesOnCell(ground.getCells()[this.row - 1][this.column - 1], 1);
                break;
            case 2:   // 2 ---->>   up
                if (this.row > ground.getNumberOfRows() || this.column > ground.getNumberOfColumns() || this.row <= 0 || this.column < 0) {
                    throw new Exception("out of map");
                }
                this.makeChangesOnCell(ground.getCells()[this.row - 1][this.getColumn() - 1], -1);
                this.row--;
                this.makeChangesOnCell(ground.getCells()[this.row - 1][this.getColumn() - 1], 1);
                break;
            case 3:   // 3  ---->>   left
                if (this.row > ground.getNumberOfRows() || this.column > ground.getNumberOfColumns() || this.row < 0 || this.column <= 0) {
                    throw new Exception("out of map");
                }
                this.makeChangesOnCell(ground.getCells()[this.row - 1][this.getColumn() - 1], -1);
                this.column--;
                this.makeChangesOnCell(ground.getCells()[this.row - 1][this.getColumn() - 1], 1);
                break;
            case 4:   //  4  ---->>   down
                if (this.row >= ground.getNumberOfRows() || this.column > ground.getNumberOfColumns() || this.row < 0 || this.column < 0) {
                    throw new Exception("out of map");
                }
                this.makeChangesOnCell(ground.getCells()[this.row - 1][this.getColumn() - 1], -1);
                this.row++;
                this.makeChangesOnCell(ground.getCells()[this.row - 1][this.getColumn() - 1], 1);
                break;
        }
    }

    public abstract void makeChangesOnCell(Cell cell, int a);


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
