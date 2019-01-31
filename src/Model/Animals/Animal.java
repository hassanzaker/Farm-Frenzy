package Model.Animals;

import Model.Cell;
import Model.Ground;
import javafx.scene.Group;

import java.util.Random;


public abstract class Animal {
    protected Group mainRoot;
    protected int row;
    protected int column;
    protected int cost;
    protected String ID;
    protected String name;

    public Animal(int x, int y, String ID , Group mainRoot) {
        Random r = new Random();
        this.row = r.nextInt(y);
        this.column = r.nextInt(x);
        this.ID = ID;
        this.mainRoot = mainRoot;
    }

    public int direction(Ground ground) {
        Random random = new Random();
        return random.nextInt(4) + 1;
    }


    public void checkTime(Ground ground) throws Exception {
        move(direction(ground), ground);
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
                    move((direction%4) + 1, ground);
                }else {
                    this.makeChangesOnCell(ground.getCells()[this.row - 1][this.column - 1], -1);
                    this.column++;
                    this.makeChangesOnCell(ground.getCells()[this.row - 1][this.column - 1], 1);
                }
                break;
            case 2:   // 2 ---->>   up
                if (this.row > ground.getNumberOfRows() || this.column > ground.getNumberOfColumns() || this.row <= 0 || this.column < 0) {
                    move((direction%4) + 1, ground);
                }else {
                    this.makeChangesOnCell(ground.getCells()[this.row - 1][this.getColumn() - 1], -1);
                    this.row--;
                    this.makeChangesOnCell(ground.getCells()[this.row - 1][this.getColumn() - 1], 1);
                }
                break;
            case 3:   // 3  ---->>   left
                if (this.row > ground.getNumberOfRows() || this.column > ground.getNumberOfColumns() || this.row < 0 || this.column <= 0) {
                    move((direction%4) + 1, ground);
                } else {
                    this.makeChangesOnCell(ground.getCells()[this.row - 1][this.getColumn() - 1], -1);
                    this.column--;
                    this.makeChangesOnCell(ground.getCells()[this.row - 1][this.getColumn() - 1], 1);
                }
                break;
            case 4:   //  4  ---->>   down
                if (this.row >= ground.getNumberOfRows() || this.column > ground.getNumberOfColumns() || this.row < 0 || this.column < 0) {
                    move((direction%4) + 1, ground);
                } else {
                    this.makeChangesOnCell(ground.getCells()[this.row - 1][this.getColumn() - 1], -1);
                    this.row++;
                    this.makeChangesOnCell(ground.getCells()[this.row - 1][this.getColumn() - 1], 1);
                }
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}