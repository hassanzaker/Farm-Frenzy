package Model.Animals;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Lion extends WildAnimal {

    private Image LionUp;
    {
        try {
            LionUp = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\up.png"));
            ImageView lionUpView = new ImageView(LionUp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image LionLeft;
    {
        try {
            LionLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\left.png"));
            ImageView lionLeftView = new ImageView(LionLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image LionDown;
    {
        try {
            LionDown = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\down.png"));
            ImageView lionDownView = new ImageView(LionDown);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image LionCaged;
    {
        try {
            LionCaged = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\caged.png"));
            ImageView lionCagedView = new ImageView(LionCaged);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image LionUpLeft;
    {
        try {
            LionUpLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\up_left.png"));
            ImageView lionUpLeftView = new ImageView(LionUpLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image LionDownLeft;
    {
        try {
            LionLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Lion\\down_left.png"));
            ImageView lionDownLeftView = new ImageView(LionLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Lion(int x, int y, String ID) {
        super(x, y, ID);
        this.name = "lion";
    }

    @Override
    public void eat() {

    }

}
