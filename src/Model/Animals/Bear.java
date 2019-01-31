package Model.Animals;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Bear extends WildAnimal {
    private Image BearUp;
    ImageView BearUpView;
    {
        try {
            BearUp = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\up.png"));
            BearUpView = new ImageView(BearUp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BearLeft;
    ImageView BearLeftView;
    {
        try {
            BearLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\left.png"));
             BearLeftView = new ImageView(BearLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BearDown;
    ImageView BearDownView;
    {
        try {
            BearDown = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\down.png"));
            BearDownView = new ImageView(BearDown);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BearCaged;
    ImageView BearCagedView;
    {
        try {
            BearCaged = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\caged.png"));
            BearCagedView = new ImageView(BearCaged);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BearUpLeft;
    ImageView BearUpLeftView;
    {
        try {
            BearUpLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\up_left.png"));
             BearUpLeftView = new ImageView(BearUpLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BearDownLeft;
    ImageView BearDownLeftView;
    {
        try {
            BearDownLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\down_left.png"));
            BearDownLeftView = new ImageView(BearDownLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Bear(int x, int y, String ID , Group mainRoot) {
        super(x, y, ID ,mainRoot);
        this.name = "bear";

    }


    @Override
    public void eat() {

    }


}