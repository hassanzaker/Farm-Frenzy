package Model.Items;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Milk extends Item {
    private Image image;
    ImageView imageView;
    {
        try {
            image= new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Products\\Milk.png"));
            imageView= new ImageView(image);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private final int buyCost = 2000;
    private final int saleCost = 1000;

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }

    public Milk(int x, int y , String ID, Boolean inGrounad , Group mainRoot) {
        super(x, y , ID, inGrounad , mainRoot);
        this.setVolume(10);
        this.type="Milk";
    }

}
