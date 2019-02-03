package Model.Animals;

import Model.Animals.ProducerAnimal;
import Model.Cell;
import Model.Ground;
import Model.Items.Egg;
import Model.Items.Wool;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Sheep extends ProducerAnimal {

    {
        try {
            up = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\up.png"));
             upView = new ImageView(up);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            left = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\left.png"));
             leftView = new ImageView(left);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    {
        try {
            down = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\down.png"));
            downView = new ImageView(down);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

   ;
    {
        try {
            death = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\death.png"));
            deathView = new ImageView(death);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            upLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\up_left.png"));
            upLeftView = new ImageView(upLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            downLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\down_left.png"));
            downLeftView = new ImageView(downLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            eat = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\eat.png"));
            eatView = new ImageView(eat);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Sheep(int x, int y, String ID , Group mainRoot) {
        super(x, y, ID , mainRoot);
        this.name = "sheep" ;
        this.cost = 1000;
    }

    @Override
    public void moveRight(Ground ground) {
        rightView = leftView;
        rightView.setScaleX(-1);
        this.show(rightView , 520/4 , 468/6 ,ground , 1 ,6  , 4);
    }

    @Override
    public void moveLeft(Ground ground) {
        this.show(rightView , 520/4 , 468/6 ,ground , 3 ,6  , 4);
    }

    @Override
    public void moveDown(Ground ground) {
        this.show(downView , 420/5 , 510/5 ,ground , 4 ,5  , 5);
    }

    @Override
    public void moveUp(Ground ground) {
        this.show(upView , 410/5 , 480/5 ,ground , 2 ,5  , 5);
    }

    @Override
    public void caged(Ground ground) {

    }

    @Override
    public void eat(Ground ground) {
        this.show(eatView , 440/4 , 468/6 ,ground , 5 ,6  , 4);
    }


    @Override
    public void produce(Ground ground) {
        ground.getCells()[this.row - 1][this.column - 1].setItemAmount(ground.getCells()[this.row - 1][this.column - 1].getItemAmount() + 1);
        ground.addItem(new Wool(this.row, this.column, "0", true , ground.getMainRoot()));
    }


}