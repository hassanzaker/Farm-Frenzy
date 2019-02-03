package Model.Animals;

import Model.Ground;
import Model.Items.Egg;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Hen extends ProducerAnimal {

    {
        try {
            up = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\up.png"));
            upView = new ImageView(up);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            left = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\left.png"));
            leftView = new ImageView(left);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    {
        try {
            down = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\down.png"));
            downView = new ImageView(down);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            death = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\death.png"));
            deathView = new ImageView(death);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            upLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\up_left.png"));
            upLeftView = new ImageView(upLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            downLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\down_left.png"));
            downLeftView = new ImageView(downLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    {
        try {
            eat = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\eat.png"));
            eatView = new ImageView(eat);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Hen(int x, int y , String ID , Group mainRoot) {
        super(x, y, ID , mainRoot);
        this.name = "hen";
        this.cost = 100;
    }

    @Override
    public void moveRight(Ground ground) {
        rightView = leftView;
        rightView.setScaleX(-1);
        this.show(rightView , 400/4 , 792/6 ,ground , 1 , 6 , 4);
    }

    @Override
    public void moveLeft(Ground ground) {
        this.show(leftView , 400/4 , 792/6 ,ground , 3 , 6 , 4);
    }

    @Override
    public void moveDown(Ground ground) {
        this.show(downView , 516/6 , 504/4 ,ground , 4 , 4 , 6);
    }

    @Override
    public void moveUp(Ground ground) {
        this.show(rightView , 344/4 , 852/6 ,ground , 2 , 6 , 4);
    }

    @Override
    public void caged(Ground ground) {

    }

    @Override
    public void eat(Ground ground) {

    }

    @Override
    public void produce(Ground ground) {
        ground.getCells()[this.row-1][this.column-1].setItemAmount(ground.getCells()[this.row-1][this.column-1].getItemAmount()+1);
        ground.addItem(new Egg(this.row, this.column, "0",true , ground.getMainRoot()));
    }



}