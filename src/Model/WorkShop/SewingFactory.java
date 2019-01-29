package Model.WorkShop;

import Model.Ground;
import View.Animations.SpriteAnimation.SpriteAnimation;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SewingFactory extends WorkShop{
    private Image SewingFactory1;
    ImageView sewingFactoryView1;
    {
        try {
            SewingFactory1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\CarnivalDress (Sewing Factory)\\01.png"));
             sewingFactoryView1 = new ImageView(SewingFactory1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image SewingFactory2;
    ImageView sewingFactoryView2;
    {
        try {
            SewingFactory2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\CarnivalDress (Sewing Factory)\\02.png"));
             sewingFactoryView2 = new ImageView(SewingFactory2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image SewingFactory3;
    ImageView sewingFactoryView3;
    {
        try {
            SewingFactory3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\CarnivalDress (Sewing Factory)\\03.png"));
             sewingFactoryView3 = new ImageView(SewingFactory3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image SewingFactory4;
    ImageView sewingFactoryView4;
    {
        try {
            SewingFactory4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\CarnivalDress (Sewing Factory)\\04.png"));
             sewingFactoryView4 = new ImageView(SewingFactory4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image SewingFactory5;
    ImageView sewingFactoryView5;
    {
        try {
            SewingFactory5 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\CarnivalDress (Sewing Factory)\\05.png"));
             sewingFactoryView5 = new ImageView(SewingFactory5);

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
            this.setWorkShop(sewingFactoryView1,680/4,520/4, 800 ,250 );
        }else if(this.level == 2){
            this.setWorkShop(sewingFactoryView2,792/4,568/4, 800 ,250 );
        }else if(this.level == 3){
            this.setWorkShop(sewingFactoryView3,784/4,608/4, 800 ,250 );
        }else if(this.level == 4){
            this.setWorkShop(sewingFactoryView4,784/4,616/4, 800 ,250 );
        }else {
            this.setWorkShop(sewingFactoryView5,792/4,728/4, 800 ,250 );
        }
    }
    public void remove(){
        this.mainRoot.getChildren().remove(sewingFactoryView1);
        this.mainRoot.getChildren().remove(sewingFactoryView2);
        this.mainRoot.getChildren().remove(sewingFactoryView3);
        this.mainRoot.getChildren().remove(sewingFactoryView4);
        this.mainRoot.getChildren().remove(sewingFactoryView5);
    }
    public SewingFactory(Group mainRoot , Ground ground) {
        super(6 , mainRoot , ground);
        inputs.add("Fabric");
        inputs.add("ColoredPlume");
        outputs.add("CarnivalDress");
        this.name = "SewingFactory";
        this.show();
    }

}
