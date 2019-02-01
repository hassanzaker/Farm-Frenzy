package Model.WorkShop;

import Model.Ground;
import View.SpriteAnimation.SpriteAnimation;
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
            try {
                this.workShopInput();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public void show(){
        if(this.level == 1) {
            this.setWorkShop(cookieBakeryView1,536/4,568/4, 100 ,330 );
        }else if(this.level == 2){
            this.setWorkShop(cookieBakeryView2,632/4,600/4, 110 ,330 );
        }else if(this.level == 3){
            this.setWorkShop(cookieBakeryView3,632/4,664/4, 110 ,330 );
        }else if(this.level == 4){
            this.setWorkShop(cookieBakeryView4,664/4,680/4, 110 ,330 );
        }else {
            this.setWorkShop(cookieBakeryView5,744/4,736/4, 110 ,330 );
        }

    }
    public void remove(){
        this.mainRoot.getChildren().remove(cookieBakeryView1);
        this.mainRoot.getChildren().remove(cookieBakeryView2);
        this.mainRoot.getChildren().remove(cookieBakeryView3);
        this.mainRoot.getChildren().remove(cookieBakeryView4);
        this.mainRoot.getChildren().remove(cookieBakeryView5);
    }
    public CookieBakery(Group mainRoot , Ground ground) {
        super(2 , mainRoot , ground);
        inputs.add("EggPowder");
        outputs.add("Cookie");
        this.name = "CookieBakery";
        this.show();
    }

    public Image getCookieBakery1() {
        return CookieBakery1;
    }

    public void setCookieBakery1(Image cookieBakery1) {
        CookieBakery1 = cookieBakery1;
    }

    public ImageView getCookieBakeryView1() {
        return cookieBakeryView1;
    }

    public void setCookieBakeryView1(ImageView cookieBakeryView1) {
        this.cookieBakeryView1 = cookieBakeryView1;
    }

    public Image getCookieBakery2() {
        return CookieBakery2;
    }

    public void setCookieBakery2(Image cookieBakery2) {
        CookieBakery2 = cookieBakery2;
    }

    public ImageView getCookieBakeryView2() {
        return cookieBakeryView2;
    }

    public void setCookieBakeryView2(ImageView cookieBakeryView2) {
        this.cookieBakeryView2 = cookieBakeryView2;
    }

    public Image getCookieBakery3() {
        return CookieBakery3;
    }

    public void setCookieBakery3(Image cookieBakery3) {
        CookieBakery3 = cookieBakery3;
    }

    public ImageView getCookieBakeryView3() {
        return cookieBakeryView3;
    }

    public void setCookieBakeryView3(ImageView cookieBakeryView3) {
        this.cookieBakeryView3 = cookieBakeryView3;
    }

    public Image getCookieBakery4() {
        return CookieBakery4;
    }

    public void setCookieBakery4(Image cookieBakery4) {
        CookieBakery4 = cookieBakery4;
    }

    public ImageView getCookieBakeryView4() {
        return cookieBakeryView4;
    }

    public void setCookieBakeryView4(ImageView cookieBakeryView4) {
        this.cookieBakeryView4 = cookieBakeryView4;
    }

    public Image getCookieBakery5() {
        return CookieBakery5;
    }

    public void setCookieBakery5(Image cookieBakery5) {
        CookieBakery5 = cookieBakery5;
    }

    public ImageView getCookieBakeryView5() {
        return cookieBakeryView5;
    }

    public void setCookieBakeryView5(ImageView cookieBakeryView5) {
        this.cookieBakeryView5 = cookieBakeryView5;
    }
}
