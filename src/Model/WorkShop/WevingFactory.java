package Model.WorkShop;

import Model.Ground;
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
    public void setWorkShop(ImageView imageView , int width , int height , double x , double y){
        imageView.setViewport(new Rectangle2D(0 , 0 , width , height));
        imageView.setX(x);
        imageView.setY(y);
        this.mainRoot.getChildren().add(imageView);
        imageView.setOnMouseClicked(event -> {
            final Animation animation =
                    new SpriteAnimation(imageView, Duration.millis(1000), 16, 4, 0, 0, width, height);
            animation.setCycleCount(timeToWork);
            animation.play();
            //    this.upgrade();
            this.workShopInput();
        });
    }
    public void show(){
        if(this.level == 1) {
            this.setWorkShop(wevingFactoryView1,664/4,464/4, 800 ,150 );
        }else if(this.level == 2){
            this.setWorkShop(wevingFactoryView2,592/4,528/4, 800 ,150 );
        }else if(this.level == 3){
            this.setWorkShop(wevingFactoryView3,656/4,504/4, 800 ,150 );
        }else if(this.level == 4){
            this.setWorkShop(wevingFactoryView4,592/4,624/4, 800 ,150 );
        }else {
            this.setWorkShop(wevingFactoryView5,704/4,616/4, 800 ,150 );
        }
    }
    public void remove(){
        this.mainRoot.getChildren().remove(wevingFactoryView1);
        this.mainRoot.getChildren().remove(wevingFactoryView2);
        this.mainRoot.getChildren().remove(wevingFactoryView3);
        this.mainRoot.getChildren().remove(wevingFactoryView4);
        this.mainRoot.getChildren().remove(wevingFactoryView5);
    }
    public WevingFactory(Group mainRoot , Ground ground) {
        super(5, mainRoot , ground);
        inputs.add("Sewing");
        outputs.add("Fabric");
        this.name = "WevingFactory";
        this.show();
    }

    public Image getWevingFactory1() {
        return WevingFactory1;
    }

    public void setWevingFactory1(Image wevingFactory1) {
        WevingFactory1 = wevingFactory1;
    }

    public ImageView getWevingFactoryView1() {
        return wevingFactoryView1;
    }

    public void setWevingFactoryView1(ImageView wevingFactoryView1) {
        this.wevingFactoryView1 = wevingFactoryView1;
    }

    public Image getWevingFactory2() {
        return WevingFactory2;
    }

    public void setWevingFactory2(Image wevingFactory2) {
        WevingFactory2 = wevingFactory2;
    }

    public ImageView getWevingFactoryView2() {
        return wevingFactoryView2;
    }

    public void setWevingFactoryView2(ImageView wevingFactoryView2) {
        this.wevingFactoryView2 = wevingFactoryView2;
    }

    public Image getWevingFactory3() {
        return WevingFactory3;
    }

    public void setWevingFactory3(Image wevingFactory3) {
        WevingFactory3 = wevingFactory3;
    }

    public ImageView getWevingFactoryView3() {
        return wevingFactoryView3;
    }

    public void setWevingFactoryView3(ImageView wevingFactoryView3) {
        this.wevingFactoryView3 = wevingFactoryView3;
    }

    public Image getWevingFactory4() {
        return WevingFactory4;
    }

    public void setWevingFactory4(Image wevingFactory4) {
        WevingFactory4 = wevingFactory4;
    }

    public ImageView getWevingFactoryView4() {
        return wevingFactoryView4;
    }

    public void setWevingFactoryView4(ImageView wevingFactoryView4) {
        this.wevingFactoryView4 = wevingFactoryView4;
    }

    public Image getWevingFactory5() {
        return WevingFactory5;
    }

    public void setWevingFactory5(Image wevingFactory5) {
        WevingFactory5 = wevingFactory5;
    }

    public ImageView getWevingFactoryView5() {
        return wevingFactoryView5;
    }

    public void setWevingFactoryView5(ImageView wevingFactoryView5) {
        this.wevingFactoryView5 = wevingFactoryView5;
    }
}
