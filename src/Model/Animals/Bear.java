package Model.Animals;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Bear extends WildAnimal {
    private Image BearUp;
    {
        try {
            BearUp = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\up.png"));
            ImageView wellView = new ImageView(BearUp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BearLeft;
    {
        try {
            BearLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\left.png"));
            ImageView wellView = new ImageView(BearLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BearDown;
    {
        try {
            BearDown = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\down.png"));
            ImageView wellView = new ImageView(BearDown);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BearCaged;
    {
        try {
            BearCaged = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\caged.png"));
            ImageView wellView = new ImageView(BearCaged);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BearUpLeft;
    {
        try {
            BearUpLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\up_left.png"));
            ImageView wellView = new ImageView(BearUpLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image BearDownLeft;
    {
        try {
            BearDownLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Grizzly\\down_left.png"));
            ImageView wellView = new ImageView(BearDownLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Bear(int x, int y, String ID) {
        super(x, y, ID);
        this.name = "bear";
    }


    @Override
    public void eat() {

    }


}