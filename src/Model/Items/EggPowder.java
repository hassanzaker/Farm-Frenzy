package Model.Items;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EggPowder extends Item {
    private Image image;
    ImageView imageView;
    {
        try {
            image= new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Products\\EggPowder.png"));
            imageView= new ImageView(image);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final int buyCost = 100;
    private final int saleCost = 50;


    public EggPowder(int x, int y, String ID, Boolean inGrounad , Group maiRoot) {
        super(x, y, ID,inGrounad , maiRoot);
        this.setVolume(4);
        this.type="EggPowder";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
