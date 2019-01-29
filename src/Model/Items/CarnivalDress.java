package Model.Items;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CarnivalDress extends Item {
    private Image CarnivalDress;
    {
        try {
            CarnivalDress= new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Products\\CarnivalDress.png"));
            ImageView CarnivalDressView = new ImageView(CarnivalDress);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private final int buyCost = 1400;
    private final int saleCost = 1300;

    public CarnivalDress(int x, int y, String ID, Boolean inGrounad) {
        super(x, y, ID,inGrounad);
        this.setVolume(8);
    }

    public int getBuyCost() {
        return buyCost;
    }

    public int getSaleCost() {
        return saleCost;
    }
}
