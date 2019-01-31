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
    private Image cowUp;
    ImageView cowUpView;
    {
        try {
            cowUp = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\up.png"));
            cowUpView = new ImageView(cowUp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image cowLeft;
    ImageView cowLeftView;
    {
        try {
            cowLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\left.png"));
            cowLeftView = new ImageView(cowLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image cowDown;
    ImageView cowDownView;
    {
        try {
            cowDown = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\down.png"));
            cowDownView = new ImageView(cowDown);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image cowDeath;
    ImageView cowDeathView;
    {
        try {
            cowDeath = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\death.png"));
            cowDeathView = new ImageView(cowDeath);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image cowUpLeft;
    ImageView cowUpLeftView;
    {
        try {
            cowUpLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\up_left.png"));
            cowUpLeftView = new ImageView(cowUpLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image cowDownLeft;
    ImageView cowDownLefView;
    {
        try {
            cowDownLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\down_left.png"));
            cowDownLefView = new ImageView(cowDownLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image cowEat;
    ImageView cowEatView;
    {
        try {
            cowEat = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Cow\\eat.png"));
            cowEatView = new ImageView(cowEat);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Cow(int x, int y , String ID , Group mainRoot) {
        super(x, y, ID , mainRoot);
        this.name = "cow";
        this.cost = 10000;
    }


    @Override
    public void produce(Ground ground) {
        ground.getCells()[this.row-1][this.column-1].setItemAmount(ground.getCells()[this.row-1][this.column-1].getItemAmount()+1);
        ground.addItem(new Milk(this.row, this.column, "0",true , mainRoot));
    }




}