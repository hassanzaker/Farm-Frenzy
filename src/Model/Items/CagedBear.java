package Model.Items;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CagedBear extends Item {
    private Image CagedBear;
    {
        try {
            CagedBear= new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Products\\CagedGrizzly.png"));
            ImageView CagedBearView = new ImageView(CagedBear);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private final int buyCost = 80;
    private final int saleCost = 80;

    public CagedBear(int x, int y, String ID,Boolean inGrounad) {
        super(x, y, ID, inGrounad);
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
