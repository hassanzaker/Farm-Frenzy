package Model.Animals;

import Model.Cell;
import Model.Ground;
import Model.Items.Egg;
import Model.Items.Milk;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Cow extends ProducerAnimal {

    {
        try {
            up = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\up.png"));
            upView = new ImageView(up);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            left = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\left.png"));
            leftView = new ImageView(left);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            down = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\down.png"));
            downView = new ImageView(down);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            death = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\death.png"));
            deathView = new ImageView(death);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            upLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\up_left.png"));
            upLeftView = new ImageView(upLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            downLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\down_left.png"));
            downLeftView = new ImageView(downLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            eat = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\eat.png"));
            eatView = new ImageView(eat);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    {
        try {
            right = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\right.png"));
            rightView = new ImageView(right);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Cow(int x, int y , String ID , Group mainRoot) {
        super(x, y, ID , mainRoot);
        this.name = "cow";
        this.cost = 1000;
    }

    @Override
    public void moveRight(Ground ground) {
        this.show(rightView , 480/3 , 880/8 ,ground , 1 , 8 , 3);
    }

    @Override
    public void moveLeft(Ground ground) {
        this.show(leftView , 480/3 , 880/8 ,ground , 3 , 8 , 3);
    }

    @Override
    public void moveDown(Ground ground) {
        this.show(downView , 354/3 , 880/8 ,ground , 4 , 8 , 3);
    }

    @Override
    public void moveUp(Ground ground) {
        this.show(rightView , 456/4 , 792/6 ,ground , 2, 6 , 4);
    }

    @Override
    public void caged(Ground ground) {

    }

    @Override
    public void eat(Ground ground) {

    }


    @Override
    public void produce(Ground ground) {
        ground.getCells()[this.row][this.column].setItemAmount(ground.getCells()[this.row][this.column].getItemAmount()+1);
        ground.addItem(new Milk(this.row, this.column, "0",true , mainRoot));
    }




}