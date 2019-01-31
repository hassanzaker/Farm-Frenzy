package Model.Items;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Sewing extends Item {
    private Image image;
    ImageView imageView;
    {
        try {
            image= new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Products\\Sewing.png"));
            imageView= new ImageView(image);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private final int buyCost = 300;
    private final int saleCost = 150;

    public Sewing(int x, int y, String ID, Boolean inGrounad , Group mainRoot) {
        super(x, y, ID, inGrounad , mainRoot);
        this.setVolume(3);
        this.type="Sewing";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
