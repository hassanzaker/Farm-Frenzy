package Model.Animals;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Lion extends WildAnimal {

    private Image LionUp;
    ImageView lionUpView;
    {
        try {
            LionUp = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\up.png"));
            lionUpView = new ImageView(LionUp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image LionLeft;
    ImageView lionLeftView;
    {
        try {
            LionLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\left.png"));
             lionLeftView = new ImageView(LionLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image LionDown;
    ImageView lionDownView;
    {
        try {
            LionDown = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\down.png"));
             lionDownView = new ImageView(LionDown);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image LionCaged;
    ImageView lionCagedView;
    {
        try {
            LionCaged = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\caged.png"));
             lionCagedView = new ImageView(LionCaged);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image LionUpLeft;
    ImageView lionUpLeftView;
    {
        try {
            LionUpLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\up_left.png"));
            lionUpLeftView = new ImageView(LionUpLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image LionDownLeft;
    ImageView lionDownLeftView;
    {
        try {
            LionDownLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\down_left.png"));
             lionDownLeftView = new ImageView(LionDownLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Lion(int x, int y, String ID , Group mainRoot) {
        super(x, y, ID , mainRoot);
        this.name = "lion";
    }

    @Override
    public void eat() {

    }

}
