package Model.WorkShop;

import Model.WorkShop.WorkShop;
import View.Animations.SpriteAnimation.SpriteAnimation;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class WevingFactory extends WorkShop {
    private Image WevingFactory1;
    ImageView wevingFactoryView1;
    {
        try {
            WevingFactory1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Weaving (Weaving Factory)\\01.png"));
             wevingFactoryView1 = new ImageView(WevingFactory1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image WevingFactory2;
    ImageView wevingFactoryView2;
    {
        try {
            WevingFactory2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Weaving (Weaving Factory)\\02.png"));
             wevingFactoryView2 = new ImageView(WevingFactory2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image WevingFactory3;
    ImageView wevingFactoryView3;
    {
        try {
            WevingFactory3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Weaving (Weaving Factory)\\03.png"));
             wevingFactoryView3 = new ImageView(WevingFactory3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image WevingFactory4;
    ImageView wevingFactoryView4;
    {
        try {
            WevingFactory4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Weaving (Weaving Factory)\\04.png"));
             wevingFactoryView4 = new ImageView(WevingFactory4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image WevingFactory5;
    ImageView wevingFactoryView5;
    {
        try {
            WevingFactory5 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Weaving (Weaving Factory)\\05.png"));
             wevingFactoryView5 = new ImageView(WevingFactory5);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void show(){
        if(level==1){
      this.setWorkShop(wevingFactoryView1 , );
    }
    public void remove(){
        this.mainRoot.getChildren().remove(wevingFactoryView1);
        this.mainRoot.getChildren().remove(wevingFactoryView2);
        this.mainRoot.getChildren().remove(wevingFactoryView3);
        this.mainRoot.getChildren().remove(wevingFactoryView4);
        this.mainRoot.getChildren().remove(wevingFactoryView5);
    }
    public WevingFactory(Group mainRoot) {
        super(5, mainRoot);
        inputs.add("Sewing");
        outputs.add("Fabric");
        this.name = "WevingFactory";
    }
}
