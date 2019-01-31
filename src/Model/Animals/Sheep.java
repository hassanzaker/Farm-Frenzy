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
    private Image SheepUp;
    ImageView sheepUpView;
    {
        try {
            SheepUp = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\up.png"));
             sheepUpView = new ImageView(SheepUp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image SheepLeft;
    ImageView sheepLeftView;
    {
        try {
            SheepLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\left.png"));
             sheepLeftView = new ImageView(SheepLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image SheepDown;
    ImageView sheepDownView;
    {
        try {
            SheepDown = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\down.png"));
            sheepDownView = new ImageView(SheepDown);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image SheepDeath;
    ImageView sheepDeathView;
    {
        try {
            SheepDeath = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\death.png"));
            sheepDeathView = new ImageView(SheepDeath);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image SheepUpLeft;
    ImageView sheepUpLeftView;
    {
        try {
            SheepUpLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\up_left.png"));
            sheepUpLeftView = new ImageView(SheepUpLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image SheepDownLeft;
    ImageView sheepDownLefView;
    {
        try {
            SheepDownLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\down_left.png"));
            sheepDownLefView = new ImageView(SheepDownLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image SheepEat;
    ImageView sheepEatView;
    {
        try {
            SheepEat = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Sheep\\eat.png"));
            sheepEatView = new ImageView(SheepEat);

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
    public void produce(Ground ground) {
        ground.getCells()[this.row - 1][this.column - 1].setItemAmount(ground.getCells()[this.row - 1][this.column - 1].getItemAmount() + 1);
        ground.addItem(new Wool(this.row, this.column, "0", true , ground.getMainRoot()));
    }


}