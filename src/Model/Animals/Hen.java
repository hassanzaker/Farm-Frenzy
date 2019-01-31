package Model.Animals;

import Model.Ground;
import Model.Items.Egg;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Hen extends ProducerAnimal {
    private Image HenUp;
    ImageView HenUpView;
    {
        try {
            HenUp = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\up.png"));
            HenUpView = new ImageView(HenUp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image HenLeft;
    ImageView HenLeftView;
    {
        try {
            HenLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\left.png"));
            HenLeftView = new ImageView(HenLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image HenDown;
    ImageView HenDownView;
    {
        try {
            HenDown = new Image(new FileInputStream("CC:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\down.png"));
            HenDownView = new ImageView(HenDown);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image HenDeath;
    ImageView HenDeathView;
    {
        try {
            HenDeath = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\death.png"));
            HenDeathView = new ImageView(HenDeath);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image HenUpLeft;
    ImageView HenUpLeftView;
    {
        try {
            HenUpLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\up_left.png"));
            HenUpLeftView = new ImageView(HenUpLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image HenDownLeft;
    ImageView HenDownLefView;
    {
        try {
            HenDownLeft = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\down_left.png"));
            HenDownLefView = new ImageView(HenDownLeft);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Image HenEat;
    ImageView HenEatView;
    {
        try {
            HenEat = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Animals\\Africa\\Ostrich\\eat.png"));
            HenEatView = new ImageView(HenEat);

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
    public void produce(Ground ground) {
        ground.getCells()[this.row-1][this.column-1].setItemAmount(ground.getCells()[this.row-1][this.column-1].getItemAmount()+1);
        ground.addItem(new Egg(this.row, this.column, "0",true , ground.getMainRoot()));
    }



}