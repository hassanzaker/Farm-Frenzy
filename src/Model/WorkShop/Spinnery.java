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

public class Spinnery extends WorkShop {
    private Image Spinnery1;
    ImageView spinneryView1;
    {
        try {
            Spinnery1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Spinnery (Spinnery)\\01.png"));
             spinneryView1 = new ImageView(Spinnery1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Spinnery2;
    ImageView spinneryView2;
    {
        try {
            Spinnery2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Spinnery (Spinnery)\\02.png"));
             spinneryView2 = new ImageView(Spinnery2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Spinnery3;
    ImageView spinneryView3;
    {
        try {
            Spinnery3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Spinnery (Spinnery)\\03.png"));
             spinneryView3 = new ImageView(Spinnery3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Spinnery4;
    ImageView spinneryView4;
    {
        try {
            Spinnery4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Spinnery (Spinnery)\\04.png"));
             spinneryView4 = new ImageView(Spinnery4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image Spinnery5;
    ImageView spinneryView5;
    {
        try {
            Spinnery5 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Spinnery (Spinnery)\\05.png"));
             spinneryView5 = new ImageView(Spinnery5);

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
            this.setWorkShop(spinneryView1,520/4,424/4, 800 ,350 );
        }else if(this.level == 2){
            this.setWorkShop(spinneryView2,552/4,600/4, 800 ,350 );
        }else if(this.level == 3){
            this.setWorkShop(spinneryView3,712/4,584/4, 800 ,350 );
        }else if(this.level == 4){
            this.setWorkShop(spinneryView4,704/4,728/4, 800 ,350 );
        }else {
            this.setWorkShop(spinneryView5,640/4,656/4, 800 ,350 );
        }
    }
    public void remove(){
        this.mainRoot.getChildren().remove(spinneryView1);
        this.mainRoot.getChildren().remove(spinneryView2);
        this.mainRoot.getChildren().remove(spinneryView3);
        this.mainRoot.getChildren().remove(spinneryView4);
        this.mainRoot.getChildren().remove(spinneryView5);
    }
    public Spinnery(Group mainRoot , Ground ground) {
        super(4 , mainRoot, ground);
        inputs.add("Wool");
        outputs.add("Sewing");
        this.name = "Spinnery";
        this.show();
    }
}
