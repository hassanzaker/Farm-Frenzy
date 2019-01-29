package Model.Items;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Cake extends Item {
    private Image Cake;
    {
        try {
            Cake= new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Products\\Cake.png"));
            ImageView CakeView = new ImageView(Cake);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private final int buyCost = 400;
    private final int saleCost = 200;

    public Cake(int x, int y, String ID, Boolean inGrounad) {
        super(x, y, ID,inGrounad);
        this.setVolume(6);
        this.type="Cake";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}

