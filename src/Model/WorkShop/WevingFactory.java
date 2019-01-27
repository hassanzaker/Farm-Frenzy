package Model.WorkShop;

import Model.WorkShop.WorkShop;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class WevingFactory extends WorkShop {
    private Image WevingFactory1;
    {
        try {
            WevingFactory1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Weaving (Weaving Factory)\\01.png"));
            ImageView wevingFactoryView1 = new ImageView(WevingFactory1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image WevingFactory2;
    {
        try {
            WevingFactory2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Weaving (Weaving Factory)\\02.png"));
            ImageView wevingFactoryView2 = new ImageView(WevingFactory2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image WevingFactory3;
    {
        try {
            WevingFactory3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Weaving (Weaving Factory)\\03.png"));
            ImageView wevingFactoryView3 = new ImageView(WevingFactory3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image WevingFactory4;
    {
        try {
            WevingFactory4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Weaving (Weaving Factory)\\04.png"));
            ImageView wevingFactoryView4 = new ImageView(WevingFactory4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image WevingFactory5;
    {
        try {
            WevingFactory5 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Weaving (Weaving Factory)\\05.png"));
            ImageView wevingFactoryView5 = new ImageView(WevingFactory5);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public WevingFactory() {
        super(5);
        inputs.add("Sewing");
        outputs.add("Fabric");
        this.name = "WevingFactory";
    }
}
