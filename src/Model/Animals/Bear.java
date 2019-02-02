package Model.Animals;

import Model.Ground;
import View.SpriteAnimation.SpriteAnimation;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Bear extends WildAnimal {

    {
        try {
            up = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\up.png"));
            upView = new ImageView(up);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            left = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\left.png"));
             leftView = new ImageView(left);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            down = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\down.png"));
            downView = new ImageView(down);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            caged = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\caged.png"));
            cagedView = new ImageView(caged);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            upLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\up_left.png"));
             upLeftView = new ImageView(upLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            downLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\down_left.png"));
            downLeftView = new ImageView(downLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    {
        try {
            right = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\right.png"));
            rightView = new ImageView(right);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    {
        try {
            upRight = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\up_right.png"));
            upRightView = new ImageView(upRight);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    {
        try {
            downRight = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\down_right.png"));
            downRightView = new ImageView(downRight);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Bear(int x, int y, String ID , Group mainRoot) {
        super(x, y, ID ,mainRoot);
        this.name = "bear";

    }

    @Override
    public void moveRight(Ground ground) {
     this.show(rightView , 440/4 , 696/6 ,ground , 1 , 6 , 4);
    }


    @Override
    public void moveLeft(Ground ground) {
        this.show(leftView , 440/4 , 696/6 ,ground , 3 , 6 , 4);
    }

    @Override
    public void moveDown(Ground ground) {
        this.show(downView , 480/4 , 648/6 ,ground , 4 , 6 , 4);
    }

    @Override
    public void moveUp(Ground ground) {
        this.show(upView , 448/4 , 720/6 ,ground , 2 , 6 , 4);
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