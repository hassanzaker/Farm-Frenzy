package Model.Animals;

import Model.Cell;
import Model.Ground;
import Model.Items.Item;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Cat extends Animal {
    private int level;
    private int speed;

    {
        try {
            up = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Cat\\up.png"));
            upView = new ImageView(up);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            left = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Cat\\left.png"));
            leftView = new ImageView(left);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            down = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Cat\\down.png"));
            downView = new ImageView(down);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            upLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Cat\\up_left.png"));
            upLeftView = new ImageView(upLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            downLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Cat\\down_left.png"));
            downLeftView = new ImageView(downLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Cat(int x, int y, String ID , Group mainRoot) {
        super(x, y, ID ,mainRoot);
        this.level = 1;
        this.speed = 10;
        this.name = "cat" ;
        this.cost = 2000;
    }

    @Override
    public void checkTime(Ground ground) throws Exception {
        super.checkTime(ground);
        crash(ground);
    }

    @Override
    public void moveRight(Ground ground) {
        rightView=leftView;
        rightView.setScaleX(-1);
       show(rightView, 352/4 , 408/6 , ground , 1, 6 , 4);
    }

    @Override
    public void moveLeft(Ground ground) {
        show(leftView, 352/4 , 408/6 , ground , 3, 6 , 4);
    }

    @Override
    public void moveDown(Ground ground) {
        show(downView, 300/6 , 368/4 , ground , 4, 4 , 6);
    }

    @Override
    public void moveUp(Ground ground) {
        show(upView, 288/6 , 336/4 , ground , 2, 4 , 6);
    }

    @Override
    public void caged(Ground ground) {

    }

    @Override
    public void eat(Ground ground) {

    }

    public void crash(Ground ground) throws Exception {
        for (int i = 0; i < ground.getItems().size(); i++) {
            if (this.row == ground.getItems().get(i).getRow() && this.column == ground.getItems().get(i).getColumn()) {
                ground.getWereHouse().addItem(ground.getItems().get(i));
                ground.deleteItem(ground.getItems().get(i));
            }
        }

    }

    public int direction(Ground ground) {
        Random random = new Random();
        if (ground.getItems().size() == 0) {
            return random.nextInt(4) + 1;
        } else {
            int x = 0;
            int y = 0;
            if (this.level == 1) {
                Item item = ground.getItems().get(0);
                x = item.getRow() - this.row;
                y = item.getColumn() - this.column;
            } else if (this.level == 2) {
                int[] distances = new int[ground.getItems().size()];
                int[] xs = new int[ground.getItems().size()];
                int[] ys = new int[ground.getItems().size()];
                for (int i = 0; i < ground.getItems().size(); i++) {
                    Item item = ground.getItems().get(i);
                    x = item.getRow() - this.row;
                    y = item.getColumn() - this.column;
                    xs[i] = x;
                    ys[i] = y;
                    distances[i] = x * x + y * y;
                }
                int min = distances[0];
                int lastIndexOfMin = 0;
                for (int i = 0; i < distances.length; i++) {
                    if (distances[i] < min) {
                        min = distances[i];
                        lastIndexOfMin = i;
                    }
                }
                x = xs[lastIndexOfMin];
                y = ys[lastIndexOfMin];
            }
            if (x > 0) {
                return 4;  //down
            } else if (x < 0) {
                return 2;  // up
            } else {
                if (y > 0) {
                    return 1; // right
                } else {
                    return 3;  // left
                }
            }

        }
    }

    public void upgrade(int money) throws Exception {
        if (money < computeUpgradeCost()) {
            throw new Exception("not enough money!");
        }
        if (this.level == 2) {
            throw new Exception("cat is max level!");
        }
        this.level++;
        this.speed += 5;
    }

    public int computeUpgradeCost() {
        return 2000;
    }

    public int getLevel() {

        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void makeChangesOnCell(Cell cell, int a) {
        cell.setNumberOfCats(cell.getNumberOfCats() + a);
    }

}