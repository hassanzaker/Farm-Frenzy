package Model.Items;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CagedBear extends Item {

    private Image image;
    ImageView imageView;
    {
        try {
            image= new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Products\\CagedGrizzly.png"));
             imageView= new ImageView(image);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private final int buyCost = 80;
    private final int saleCost = 80;

    public CagedBear(int x, int y, String ID, Boolean inGrounad , Group mainRoot) {
        super(x, y, ID, inGrounad , mainRoot);
        this.setVolume(20);
        this.type="CagedBear";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
