package Model.Items;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Flour extends Item {
    private Image image;
    ImageView imageView;
    {
        try {
            image= new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Products\\Flour.png"));
            imageView= new ImageView(image);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private final int buyCost = 20;
    private final int saleCost = 10;


    public Flour(int x, int y, String ID, Boolean inGrounad , Group mainRoot) {
        super(x, y, ID, inGrounad , mainRoot);
        this.setVolume(1);
        this.type="Flour";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
