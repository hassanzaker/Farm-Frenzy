package Model.Animals;

import Model.Ground;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Lion extends WildAnimal {


    {
        try {
            up = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\up.png"));
            upView = new ImageView(up);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    {
        try {
            left = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\left.png"));
             leftView = new ImageView(left);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            down = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\down.png"));
             downView = new ImageView(down);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            caged = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\caged.png"));
             cagedView = new ImageView(caged);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            upLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\up_left.png"));
            upLeftView = new ImageView(upLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            downLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\down_left.png"));
             downLeftView = new ImageView(downLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Lion(int x, int y, String ID , Group mainRoot) {
        super(x, y, ID , mainRoot);
        this.name = "lion";
    }

    @Override
    public void moveRight(Ground ground) {
        rightView = leftView;
        rightView.setScaleX(-1);
        this.show(rightView , 414/3 , 736/8 ,ground , 1 , 8 , 3);
    }

    @Override
    public void moveLeft(Ground ground) {
        this.show(leftView , 414/3 , 736/8 ,ground , 3 , 8 , 3);
    }

    @Override
    public void moveDown(Ground ground) {
        this.show(downView , 480/5 , 460/5 ,ground , 4 , 5 , 5);
    }

    @Override
    public void moveUp(Ground ground) {
        this.show(upView , 564/6 , 464/4 ,ground , 2 , 4 , 6);
    }

    @Override
    public void caged(Ground ground) {

    }

    @Override
    public void eat(Ground ground) {

    }

    @Override
    public void eat() {

    }

}
