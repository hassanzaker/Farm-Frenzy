package Model.WorkShop;

import Model.Ground;
import Model.Items.Cookie;
import Model.Items.EggPowder;
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

public class CookieBakery extends WorkShop {
    private Image CookieBakery1;
    ImageView cookieBakeryView1;
    {
        try {
            CookieBakery1 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Cake (Cookie Bakery)\\01.png"));
            cookieBakeryView1 = new ImageView(CookieBakery1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image CookieBakery2;
    ImageView cookieBakeryView2;
    {
        try {
            CookieBakery2 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Cake (Cookie Bakery)\\02.png"));
             cookieBakeryView2 = new ImageView(CookieBakery2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image CookieBakery3;
    ImageView cookieBakeryView3;
    {
        try {
            CookieBakery3 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Cake (Cookie Bakery)\\03.png"));
             cookieBakeryView3 = new ImageView(CookieBakery3);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image CookieBakery4;
    ImageView cookieBakeryView4;
    {
        try {
            CookieBakery4 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Cake (Cookie Bakery)\\04.png"));
            cookieBakeryView4 = new ImageView(CookieBakery4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Image CookieBakery5;
    ImageView cookieBakeryView5;
    {
        try {
            CookieBakery5 = new Image(new FileInputStream("C:\\Users\\zabba\\Desktop\\Textures\\Workshops\\Cake (Cookie Bakery)\\05.png"));
            cookieBakeryView5 = new ImageView(CookieBakery5);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void show(){
        cookieBakeryView1.setViewport(new Rectangle2D(0, 0, 536/4, 568/4));
        cookieBakeryView1.setX(800);
        cookieBakeryView1.setY(300);
        this.mainRoot.getChildren().add(cookieBakeryView1);
        cookieBakeryView1.setOnMouseClicked(event -> {
            final Animation animation =
                    new SpriteAnimation(cookieBakeryView1, Duration.millis(1000), 16, 4, 0, 0, 536/4, 568/4);
            animation.setCycleCount(timeToWork);
            animation.play();
        });
    }
    public void remove(){
        this.mainRoot.getChildren().remove(cookieBakeryView1);
        this.mainRoot.getChildren().remove(cookieBakeryView2);
        this.mainRoot.getChildren().remove(cookieBakeryView3);
        this.mainRoot.getChildren().remove(cookieBakeryView4);
        this.mainRoot.getChildren().remove(cookieBakeryView5);
    }
    public CookieBakery(Group mainRoot) {
        super(2 , mainRoot);
        inputs.add("EggPowder");
        outputs.add("Cookie");
        this.name = "CookieBakery";
    }
}
