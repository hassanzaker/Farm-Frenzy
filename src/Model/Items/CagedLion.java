package Model.Items;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CagedLion extends Item {
    private Image CagedLion;
    {
        try {
            CagedLion= new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Products\\CagedLion.png"));
            ImageView CagedLionView = new ImageView(CagedLion);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private final int buyCost = 150;
    private final int saleCost = 150;

    public CagedLion(int x, int y, String ID,Boolean inGrounad) {
        super(x, y, ID,inGrounad);
        this.setVolume(20);
        this.type="CagedLion";
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
