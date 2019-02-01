package Model.Animals;

import Model.Cell;
import Model.Ground;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Dog extends Animal {
    private int level;
    private int speed;

    {
        try {
            up = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Dog\\up.png"));
            upView = new ImageView(up);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            left = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Dog\\left.png"));
            leftView = new ImageView(left);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            down = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Dog\\down.png"));
            downView = new ImageView(down);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            upLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Dog\\up_left.png"));
            upLeftView = new ImageView(upLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            downLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Dog\\down_left.png"));
            downLeftView = new ImageView(downLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Dog(int x, int y, String ID , Group mainRoot) {
        super(x, y, ID , mainRoot);
        this.level = 1;
        this.speed = 10;
        this.name = "dog";
        this.cost = 3000;
    }

    @Override
    public void checkTime(Ground ground) throws Exception {
        super.checkTime(ground);
    }

    @Override
    public void moveRight(Ground ground) {

    }

    @Override
    public void moveLeft(Ground ground) {

    }

    @Override
    public void moveDown(Ground ground) {

    }

    @Override
    public void moveUp(Ground ground) {

    }

    public int direction(Ground ground) {
        if (ground.getWildAnimals().size() == 0) {
            Random random = new Random();
            return random.nextInt(4) + 1;
        } else {
            WildAnimal wildAnimal = ground.getWildAnimals().get(0);
            int wildAnimalX = wildAnimal.getRow();
            int wildAnimalY = wildAnimal.getColumn();
            int x = wildAnimalX - this.row;
            int y = wildAnimalY - this.column;
            if (x > 0) {
                return 4;  //down
            }
            else if (x < 0){
                return 2;  // up
            }
            else {
                if (y>0){
                    return 1; // right
                }
                else{
                    return 3;  // left
                }
            }
        }
    }


    public void crash(Ground ground) throws Exception {
        for (int i=0 ; i<ground.getItems().size() ; i++){
            if (ground.getItems().get(i).getRow() == this.row && ground.getItems().get(i).getColumn() == this.column){
                ground.deleteItem(ground.getItems().get(i));
                ground.getWereHouse().addItem(ground.getItems().get(i));
                break;
            }
        }
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


    public int getLevel() {
        return level;
    }




    public void makeChangesOnCell(Cell cell, int a) {
        cell.setNumberOfDogs(cell.getNumberOfDogs() + a);
    }

}